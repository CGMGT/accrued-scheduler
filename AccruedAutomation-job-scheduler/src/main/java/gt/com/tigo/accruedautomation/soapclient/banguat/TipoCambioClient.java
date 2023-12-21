package gt.com.tigo.accruedautomation.soapclient.banguat;

import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.core.WebServiceMessageCallback;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.SoapMessage;

import javax.xml.transform.TransformerException;
import java.io.IOException;

public class TipoCambioClient extends WebServiceGatewaySupport {

    public TipoCambioFechaInicialResponse getExchangeRate(String initialDate) {
        TipoCambioFechaInicial request = new TipoCambioFechaInicial();
        request.setFechainit(initialDate);

        return (TipoCambioFechaInicialResponse) getWebServiceTemplate()
                .marshalSendAndReceive(request, new WebServiceMessageCallback() {
                    @Override
                    public void doWithMessage(WebServiceMessage webServiceMessage) throws IOException, TransformerException {
                        ((SoapMessage)webServiceMessage).setSoapAction("http://www.banguat.gob.gt/variables/ws/TipoCambioFechaInicial");
                    }
                });

    }
}
