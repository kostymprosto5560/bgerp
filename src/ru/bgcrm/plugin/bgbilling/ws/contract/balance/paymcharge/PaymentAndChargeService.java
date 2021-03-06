
package ru.bgcrm.plugin.bgbilling.ws.contract.balance.paymcharge;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
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
@WebService(name = "PaymentAndChargeService", targetNamespace = "http://common.balance.contract.kernel.bgbilling.bitel.ru/")
@XmlSeeAlso({
    ObjectFactory.class
})
@Deprecated
public interface PaymentAndChargeService {


    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<ru.bgcrm.plugin.bgbilling.ws.contract.balance.paymcharge.PaymentType>
     * @throws BGException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "paymentList", targetNamespace = "http://common.balance.contract.kernel.bgbilling.bitel.ru/", className = "ru.bgcrm.plugin.bgbilling.ws.contract.balance.paymcharge.PaymentList")
    @ResponseWrapper(localName = "paymentListResponse", targetNamespace = "http://common.balance.contract.kernel.bgbilling.bitel.ru/", className = "ru.bgcrm.plugin.bgbilling.ws.contract.balance.paymcharge.PaymentListResponse")
    @Action(input = "http://common.balance.contract.kernel.bgbilling.bitel.ru/PaymentAndChargeService/paymentListRequest", output = "http://common.balance.contract.kernel.bgbilling.bitel.ru/PaymentAndChargeService/paymentListResponse", fault = {
        @FaultAction(className = BGException_Exception.class, value = "http://common.balance.contract.kernel.bgbilling.bitel.ru/PaymentAndChargeService/paymentList/Fault/BGException")
    })
    public List<PaymentType> paymentList(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0)
        throws BGException_Exception
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<ru.bgcrm.plugin.bgbilling.ws.contract.balance.paymcharge.PaymentType>
     * @throws BGException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "chargeList", targetNamespace = "http://common.balance.contract.kernel.bgbilling.bitel.ru/", className = "ru.bgcrm.plugin.bgbilling.ws.contract.balance.paymcharge.ChargeList")
    @ResponseWrapper(localName = "chargeListResponse", targetNamespace = "http://common.balance.contract.kernel.bgbilling.bitel.ru/", className = "ru.bgcrm.plugin.bgbilling.ws.contract.balance.paymcharge.ChargeListResponse")
    @Action(input = "http://common.balance.contract.kernel.bgbilling.bitel.ru/PaymentAndChargeService/chargeListRequest", output = "http://common.balance.contract.kernel.bgbilling.bitel.ru/PaymentAndChargeService/chargeListResponse", fault = {
        @FaultAction(className = BGException_Exception.class, value = "http://common.balance.contract.kernel.bgbilling.bitel.ru/PaymentAndChargeService/chargeList/Fault/BGException")
    })
    public List<PaymentType> chargeList(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0)
        throws BGException_Exception
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns ru.bgcrm.plugin.bgbilling.ws.contract.balance.paymcharge.PaymentTypeItem
     * @throws BGException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getPaymentTree", targetNamespace = "http://common.balance.contract.kernel.bgbilling.bitel.ru/", className = "ru.bgcrm.plugin.bgbilling.ws.contract.balance.paymcharge.GetPaymentTree")
    @ResponseWrapper(localName = "getPaymentTreeResponse", targetNamespace = "http://common.balance.contract.kernel.bgbilling.bitel.ru/", className = "ru.bgcrm.plugin.bgbilling.ws.contract.balance.paymcharge.GetPaymentTreeResponse")
    @Action(input = "http://common.balance.contract.kernel.bgbilling.bitel.ru/PaymentAndChargeService/getPaymentTreeRequest", output = "http://common.balance.contract.kernel.bgbilling.bitel.ru/PaymentAndChargeService/getPaymentTreeResponse", fault = {
        @FaultAction(className = BGException_Exception.class, value = "http://common.balance.contract.kernel.bgbilling.bitel.ru/PaymentAndChargeService/getPaymentTree/Fault/BGException")
    })
    public PaymentTypeItem getPaymentTree(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0)
        throws BGException_Exception
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns ru.bgcrm.plugin.bgbilling.ws.contract.balance.paymcharge.PaymentTypeItem
     * @throws BGException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getChargeTree", targetNamespace = "http://common.balance.contract.kernel.bgbilling.bitel.ru/", className = "ru.bgcrm.plugin.bgbilling.ws.contract.balance.paymcharge.GetChargeTree")
    @ResponseWrapper(localName = "getChargeTreeResponse", targetNamespace = "http://common.balance.contract.kernel.bgbilling.bitel.ru/", className = "ru.bgcrm.plugin.bgbilling.ws.contract.balance.paymcharge.GetChargeTreeResponse")
    @Action(input = "http://common.balance.contract.kernel.bgbilling.bitel.ru/PaymentAndChargeService/getChargeTreeRequest", output = "http://common.balance.contract.kernel.bgbilling.bitel.ru/PaymentAndChargeService/getChargeTreeResponse", fault = {
        @FaultAction(className = BGException_Exception.class, value = "http://common.balance.contract.kernel.bgbilling.bitel.ru/PaymentAndChargeService/getChargeTree/Fault/BGException")
    })
    public PaymentTypeItem getChargeTree(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0)
        throws BGException_Exception
    ;

}
