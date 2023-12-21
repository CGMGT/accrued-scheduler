package gt.com.tigo.accruedautomation.service.accrued;

import gt.com.tigo.accruedautomation.dao.accrued.XxTiposCambioRepository;
import gt.com.tigo.accruedautomation.model.accrued.XxTiposCambioEntity;
import gt.com.tigo.accruedautomation.soapclient.banguat.*;
import gt.com.tigo.accruedautomation.util.exception.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;



@Service
public class XxTiposCambioService {
    private static final Logger logger = LoggerFactory.getLogger(XxTiposCambioService.class);

    public static final String WEBSERVICE = "http://www.banguat.gob.gt/variables/ws/TipoCambio.asmx";

    @Autowired
    private XxTiposCambioRepository xxTiposCambioRepository;

    @Autowired
    private TipoCambioClient tipoCambioClient;

    public String sync() throws ResourceNotFoundException, ResourceCreateException {
        logger.debug(String.format("@%s::sync()", this.getClass().getName()));

        Date initialDate = new Date();


        logger.debug(String.format("@%s::fechaInicial()", new SimpleDateFormat("dd-MM-yyyy").format(initialDate.getTime () -6 * 24 * 60 * 60 * 1000)));

        TipoCambioFechaInicialResponse response = tipoCambioClient.getExchangeRate(new SimpleDateFormat("dd/MM/yyyy").format(initialDate.getTime () -6 * 24 * 60 * 60 * 1000));
        logger.debug("after response");
        DataVariable resultado = response.getTipoCambioFechaInicialResult();

        if (resultado == null) {
            throw new ResourceNotFoundException();
        }
        try{
            this.xxTiposCambioRepository.deleteAll();

            for (Var entity : resultado.getVars().getVar()){
                logger.debug(String.format("fecha: %s, referencia: %s", entity.getFecha(), entity.getVenta()));
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

                java.util.Date date = format.parse(entity.getFecha());

                java.sql.Date sqlDate = new java.sql.Date(date.getTime());

                XxTiposCambioEntity tiposCambio = new XxTiposCambioEntity();
                tiposCambio.setFecha(sqlDate);
                tiposCambio.setMoneda("Dolares");
                tiposCambio.setReferencia(BigDecimal.valueOf(entity.getVenta()));
                tiposCambio.setSimbolo("$");
                tiposCambio.setFechaCreacion(new java.sql.Date(initialDate.getTime()));
                this.xxTiposCambioRepository.save(tiposCambio);

            }
            this.updateTiposCambio();
        } catch (Exception ex) {
            logger.error(ex.getMessage());

            throw new ResourceCreateException();
        }

        return null;
    }

    public String updateTiposCambio() throws ResourceNotFoundException, ResourceCreateException {
        logger.debug(String.format("@%s::UpdateTiposCambio()", this.getClass().getName()));

        try{
            this.xxTiposCambioRepository.spCargaTiposCambio();
            this.xxTiposCambioRepository.deleteAll();
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            throw new ResourceCreateException();
        }

        return null;
    }

    public String cargaDatosDWH() throws ResourceNotFoundException, ResourceCreateException {
        logger.debug(String.format("@%s::CargaDatosDWH()", this.getClass().getName()));
        try{
            this.xxTiposCambioRepository.procesarDatosDWH();
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            throw new ResourceCreateException();
        }

        return null;
    }

}
