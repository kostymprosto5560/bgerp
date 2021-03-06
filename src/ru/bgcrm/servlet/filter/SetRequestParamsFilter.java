package ru.bgcrm.servlet.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import ru.bgcrm.cache.CustomerGroupCache;
import ru.bgcrm.cache.ParameterCache;
import ru.bgcrm.cache.ProcessQueueCache;
import ru.bgcrm.cache.ProcessTypeCache;
import ru.bgcrm.cache.UserCache;
import ru.bgcrm.cache.UserGroupRoleCache;
import ru.bgcrm.model.process.TypeTreeItem;
import ru.bgcrm.model.user.User;
import ru.bgcrm.plugin.PluginManager;
import ru.bgcrm.util.Setup;
import ru.bgcrm.util.sql.ConnectionSet;
import ru.bgerp.i18n.Localization;

public class SetRequestParamsFilter implements Filter {

    public void destroy() {}

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        Map<String, Object> variables = getContextVariables((HttpServletRequest) request);
        for (Map.Entry<String, Object> me : variables.entrySet()) {
            request.setAttribute(me.getKey(), me.getValue());
        }

        //TODO: Документировать и переместить в общую функцию
        ConnectionSet conSet = new ConnectionSet(Setup.getSetup().getConnectionPool(), true);
        request.setAttribute("ctxConSet", conSet);

        request.setAttribute("l", Localization.getLocalizer((HttpServletRequest) request));

        chain.doFilter(request, response);

        conSet.recycle();
    }

    /**
     * Метод устанавливает в HttpRequest либо другой контекст следующие объекты:<br/>
     * <b>ctxSetup</b>  {@link Setup#getSetup} глобальная конфигурация<br/>
     * 
     * <b>ctxCustomerGroupMap</b>  {@link CustomerGroupCache#getGroupMap()} Map с группами контрагентов<br/>
     * <b>ctxCustomerGroupList</b>  {@link CustomerGroupCache#getGroupList()} List с группами контрагентов<br/>
     * 
     * <b>ctxUser</b>  {@link User} текущий пользователь<br/>
     * 
     * <b>ctxPluginManager</b>  {@link PluginManager#getInstance()}<br/>
     * 
     * <b>ctxUserList</b>  {@link UserCache#getUserList()} List с пользователями системы<br/>
     * <b>ctxUserMap</b>  {@link UserCache#getUserMap()} Map с пользователями системы<br/>
     * 
     * <b>ctxUserGroupRoleList</b>  {@link UserGroupRoleCache#getUserGroupRoleList()} List с ролями групп в процессах<br/>
     * <b>ctxUserGroupRoleMap</b>  {@link UserGroupRoleCache#getUserGroupRoleMap()} Map с ролями групп в процессах<br/>
     * 
     * <b>ctxUserGroupList</b>  {@link UserCache#getUserGroupList()} List с группами пользователей<br/>
     * <b>ctxUserGroupMap</b>  {@link UserCache#getUserGroupMap()} Map с группами пользователей<br/>
     * <b>ctxUserGroupFullTitledList</b>  {@link UserCache#getUserGroupFullTitledList()} List с группами пользователей, наименования групп включают полный путь<br/>
     * <b>ctxUserGroupFullTitledMap</b>  {@link UserCache#getUserGroupFullTitledList()} Map с группами пользователей, наименования групп включают полный путь<br/>
     * 
     * <b>ctxUserPermsetList</b>  {@link UserCache#getUserPermsetList()} List с наборами прав пользователей<br/>
     * <b>ctxUserPermsetMap</b>  {@link UserCache#getUserPermsetMap()} Map с наборами прав пользователей<br/>
     * 
     * <b>ctxDataSource</b>  {@link Setup#getDataSource()} DataSource - пул соединений с БД для использования в JSP<br/>
     * <b>ctxSlaveDataSource</b>  {@link Setup#getSlaveDataSource()} DataSource - пул соединений с Slave БД для использования в JSP<br/>
     * 
     * <b>ctxProcessTypeMap</b>  {@link ProcessTypeCache#getProcessTypeMap()} Map с типами процессов<br/>
     * <b>ctxProcessTypeTreeRoot</b> {@link TypeTreeItem} - корневой узел дерева процессов<br/>
     * <b>ctxProcessStatusList</b>  {@link ProcessTypeCache#getProcessStatusList()} List со статусами процессов<br/>
     * <b>ctxProcessStatusMap</b>  {@link ProcessTypeCache#getProcessStatusMap()} Map со статусами процессов<br/>
     * <b>ctxProcessQueueMap</b>  {@link ProcessTypeCache#getProcessQueueMap()} Map с очередями процессов<br/>
     * <b>ctxProcessQueueList</b>  {@link ProcessTypeCache#getProcessQueueList()} List с очередями процессов<br/>
     * 
     * <b>ctxParameterMap</b>  {@link ParameterCache#getParameterMap()} Map с параметрами<br/>
     * <br/>
     */
    public static Map<String, Object> getContextVariables(HttpServletRequest request) {
        Map<String, Object> result = new HashMap<String, Object>(30);

        //TODO: Убрать не ctx переменные в дальнейшем, после проверки, что нигде не используется.
        //Переменные ctx запрещено использовать в акшенах.
        result.put("ctxSetup", Setup.getSetup());
        result.put("setup", Setup.getSetup());

        result.put("ctxCustomerGroupMap", CustomerGroupCache.getGroupMap());
        result.put("ctxCustomerGroupList", CustomerGroupCache.getGroupList());

        if (request != null) {
            result.put("ctxUser", AuthFilter.getUser(request));
        }
        result.put("ctxPluginManager", PluginManager.getInstance());

        result.put("ctxUserList", UserCache.getUserList());
        result.put("userList", UserCache.getUserList());

        result.put("ctxUserMap", UserCache.getUserMap());

        result.put("ctxUserGroupRoleList", UserGroupRoleCache.getUserGroupRoleList());
        result.put("ctxUserGroupRoleMap", UserGroupRoleCache.getUserGroupRoleMap());

        result.put("ctxUserGroupList", UserCache.getUserGroupList());
        result.put("ctxUserGroupMap", UserCache.getUserGroupMap());
        result.put("ctxUserGroupFullTitledList", UserCache.getUserGroupFullTitledList());
        result.put("ctxUserGroupFullTitledMap", UserCache.getUserGroupFullTitledMap());

        result.put("ctxUserPermsetList", UserCache.getUserPermsetList());
        result.put("ctxUserPermsetMap", UserCache.getUserPermsetMap());

        result.put("ctxDataSource", Setup.getSetup().getDataSource());
        result.put("dataSource", Setup.getSetup().getDataSource());

        result.put("ctxSlaveDataSource", Setup.getSetup().getSlaveDataSource());
        result.put("slaveDataSource", Setup.getSetup().getSlaveDataSource());

        result.put("ctxProcessTypeMap", ProcessTypeCache.getProcessTypeMap());
        result.put("ctxProcessTypeTreeRoot", ProcessTypeCache.getTypeTreeRoot());
        result.put("ctxProcessStatusList", ProcessTypeCache.getStatusList());
        result.put("ctxProcessStatusMap", ProcessTypeCache.getStatusMap());
        result.put("ctxProcessQueueMap", ProcessQueueCache.getQueueMap());
        result.put("ctxProcessQueueList", ProcessQueueCache.getQueueList());

        result.put("ctxParameterMap", ParameterCache.getParameterMap());

        //FIXME: Не описаны в JavaDoc, т.к. пока не реализовано
        //result.put("ctxAppointmentList", AppointmentCache.getAppointmentList());
        //result.put("ctxAppointmentMap", AppointmentCache.getAppointmentMapByIds());

        return result;
    }

    public void init(FilterConfig filterConfig) throws ServletException {
    }
}