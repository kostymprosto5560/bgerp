
package ru.bgcrm.plugin.bgbilling.ws.cerbercrypt.usercard;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "WSUserCard", targetNamespace = "http://common.cerbercrypt.modules.bgbilling.bitel.ru/", wsdlLocation = "http://192.168.169.17:8080/bgbilling/executer/modules.cerbercrypt/4/UserCard?wsdl")
public class WSUserCard_Service
    extends Service
{

    private final static URL WSUSERCARD_WSDL_LOCATION;
    private final static WebServiceException WSUSERCARD_EXCEPTION;
    private final static QName WSUSERCARD_QNAME = new QName("http://common.cerbercrypt.modules.bgbilling.bitel.ru/", "WSUserCard");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://192.168.169.17:8080/bgbilling/executer/modules.cerbercrypt/4/UserCard?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        WSUSERCARD_WSDL_LOCATION = url;
        WSUSERCARD_EXCEPTION = e;
    }

    public WSUserCard_Service() {
        super(__getWsdlLocation(), WSUSERCARD_QNAME);
    }

    public WSUserCard_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), WSUSERCARD_QNAME, features);
    }

    public WSUserCard_Service(URL wsdlLocation) {
        super(wsdlLocation, WSUSERCARD_QNAME);
    }

    public WSUserCard_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, WSUSERCARD_QNAME, features);
    }

    public WSUserCard_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public WSUserCard_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns WSUserCard
     */
    @WebEndpoint(name = "WSUserCard")
    public WSUserCard getWSUserCard() {
        return super.getPort(new QName("http://common.cerbercrypt.modules.bgbilling.bitel.ru/", "WSUserCard"), WSUserCard.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns WSUserCard
     */
    @WebEndpoint(name = "WSUserCard")
    public WSUserCard getWSUserCard(WebServiceFeature... features) {
        return super.getPort(new QName("http://common.cerbercrypt.modules.bgbilling.bitel.ru/", "WSUserCard"), WSUserCard.class, features);
    }

    private static URL __getWsdlLocation() {
        if (WSUSERCARD_EXCEPTION!= null) {
            throw WSUSERCARD_EXCEPTION;
        }
        return WSUSERCARD_WSDL_LOCATION;
    }

}
