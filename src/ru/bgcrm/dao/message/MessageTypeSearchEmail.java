package ru.bgcrm.dao.message;

import java.util.Set;

import ru.bgcrm.cache.ParameterCache;
import ru.bgcrm.dao.CustomerDAO;
import ru.bgcrm.model.BGException;
import ru.bgcrm.model.CommonObjectLink;
import ru.bgcrm.model.Customer;
import ru.bgcrm.model.SearchResult;
import ru.bgcrm.model.message.Message;
import ru.bgcrm.model.param.ParameterSearchedObject;
import ru.bgcrm.struts.form.DynActionForm;
import ru.bgcrm.util.ParameterMap;
import ru.bgcrm.util.Utils;
import ru.bgcrm.util.sql.ConnectionSet;

// TODO: Сделать параметры с конфигурацией что искать.
public class MessageTypeSearchEmail extends MessageTypeSearch {
    public MessageTypeSearchEmail(ParameterMap config) throws BGException {
        super(config);
    }

    @Override
    public void search(DynActionForm form, ConnectionSet conSet, Message message, Set<CommonObjectLink> result) throws BGException {
        String email = message.getFrom();

        SearchResult<ParameterSearchedObject<Customer>> searchResult = new SearchResult<ParameterSearchedObject<Customer>>();
        new CustomerDAO(conSet.getConnection()).searchCustomerListByEmail(searchResult,
                Utils.getObjectIdsList(ParameterCache.getObjectTypeParameterList(Customer.OBJECT_TYPE)), email);

        for (ParameterSearchedObject<Customer> object : searchResult.getList()) {
            result.add(new CommonObjectLink(0, Customer.OBJECT_TYPE, object.getObject().getId(), object.getObject().getTitle()));
        }
    }
}
