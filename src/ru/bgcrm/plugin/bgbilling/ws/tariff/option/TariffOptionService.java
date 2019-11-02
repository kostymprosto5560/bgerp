
package ru.bgcrm.plugin.bgbilling.ws.tariff.option;

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
@WebService(name = "TariffOptionService", targetNamespace = "http://service.common.option.tariff.kernel.bgbilling.bitel.ru/")
@XmlSeeAlso({
    ObjectFactory.class
})
@Deprecated
public interface TariffOptionService {


    /**
     * 
     * @return
     *     returns java.util.List<ru.bgcrm.plugin.bgbilling.ws.tariff.option.TariffOption>
     * @throws BGException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "tariffOptionList", targetNamespace = "http://service.common.option.tariff.kernel.bgbilling.bitel.ru/", className = "ru.bgcrm.plugin.bgbilling.ws.tariff.option.TariffOptionList")
    @ResponseWrapper(localName = "tariffOptionListResponse", targetNamespace = "http://service.common.option.tariff.kernel.bgbilling.bitel.ru/", className = "ru.bgcrm.plugin.bgbilling.ws.tariff.option.TariffOptionListResponse")
    @Action(input = "http://service.common.option.tariff.kernel.bgbilling.bitel.ru/TariffOptionService/tariffOptionListRequest", output = "http://service.common.option.tariff.kernel.bgbilling.bitel.ru/TariffOptionService/tariffOptionListResponse", fault = {
        @FaultAction(className = BGException_Exception.class, value = "http://service.common.option.tariff.kernel.bgbilling.bitel.ru/TariffOptionService/tariffOptionList/Fault/BGException")
    })
    public List<TariffOption> tariffOptionList()
        throws BGException_Exception
    ;

    /**
     * 
     * @param id
     * @return
     *     returns ru.bgcrm.plugin.bgbilling.ws.tariff.option.TariffOption
     * @throws BGException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "tariffOptionGet", targetNamespace = "http://service.common.option.tariff.kernel.bgbilling.bitel.ru/", className = "ru.bgcrm.plugin.bgbilling.ws.tariff.option.TariffOptionGet")
    @ResponseWrapper(localName = "tariffOptionGetResponse", targetNamespace = "http://service.common.option.tariff.kernel.bgbilling.bitel.ru/", className = "ru.bgcrm.plugin.bgbilling.ws.tariff.option.TariffOptionGetResponse")
    @Action(input = "http://service.common.option.tariff.kernel.bgbilling.bitel.ru/TariffOptionService/tariffOptionGetRequest", output = "http://service.common.option.tariff.kernel.bgbilling.bitel.ru/TariffOptionService/tariffOptionGetResponse", fault = {
        @FaultAction(className = BGException_Exception.class, value = "http://service.common.option.tariff.kernel.bgbilling.bitel.ru/TariffOptionService/tariffOptionGet/Fault/BGException")
    })
    public TariffOption tariffOptionGet(
        @WebParam(name = "id", targetNamespace = "")
        int id)
        throws BGException_Exception
    ;

    /**
     * 
     * @param currentContractOptionList
     * @param web
     * @param onlyAvailable
     * @param contractId
     * @param date
     * @return
     *     returns java.util.List<ru.bgcrm.plugin.bgbilling.ws.tariff.option.TariffOption>
     * @throws BGException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "tariffOptionListAvailable", targetNamespace = "http://service.common.option.tariff.kernel.bgbilling.bitel.ru/", className = "ru.bgcrm.plugin.bgbilling.ws.tariff.option.TariffOptionListAvailable")
    @ResponseWrapper(localName = "tariffOptionListAvailableResponse", targetNamespace = "http://service.common.option.tariff.kernel.bgbilling.bitel.ru/", className = "ru.bgcrm.plugin.bgbilling.ws.tariff.option.TariffOptionListAvailableResponse")
    @Action(input = "http://service.common.option.tariff.kernel.bgbilling.bitel.ru/TariffOptionService/tariffOptionListAvailableRequest", output = "http://service.common.option.tariff.kernel.bgbilling.bitel.ru/TariffOptionService/tariffOptionListAvailableResponse", fault = {
        @FaultAction(className = BGException_Exception.class, value = "http://service.common.option.tariff.kernel.bgbilling.bitel.ru/TariffOptionService/tariffOptionListAvailable/Fault/BGException")
    })
    public List<TariffOption> tariffOptionListAvailable(
        @WebParam(name = "contractId", targetNamespace = "")
        int contractId,
        @WebParam(name = "date", targetNamespace = "")
        Date date,
        @WebParam(name = "currentContractOptionList", targetNamespace = "")
        List<ContractTariffOption> currentContractOptionList,
        @WebParam(name = "onlyAvailable", targetNamespace = "")
        boolean onlyAvailable,
        @WebParam(name = "web", targetNamespace = "")
        boolean web)
        throws BGException_Exception
    ;

    /**
     * 
     * @param fullOptionList
     * @param contractId
     * @param date
     * @return
     *     returns java.util.List<ru.bgcrm.plugin.bgbilling.ws.tariff.option.TariffOption>
     * @throws BGException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "tariffOptionWebList", targetNamespace = "http://service.common.option.tariff.kernel.bgbilling.bitel.ru/", className = "ru.bgcrm.plugin.bgbilling.ws.tariff.option.TariffOptionWebList")
    @ResponseWrapper(localName = "tariffOptionWebListResponse", targetNamespace = "http://service.common.option.tariff.kernel.bgbilling.bitel.ru/", className = "ru.bgcrm.plugin.bgbilling.ws.tariff.option.TariffOptionWebListResponse")
    @Action(input = "http://service.common.option.tariff.kernel.bgbilling.bitel.ru/TariffOptionService/tariffOptionWebListRequest", output = "http://service.common.option.tariff.kernel.bgbilling.bitel.ru/TariffOptionService/tariffOptionWebListResponse", fault = {
        @FaultAction(className = BGException_Exception.class, value = "http://service.common.option.tariff.kernel.bgbilling.bitel.ru/TariffOptionService/tariffOptionWebList/Fault/BGException")
    })
    public List<TariffOption> tariffOptionWebList(
        @WebParam(name = "contractId", targetNamespace = "")
        int contractId,
        @WebParam(name = "date", targetNamespace = "")
        Date date,
        @WebParam(name = "fullOptionList", targetNamespace = "")
        List<TariffOption> fullOptionList)
        throws BGException_Exception
    ;

    /**
     * 
     * @param tariffOption
     * @throws BGException_Exception
     */
    @WebMethod
    @RequestWrapper(localName = "tariffOptionUpdate", targetNamespace = "http://service.common.option.tariff.kernel.bgbilling.bitel.ru/", className = "ru.bgcrm.plugin.bgbilling.ws.tariff.option.TariffOptionUpdate")
    @ResponseWrapper(localName = "tariffOptionUpdateResponse", targetNamespace = "http://service.common.option.tariff.kernel.bgbilling.bitel.ru/", className = "ru.bgcrm.plugin.bgbilling.ws.tariff.option.TariffOptionUpdateResponse")
    @Action(input = "http://service.common.option.tariff.kernel.bgbilling.bitel.ru/TariffOptionService/tariffOptionUpdateRequest", output = "http://service.common.option.tariff.kernel.bgbilling.bitel.ru/TariffOptionService/tariffOptionUpdateResponse", fault = {
        @FaultAction(className = BGException_Exception.class, value = "http://service.common.option.tariff.kernel.bgbilling.bitel.ru/TariffOptionService/tariffOptionUpdate/Fault/BGException")
    })
    public void tariffOptionUpdate(
        @WebParam(name = "tariffOption", targetNamespace = "")
        TariffOption tariffOption)
        throws BGException_Exception
    ;

    /**
     * 
     * @param id
     * @throws BGException_Exception
     */
    @WebMethod
    @RequestWrapper(localName = "tariffOptionDelete", targetNamespace = "http://service.common.option.tariff.kernel.bgbilling.bitel.ru/", className = "ru.bgcrm.plugin.bgbilling.ws.tariff.option.TariffOptionDelete")
    @ResponseWrapper(localName = "tariffOptionDeleteResponse", targetNamespace = "http://service.common.option.tariff.kernel.bgbilling.bitel.ru/", className = "ru.bgcrm.plugin.bgbilling.ws.tariff.option.TariffOptionDeleteResponse")
    @Action(input = "http://service.common.option.tariff.kernel.bgbilling.bitel.ru/TariffOptionService/tariffOptionDeleteRequest", output = "http://service.common.option.tariff.kernel.bgbilling.bitel.ru/TariffOptionService/tariffOptionDeleteResponse", fault = {
        @FaultAction(className = BGException_Exception.class, value = "http://service.common.option.tariff.kernel.bgbilling.bitel.ru/TariffOptionService/tariffOptionDelete/Fault/BGException")
    })
    public void tariffOptionDelete(
        @WebParam(name = "id", targetNamespace = "")
        int id)
        throws BGException_Exception
    ;

    /**
     * 
     * @param optionId
     * @param date
     * @return
     *     returns java.util.List<ru.bgcrm.plugin.bgbilling.ws.tariff.option.TariffOptionActivateMode>
     * @throws BGException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "tariffOptionActivateModeList", targetNamespace = "http://service.common.option.tariff.kernel.bgbilling.bitel.ru/", className = "ru.bgcrm.plugin.bgbilling.ws.tariff.option.TariffOptionActivateModeList")
    @ResponseWrapper(localName = "tariffOptionActivateModeListResponse", targetNamespace = "http://service.common.option.tariff.kernel.bgbilling.bitel.ru/", className = "ru.bgcrm.plugin.bgbilling.ws.tariff.option.TariffOptionActivateModeListResponse")
    @Action(input = "http://service.common.option.tariff.kernel.bgbilling.bitel.ru/TariffOptionService/tariffOptionActivateModeListRequest", output = "http://service.common.option.tariff.kernel.bgbilling.bitel.ru/TariffOptionService/tariffOptionActivateModeListResponse", fault = {
        @FaultAction(className = BGException_Exception.class, value = "http://service.common.option.tariff.kernel.bgbilling.bitel.ru/TariffOptionService/tariffOptionActivateModeList/Fault/BGException")
    })
    public List<TariffOptionActivateMode> tariffOptionActivateModeList(
        @WebParam(name = "optionId", targetNamespace = "")
        int optionId,
        @WebParam(name = "date", targetNamespace = "")
        Date date)
        throws BGException_Exception
    ;

    /**
     * 
     * @param contractId
     * @param date
     * @return
     *     returns java.util.List<ru.bgcrm.plugin.bgbilling.ws.tariff.option.ContractTariffOption>
     * @throws BGException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "contractTariffOptionList", targetNamespace = "http://service.common.option.tariff.kernel.bgbilling.bitel.ru/", className = "ru.bgcrm.plugin.bgbilling.ws.tariff.option.ContractTariffOptionList")
    @ResponseWrapper(localName = "contractTariffOptionListResponse", targetNamespace = "http://service.common.option.tariff.kernel.bgbilling.bitel.ru/", className = "ru.bgcrm.plugin.bgbilling.ws.tariff.option.ContractTariffOptionListResponse")
    @Action(input = "http://service.common.option.tariff.kernel.bgbilling.bitel.ru/TariffOptionService/contractTariffOptionListRequest", output = "http://service.common.option.tariff.kernel.bgbilling.bitel.ru/TariffOptionService/contractTariffOptionListResponse", fault = {
        @FaultAction(className = BGException_Exception.class, value = "http://service.common.option.tariff.kernel.bgbilling.bitel.ru/TariffOptionService/contractTariffOptionList/Fault/BGException")
    })
    public List<ContractTariffOption> contractTariffOptionList(
        @WebParam(name = "contractId", targetNamespace = "")
        int contractId,
        @WebParam(name = "date", targetNamespace = "")
        Date date)
        throws BGException_Exception
    ;

    /**
     * 
     * @param contractTariffOptionList
     * @param contractId
     * @param date
     * @return
     *     returns java.util.List<ru.bgcrm.plugin.bgbilling.ws.tariff.option.ContractTariffOption>
     * @throws BGException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "contractTariffOptionListWeb", targetNamespace = "http://service.common.option.tariff.kernel.bgbilling.bitel.ru/", className = "ru.bgcrm.plugin.bgbilling.ws.tariff.option.ContractTariffOptionListWeb")
    @ResponseWrapper(localName = "contractTariffOptionListWebResponse", targetNamespace = "http://service.common.option.tariff.kernel.bgbilling.bitel.ru/", className = "ru.bgcrm.plugin.bgbilling.ws.tariff.option.ContractTariffOptionListWebResponse")
    @Action(input = "http://service.common.option.tariff.kernel.bgbilling.bitel.ru/TariffOptionService/contractTariffOptionListWebRequest", output = "http://service.common.option.tariff.kernel.bgbilling.bitel.ru/TariffOptionService/contractTariffOptionListWebResponse", fault = {
        @FaultAction(className = BGException_Exception.class, value = "http://service.common.option.tariff.kernel.bgbilling.bitel.ru/TariffOptionService/contractTariffOptionListWeb/Fault/BGException")
    })
    public List<ContractTariffOption> contractTariffOptionListWeb(
        @WebParam(name = "contractId", targetNamespace = "")
        int contractId,
        @WebParam(name = "date", targetNamespace = "")
        Date date,
        @WebParam(name = "contractTariffOptionList", targetNamespace = "")
        List<ContractTariffOption> contractTariffOptionList)
        throws BGException_Exception
    ;

    /**
     * 
     * @param optionId
     * @param web
     * @param contractId
     * @param modeId
     * @throws BGException_Exception
     */
    @WebMethod
    @RequestWrapper(localName = "contractTariffOptionActivate", targetNamespace = "http://service.common.option.tariff.kernel.bgbilling.bitel.ru/", className = "ru.bgcrm.plugin.bgbilling.ws.tariff.option.ContractTariffOptionActivate")
    @ResponseWrapper(localName = "contractTariffOptionActivateResponse", targetNamespace = "http://service.common.option.tariff.kernel.bgbilling.bitel.ru/", className = "ru.bgcrm.plugin.bgbilling.ws.tariff.option.ContractTariffOptionActivateResponse")
    @Action(input = "http://service.common.option.tariff.kernel.bgbilling.bitel.ru/TariffOptionService/contractTariffOptionActivateRequest", output = "http://service.common.option.tariff.kernel.bgbilling.bitel.ru/TariffOptionService/contractTariffOptionActivateResponse", fault = {
        @FaultAction(className = BGException_Exception.class, value = "http://service.common.option.tariff.kernel.bgbilling.bitel.ru/TariffOptionService/contractTariffOptionActivate/Fault/BGException")
    })
    public void contractTariffOptionActivate(
        @WebParam(name = "contractId", targetNamespace = "")
        int contractId,
        @WebParam(name = "optionId", targetNamespace = "")
        int optionId,
        @WebParam(name = "modeId", targetNamespace = "")
        int modeId,
        @WebParam(name = "web", targetNamespace = "")
        boolean web)
        throws BGException_Exception
    ;

    /**
     * 
     * @param optionId
     * @param chargeSum
     * @param web
     * @param contractId
     * @param modeId
     * @return
     *     returns int
     * @throws BGException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "contractTariffOptionActivateWhithSum", targetNamespace = "http://service.common.option.tariff.kernel.bgbilling.bitel.ru/", className = "ru.bgcrm.plugin.bgbilling.ws.tariff.option.ContractTariffOptionActivateWhithSum")
    @ResponseWrapper(localName = "contractTariffOptionActivateWhithSumResponse", targetNamespace = "http://service.common.option.tariff.kernel.bgbilling.bitel.ru/", className = "ru.bgcrm.plugin.bgbilling.ws.tariff.option.ContractTariffOptionActivateWhithSumResponse")
    @Action(input = "http://service.common.option.tariff.kernel.bgbilling.bitel.ru/TariffOptionService/contractTariffOptionActivateWhithSumRequest", output = "http://service.common.option.tariff.kernel.bgbilling.bitel.ru/TariffOptionService/contractTariffOptionActivateWhithSumResponse", fault = {
        @FaultAction(className = BGException_Exception.class, value = "http://service.common.option.tariff.kernel.bgbilling.bitel.ru/TariffOptionService/contractTariffOptionActivateWhithSum/Fault/BGException")
    })
    public int contractTariffOptionActivateWhithSum(
        @WebParam(name = "contractId", targetNamespace = "")
        int contractId,
        @WebParam(name = "optionId", targetNamespace = "")
        int optionId,
        @WebParam(name = "modeId", targetNamespace = "")
        int modeId,
        @WebParam(name = "chargeSum", targetNamespace = "")
        BigDecimal chargeSum,
        @WebParam(name = "web", targetNamespace = "")
        boolean web)
        throws BGException_Exception
    ;

    /**
     * 
     * @param contractId
     * @param contractOptionId
     * @throws BGException_Exception
     */
    @WebMethod
    @RequestWrapper(localName = "contractTariffOptionDeactivate", targetNamespace = "http://service.common.option.tariff.kernel.bgbilling.bitel.ru/", className = "ru.bgcrm.plugin.bgbilling.ws.tariff.option.ContractTariffOptionDeactivate")
    @ResponseWrapper(localName = "contractTariffOptionDeactivateResponse", targetNamespace = "http://service.common.option.tariff.kernel.bgbilling.bitel.ru/", className = "ru.bgcrm.plugin.bgbilling.ws.tariff.option.ContractTariffOptionDeactivateResponse")
    @Action(input = "http://service.common.option.tariff.kernel.bgbilling.bitel.ru/TariffOptionService/contractTariffOptionDeactivateRequest", output = "http://service.common.option.tariff.kernel.bgbilling.bitel.ru/TariffOptionService/contractTariffOptionDeactivateResponse", fault = {
        @FaultAction(className = BGException_Exception.class, value = "http://service.common.option.tariff.kernel.bgbilling.bitel.ru/TariffOptionService/contractTariffOptionDeactivate/Fault/BGException")
    })
    public void contractTariffOptionDeactivate(
        @WebParam(name = "contractId", targetNamespace = "")
        int contractId,
        @WebParam(name = "contractOptionId", targetNamespace = "")
        int contractOptionId)
        throws BGException_Exception
    ;

    /**
     * 
     * @param contractId
     * @param contractOptionId
     * @throws BGException_Exception
     */
    @WebMethod
    @RequestWrapper(localName = "contractTariffOptionReactivate", targetNamespace = "http://service.common.option.tariff.kernel.bgbilling.bitel.ru/", className = "ru.bgcrm.plugin.bgbilling.ws.tariff.option.ContractTariffOptionReactivate")
    @ResponseWrapper(localName = "contractTariffOptionReactivateResponse", targetNamespace = "http://service.common.option.tariff.kernel.bgbilling.bitel.ru/", className = "ru.bgcrm.plugin.bgbilling.ws.tariff.option.ContractTariffOptionReactivateResponse")
    @Action(input = "http://service.common.option.tariff.kernel.bgbilling.bitel.ru/TariffOptionService/contractTariffOptionReactivateRequest", output = "http://service.common.option.tariff.kernel.bgbilling.bitel.ru/TariffOptionService/contractTariffOptionReactivateResponse", fault = {
        @FaultAction(className = BGException_Exception.class, value = "http://service.common.option.tariff.kernel.bgbilling.bitel.ru/TariffOptionService/contractTariffOptionReactivate/Fault/BGException")
    })
    public void contractTariffOptionReactivate(
        @WebParam(name = "contractId", targetNamespace = "")
        int contractId,
        @WebParam(name = "contractOptionId", targetNamespace = "")
        int contractOptionId)
        throws BGException_Exception
    ;

    /**
     * 
     * @param web
     * @param contractId
     * @param date
     * @return
     *     returns java.util.List<ru.bgcrm.plugin.bgbilling.ws.tariff.option.ContractTariffOption>
     * @throws BGException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "contractTariffOptionHistory", targetNamespace = "http://service.common.option.tariff.kernel.bgbilling.bitel.ru/", className = "ru.bgcrm.plugin.bgbilling.ws.tariff.option.ContractTariffOptionHistory")
    @ResponseWrapper(localName = "contractTariffOptionHistoryResponse", targetNamespace = "http://service.common.option.tariff.kernel.bgbilling.bitel.ru/", className = "ru.bgcrm.plugin.bgbilling.ws.tariff.option.ContractTariffOptionHistoryResponse")
    @Action(input = "http://service.common.option.tariff.kernel.bgbilling.bitel.ru/TariffOptionService/contractTariffOptionHistoryRequest", output = "http://service.common.option.tariff.kernel.bgbilling.bitel.ru/TariffOptionService/contractTariffOptionHistoryResponse", fault = {
        @FaultAction(className = BGException_Exception.class, value = "http://service.common.option.tariff.kernel.bgbilling.bitel.ru/TariffOptionService/contractTariffOptionHistory/Fault/BGException")
    })
    public List<ContractTariffOption> contractTariffOptionHistory(
        @WebParam(name = "contractId", targetNamespace = "")
        int contractId,
        @WebParam(name = "date", targetNamespace = "")
        Date date,
        @WebParam(name = "web", targetNamespace = "")
        boolean web)
        throws BGException_Exception
    ;

}
