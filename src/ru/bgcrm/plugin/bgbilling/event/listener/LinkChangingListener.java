package ru.bgcrm.plugin.bgbilling.event.listener;

import org.apache.commons.lang.StringUtils;

import ru.bgcrm.event.EventProcessor;
import ru.bgcrm.event.link.LinkAddingEvent;
import ru.bgcrm.event.link.LinksToRemovingEvent;
import ru.bgcrm.event.listener.EventListener;
import ru.bgcrm.model.BGException;
import ru.bgcrm.model.BGMessageException;
import ru.bgcrm.model.CommonObjectLink;
import ru.bgcrm.model.Customer;
import ru.bgcrm.plugin.bgbilling.DBInfo;
import ru.bgcrm.plugin.bgbilling.DBInfoManager;
import ru.bgcrm.plugin.bgbilling.proto.dao.ContractParamDAO;
import ru.bgcrm.util.sql.ConnectionSet;

/**
 * Слушатель события перед изменениями привязок.
 * Проверяет возможность и производит привязку/отвязку договора биллинга от контрагента.
 */
public class LinkChangingListener
{
	public LinkChangingListener()
	{
		EventProcessor.subscribe( new EventListener<LinkAddingEvent>()
   	    {
   	    	@Override
   	    	public void notify( LinkAddingEvent e, ConnectionSet connectionSet )
   	    		throws BGException
   	    	{
   	    		customerChanging( e, e.getLink().getObjectId() );
   	    	}
   	    }, LinkAddingEvent.class );
		
		EventProcessor.subscribe( new EventListener<LinksToRemovingEvent>()
 	    {
 	    	@Override
 	    	public void notify( LinksToRemovingEvent e, ConnectionSet connectionSet )
 	    		throws BGException
 	    	{
 	    		customerChanging( e, 0 );
 	    	}
 	    }, LinksToRemovingEvent.class );
	}
	
	private void customerChanging( LinkAddingEvent event, int customerId )
		throws BGException
	{
		CommonObjectLink link = event.getLink();
		if( !Customer.OBJECT_TYPE.equals( link.getObjectType() ) ||
			!link.getLinkedObjectType().startsWith( "contract:" ) )
		{
			return;
		}
		
		String billingId = StringUtils.substringAfter( link.getLinkedObjectType(), ":" );
		DBInfo dbInfo = DBInfoManager.getInstance().getDbInfoMap().get( billingId );
		
		if( dbInfo == null )
		{
			throw new BGMessageException( "Не найден биллинг с идентификатором: " + billingId );
		}

		int customerIdParam = dbInfo.getCustomerIdParam();
		if( customerIdParam <= 0 )
		{
			throw new BGMessageException( "Не определён параметр 'customerIdParam' для сервера." );
		}
		
		int contractId = link.getLinkedObjectId();
		try
        {
			ContractParamDAO contractParamDAO = new ContractParamDAO( event.getUser(), dbInfo );

			// пустая строка а не 0, т.к. по нулю будет импортировать его сразу же пытаться.
			contractParamDAO.updateTextParameter( contractId, customerIdParam, customerId > 0 ? String.valueOf( customerId ) : "" );
        }
        catch( Exception e )
        {
	        throw new BGException( "Ошибка привязки договора к контрагенту: " + e.getMessage(), e );
        }
	}
}