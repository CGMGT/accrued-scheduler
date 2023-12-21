package gt.com.tigo.accruedautomation.config;

import gt.com.tigo.accruedautomation.soapclient.banguat.TipoCambioClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class SoapConfig {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("gt.com.tigo.accruedautomation.soapclient.banguat");
        return marshaller;
    }

    @Bean
    public TipoCambioClient tipoCambioClient(Jaxb2Marshaller marshaller) {
        TipoCambioClient client = new TipoCambioClient();
        client.setDefaultUri("http://www.banguat.gob.gt/variables/ws/TipoCambio.asmx");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
