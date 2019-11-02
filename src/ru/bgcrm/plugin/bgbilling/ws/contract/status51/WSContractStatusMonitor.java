
package ru.bgcrm.plugin.bgbilling.ws.contract.status51;

import java.math.BigDecimal;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.util.Date;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "WSContractStatusMonitor", targetNamespace = "http://common.status.contract.kernel.bgbilling.bitel.ru/")
@XmlSeeAlso({
    ObjectFactory.class
})
@Deprecated
public interface WSContractStatusMonitor {


    /**
     * 
     * @param arg4
     * @param arg3
     * @param arg2
     * @param arg1
     * @param arg0
     * @throws BGException_Exception
     */
    @WebMethod
    @RequestWrapper(localName = "changeContractStatus", targetNamespace = "http://common.status.contract.kernel.bgbilling.bitel.ru/", className = "ru.bgcrm.plugin.bgbilling.ws.contract.status51.ChangeContractStatus")
    @ResponseWrapper(localName = "changeContractStatusResponse", targetNamespace = "http://common.status.contract.kernel.bgbilling.bitel.ru/", className = "ru.bgcrm.plugin.bgbilling.ws.contract.status51.ChangeContractStatusResponse")
    @Action(input = "http://common.status.contract.kernel.bgbilling.bitel.ru/WSContractStatusMonitor/changeContractStatusRequest", output = "http://common.status.contract.kernel.bgbilling.bitel.ru/WSContractStatusMonitor/changeContractStatusResponse", fault = {
        @FaultAction(className = BGException_Exception.class, value = "http://common.status.contract.kernel.bgbilling.bitel.ru/WSContractStatusMonitor/changeContractStatus/Fault/BGException")
    })
    public void changeContractStatus(
        @WebParam(name = "arg0", targetNamespace = "")
        List<Integer> arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        Date arg2,
        @WebParam(name = "arg3", targetNamespace = "")
        Date arg3,
        @WebParam(name = "arg4", targetNamespace = "")
        String arg4)
        throws BGException_Exception
    ;

    /**
     * 
     * @throws BGException_Exception
     */
    @WebMethod
    @RequestWrapper(localName = "createBalanceDump", targetNamespace = "http://common.status.contract.kernel.bgbilling.bitel.ru/", className = "ru.bgcrm.plugin.bgbilling.ws.contract.status51.CreateBalanceDump")
    @ResponseWrapper(localName = "createBalanceDumpResponse", targetNamespace = "http://common.status.contract.kernel.bgbilling.bitel.ru/", className = "ru.bgcrm.plugin.bgbilling.ws.contract.status51.CreateBalanceDumpResponse")
    @Action(input = "http://common.status.contract.kernel.bgbilling.bitel.ru/WSContractStatusMonitor/createBalanceDumpRequest", output = "http://common.status.contract.kernel.bgbilling.bitel.ru/WSContractStatusMonitor/createBalanceDumpResponse", fault = {
        @FaultAction(className = BGException_Exception.class, value = "http://common.status.contract.kernel.bgbilling.bitel.ru/WSContractStatusMonitor/createBalanceDump/Fault/BGException")
    })
    public void createBalanceDump()
        throws BGException_Exception
    ;

    /**
     * 
     * @param arg5
     * @param arg4
     * @param arg3
     * @param arg2
     * @param arg1
     * @param arg0
     * @param arg15
     * @param arg16
     * @param arg13
     * @param arg14
     * @param arg11
     * @param arg12
     * @param arg10
     * @param arg6
     * @param arg7
     * @param arg8
     * @param arg9
     * @return
     *     returns ru.bgcrm.plugin.bgbilling.ws.contract.status51.Result
     * @throws BGException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "contractSearch", targetNamespace = "http://common.status.contract.kernel.bgbilling.bitel.ru/", className = "ru.bgcrm.plugin.bgbilling.ws.contract.status51.ContractSearch")
    @ResponseWrapper(localName = "contractSearchResponse", targetNamespace = "http://common.status.contract.kernel.bgbilling.bitel.ru/", className = "ru.bgcrm.plugin.bgbilling.ws.contract.status51.ContractSearchResponse")
    @Action(input = "http://common.status.contract.kernel.bgbilling.bitel.ru/WSContractStatusMonitor/contractSearchRequest", output = "http://common.status.contract.kernel.bgbilling.bitel.ru/WSContractStatusMonitor/contractSearchResponse", fault = {
        @FaultAction(className = BGException_Exception.class, value = "http://common.status.contract.kernel.bgbilling.bitel.ru/WSContractStatusMonitor/contractSearch/Fault/BGException")
    })
    public Result contractSearch(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        String arg2,
        @WebParam(name = "arg3", targetNamespace = "")
        List<Integer> arg3,
        @WebParam(name = "arg4", targetNamespace = "")
        List<Integer> arg4,
        @WebParam(name = "arg5", targetNamespace = "")
        String arg5,
        @WebParam(name = "arg6", targetNamespace = "")
        String arg6,
        @WebParam(name = "arg7", targetNamespace = "")
        String arg7,
        @WebParam(name = "arg8", targetNamespace = "")
        String arg8,
        @WebParam(name = "arg9", targetNamespace = "")
        int arg9,
        @WebParam(name = "arg10", targetNamespace = "")
        Page arg10,
        @WebParam(name = "arg11", targetNamespace = "")
        int arg11,
        @WebParam(name = "arg12", targetNamespace = "")
        BigDecimal arg12,
        @WebParam(name = "arg13", targetNamespace = "")
        List<Integer> arg13,
        @WebParam(name = "arg14", targetNamespace = "")
        float arg14,
        @WebParam(name = "arg15", targetNamespace = "")
        int arg15,
        @WebParam(name = "arg16", targetNamespace = "")
        int arg16)
        throws BGException_Exception
    ;

}
