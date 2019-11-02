package ru.bgcrm.event.listener;

import java.util.Set;

import ru.bgcrm.dao.SphinxDAO;
import ru.bgcrm.event.CustomerDeleteEvent;
import ru.bgcrm.event.CustomerUpdateEvent;
import ru.bgcrm.event.Event;
import ru.bgcrm.event.EventProcessor;
import ru.bgcrm.event.ParamChangedEvent;
import ru.bgcrm.model.BGException;
import ru.bgcrm.util.Setup;
import ru.bgcrm.util.Utils;
import ru.bgcrm.util.sql.ConnectionSet;

@Deprecated
public class SphinxSystemListener
	extends DynamicEventListener
{
	public SphinxSystemListener()
	{
    	EventProcessor.subscribe( this, ParamChangedEvent.class );
    	EventProcessor.subscribe( this, CustomerDeleteEvent.class );
    	EventProcessor.subscribe( this, CustomerUpdateEvent.class );
    }
	
	@Override
	public void notify( Event e, ConnectionSet connectionSet )
    	throws BGException
    {
		if( Setup.getSetup().sub( "sphinx." ).size() > 0 )
		{
    		if( e instanceof ParamChangedEvent )
        	{
        		ParamChangedEvent event = (ParamChangedEvent)e;
        		Set<Integer> customerParamIds = Utils.toIntegerSet( Setup.getSetup().get( "sphinx.customerParamIds" ) );
        
        		if( customerParamIds.contains( event.getParameter().getId() ) )
        		{
        			SphinxDAO.customerCacheUpdate( connectionSet.getConnection(), event.getObjectId() );
        		}
        	}
        	else if( e instanceof CustomerDeleteEvent )
    		{
    			CustomerDeleteEvent event = (CustomerDeleteEvent)e;
    			SphinxDAO sphinxDAO = new SphinxDAO( connectionSet.getConnection() );
    			sphinxDAO.delete( event.getCustomerId() );
    		}
        	else if( e instanceof CustomerUpdateEvent )
    		{
    			CustomerUpdateEvent event = (CustomerUpdateEvent)e;
    			SphinxDAO.customerCacheUpdate( connectionSet.getConnection(), event.getCustomerId() );
    		}
		}
	}
}
