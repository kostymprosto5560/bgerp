
package ru.bgcrm.plugin.bgbilling.ws.helpdesk;

import java.math.BigDecimal;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlMimeType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import javax.xml.ws.Holder;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import javax.xml.ws.soap.MTOM;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "HelpdeskService", targetNamespace = "http://service.common.helpdesk.plugins.bgbilling.bitel.ru/")
@XmlSeeAlso({
    ObjectFactory.class
})
@MTOM(enabled = true)
@Deprecated
public interface HelpdeskService {


    /**
     * 
     * @param arg0
     * @throws BGException_Exception
     */
    @WebMethod
    @RequestWrapper(localName = "fileDelete", targetNamespace = "http://service.common.helpdesk.plugins.bgbilling.bitel.ru/", className = "ru.bgcrm.plugin.bgbilling.ws.helpdesk.FileDelete")
    @ResponseWrapper(localName = "fileDeleteResponse", targetNamespace = "http://service.common.helpdesk.plugins.bgbilling.bitel.ru/", className = "ru.bgcrm.plugin.bgbilling.ws.helpdesk.FileDeleteResponse")
    @Action(input = "http://service.common.helpdesk.plugins.bgbilling.bitel.ru/HelpdeskService/fileDeleteRequest", output = "http://service.common.helpdesk.plugins.bgbilling.bitel.ru/HelpdeskService/fileDeleteResponse", fault = {
        @FaultAction(className = BGException_Exception.class, value = "http://service.common.helpdesk.plugins.bgbilling.bitel.ru/HelpdeskService/fileDelete/Fault/BGException")
    })
    public void fileDelete(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0)
        throws BGException_Exception
    ;

    /**
     * 
     * @param topicId
     * @param filename
     * @param fileData
     * @param size
     * @throws BGException_Exception
     */
    @WebMethod
    @RequestWrapper(localName = "fileUpload", targetNamespace = "http://service.common.helpdesk.plugins.bgbilling.bitel.ru/", className = "ru.bgcrm.plugin.bgbilling.ws.helpdesk.FileUpload")
    @ResponseWrapper(localName = "fileUploadResponse", targetNamespace = "http://service.common.helpdesk.plugins.bgbilling.bitel.ru/", className = "ru.bgcrm.plugin.bgbilling.ws.helpdesk.FileUploadResponse")
    @Action(input = "http://service.common.helpdesk.plugins.bgbilling.bitel.ru/HelpdeskService/fileUploadRequest", output = "http://service.common.helpdesk.plugins.bgbilling.bitel.ru/HelpdeskService/fileUploadResponse", fault = {
        @FaultAction(className = BGException_Exception.class, value = "http://service.common.helpdesk.plugins.bgbilling.bitel.ru/HelpdeskService/fileUpload/Fault/BGException")
    })
    public void fileUpload(
        @WebParam(name = "topicId", targetNamespace = "")
        String topicId,
        @WebParam(name = "filename", targetNamespace = "")
        String filename,
        @WebParam(name = "size", targetNamespace = "")
        long size,
        @WebParam(name = "fileData", targetNamespace = "", mode = WebParam.Mode.INOUT)
        @XmlMimeType( "application/octet-stream" ) Holder<byte[]> fileData)
        throws BGException_Exception
    ;

    /**
     * 
     * @param fileId
     * @param serverFile
     * @param contractId
     * @param fileData
     * @throws BGException_Exception
     */
    @WebMethod
    @RequestWrapper(localName = "fileDownload", targetNamespace = "http://service.common.helpdesk.plugins.bgbilling.bitel.ru/", className = "ru.bgcrm.plugin.bgbilling.ws.helpdesk.FileDownload")
    @ResponseWrapper(localName = "fileDownloadResponse", targetNamespace = "http://service.common.helpdesk.plugins.bgbilling.bitel.ru/", className = "ru.bgcrm.plugin.bgbilling.ws.helpdesk.FileDownloadResponse")
    @Action(input = "http://service.common.helpdesk.plugins.bgbilling.bitel.ru/HelpdeskService/fileDownloadRequest", output = "http://service.common.helpdesk.plugins.bgbilling.bitel.ru/HelpdeskService/fileDownloadResponse", fault = {
        @FaultAction(className = BGException_Exception.class, value = "http://service.common.helpdesk.plugins.bgbilling.bitel.ru/HelpdeskService/fileDownload/Fault/BGException")
    })
    public void fileDownload(
        @WebParam(name = "fileId", targetNamespace = "")
        int fileId,
        @WebParam(name = "contractId", targetNamespace = "")
        int contractId,
        @WebParam(name = "serverFile", targetNamespace = "", mode = WebParam.Mode.OUT)
        Holder<BgServerFile> serverFile,
        @WebParam(name = "fileData", targetNamespace = "", mode = WebParam.Mode.OUT)
        @XmlMimeType( "application/octet-stream" ) Holder<byte[]> fileData)
        throws BGException_Exception
    ;

    /**
     * 
     * @param topicId
     * @param reserveStatus
     * @return
     *     returns int
     * @throws BGException_Exception
     * @throws BGMessageException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "reservStatusUpdate", targetNamespace = "http://service.common.helpdesk.plugins.bgbilling.bitel.ru/", className = "ru.bgcrm.plugin.bgbilling.ws.helpdesk.ReservStatusUpdate")
    @ResponseWrapper(localName = "reservStatusUpdateResponse", targetNamespace = "http://service.common.helpdesk.plugins.bgbilling.bitel.ru/", className = "ru.bgcrm.plugin.bgbilling.ws.helpdesk.ReservStatusUpdateResponse")
    @Action(input = "http://service.common.helpdesk.plugins.bgbilling.bitel.ru/HelpdeskService/reservStatusUpdateRequest", output = "http://service.common.helpdesk.plugins.bgbilling.bitel.ru/HelpdeskService/reservStatusUpdateResponse", fault = {
        @FaultAction(className = BGException_Exception.class, value = "http://service.common.helpdesk.plugins.bgbilling.bitel.ru/HelpdeskService/reservStatusUpdate/Fault/BGException"),
        @FaultAction(className = BGMessageException_Exception.class, value = "http://service.common.helpdesk.plugins.bgbilling.bitel.ru/HelpdeskService/reservStatusUpdate/Fault/BGMessageException")
    })
    public int reservStatusUpdate(
        @WebParam(name = "topicId", targetNamespace = "")
        int topicId,
        @WebParam(name = "reserveStatus", targetNamespace = "")
        int reserveStatus)
        throws BGException_Exception, BGMessageException_Exception
    ;

    /**
     * 
     * @param topicId
     * @return
     *     returns int
     * @throws BGException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "reserveStatusGet", targetNamespace = "http://service.common.helpdesk.plugins.bgbilling.bitel.ru/", className = "ru.bgcrm.plugin.bgbilling.ws.helpdesk.ReserveStatusGet")
    @ResponseWrapper(localName = "reserveStatusGetResponse", targetNamespace = "http://service.common.helpdesk.plugins.bgbilling.bitel.ru/", className = "ru.bgcrm.plugin.bgbilling.ws.helpdesk.ReserveStatusGetResponse")
    @Action(input = "http://service.common.helpdesk.plugins.bgbilling.bitel.ru/HelpdeskService/reserveStatusGetRequest", output = "http://service.common.helpdesk.plugins.bgbilling.bitel.ru/HelpdeskService/reserveStatusGetResponse", fault = {
        @FaultAction(className = BGException_Exception.class, value = "http://service.common.helpdesk.plugins.bgbilling.bitel.ru/HelpdeskService/reserveStatusGet/Fault/BGException")
    })
    public int reserveStatusGet(
        @WebParam(name = "topicId", targetNamespace = "")
        int topicId)
        throws BGException_Exception
    ;

    /**
     * 
     * @param topicId
     * @param sum
     * @return
     *     returns int
     * @throws BGException_Exception
     * @throws BGMessageException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "topicCostUpdate", targetNamespace = "http://service.common.helpdesk.plugins.bgbilling.bitel.ru/", className = "ru.bgcrm.plugin.bgbilling.ws.helpdesk.TopicCostUpdate")
    @ResponseWrapper(localName = "topicCostUpdateResponse", targetNamespace = "http://service.common.helpdesk.plugins.bgbilling.bitel.ru/", className = "ru.bgcrm.plugin.bgbilling.ws.helpdesk.TopicCostUpdateResponse")
    @Action(input = "http://service.common.helpdesk.plugins.bgbilling.bitel.ru/HelpdeskService/topicCostUpdateRequest", output = "http://service.common.helpdesk.plugins.bgbilling.bitel.ru/HelpdeskService/topicCostUpdateResponse", fault = {
        @FaultAction(className = BGException_Exception.class, value = "http://service.common.helpdesk.plugins.bgbilling.bitel.ru/HelpdeskService/topicCostUpdate/Fault/BGException"),
        @FaultAction(className = BGMessageException_Exception.class, value = "http://service.common.helpdesk.plugins.bgbilling.bitel.ru/HelpdeskService/topicCostUpdate/Fault/BGMessageException")
    })
    public int topicCostUpdate(
        @WebParam(name = "topicId", targetNamespace = "")
        int topicId,
        @WebParam(name = "sum", targetNamespace = "")
        BigDecimal sum)
        throws BGException_Exception, BGMessageException_Exception
    ;

}
