package gt.com.tigo.accruedautomation.service.accrued;

import gt.com.tigo.accruedautomation.model.accrued.EmailTemplateEntity;
import gt.com.tigo.accruedautomation.model.accrued.VPurchaseOrderDrcEntity;
import gt.com.tigo.accruedautomation.model.accrued.VPurchaseOrderEntity;
import gt.com.tigo.accruedautomation.service.general.MailService;
import gt.com.tigo.accruedautomation.util.exception.ResourceCreateException;
import gt.com.tigo.accruedautomation.util.exception.ResourceNotFoundException;
import gt.com.tigo.accruedautomation.util.exception.ResourcesNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfirmacionesService {
    private static final Logger logger = LoggerFactory.getLogger(ConfirmacionesService.class);

    public static final String CONFIRMACION = "CONFIRMACION";
    public static final String USUARIO = "{USUARIO}";
    public static final String PODETAIL = "{po_detail}";
    public static final String FECHA = "{FECHA}";
    public static final String EMAIL = "accruedApp@tigo.com.gt";

    @Autowired
    private EmailTemplateService emailTemplateService;

    @Autowired
    private VPurchaseOrderService vPurchaseOrderService;

    @Autowired
    private MailService mailService;

    public void enviaConfirmaciones() throws ResourcesNotFoundException, ResourceNotFoundException, ResourceCreateException {
        logger.debug(String.format("@%s::EnviaConfirmaciones()", this.getClass().getName()));

        List<VPurchaseOrderEntity> entidad = this.vPurchaseOrderService.findAll();
        List<VPurchaseOrderDrcEntity> entidadDrc = this.vPurchaseOrderService.findDrcAll();
        EmailTemplateEntity template = this.emailTemplateService.findByName(CONFIRMACION);

        if (this.emailTemplateService.enviaNotificaciones().equals("NO")){
            return;
        }

        if (entidad == null) {
            throw new ResourceNotFoundException();
        }
        try{
            String requester = "";

            String[] to = new String[1];
            String nombreRequester = "";
            String poDetail = "";
            int count = 0;
            String message;
            String fechaCierre = this.emailTemplateService.getFechaCierre();
            StringBuilder bld = new StringBuilder();
            for (VPurchaseOrderEntity entity : entidad){


                if(count == 0){
                    requester = entity.getUsuarioRequester();
                    nombreRequester = entity.getNombreRequester();
                }
                to[0] = requester;

                if(!entity.getUsuarioRequester().equals(requester))
                {
                    message = template.getMessage().replace(PODETAIL,bld.toString()).replace(USUARIO, nombreRequester).replace(FECHA, fechaCierre);
                    this.mailService.sendMail(EMAIL,to,template.getSubject(), message);
                    requester = entity.getUsuarioRequester();
                    nombreRequester = entity.getNombreRequester();
                    bld.setLength(0);
                    bld.append(entity.getHtmlRec());
                    to[0] = entity.getUsuarioRequester();

                }
                else
                {
                    bld.append(entity.getHtmlRec());
                }

                count ++;
            }
            poDetail = bld.toString();
            this.mailService.sendMail(EMAIL,to,template.getSubject(), template.getMessage().replace(PODETAIL,poDetail).replace(USUARIO, nombreRequester).replace(FECHA, fechaCierre));
        } catch (Exception ex) {
            logger.error(ex.getMessage());

            throw new ResourcesNotFoundException();
        }

        if (entidadDrc != null) enviaConfirmacionesDrc(entidadDrc, template);
        this.emailTemplateService.updateNotificaciones();
    }

    public void enviaConfirmacionesDrc(List<VPurchaseOrderDrcEntity> entidadDrc, EmailTemplateEntity template) throws ResourcesNotFoundException, ResourceNotFoundException, ResourceCreateException {
        try{
            String requester = "";
            String creator = "";
            String[] to = new String[2];
            String nombreRequester = "";
            String poDetail = "";
            int count = 0;
            String message;
            String fechaCierre = this.emailTemplateService.getFechaCierre();
            StringBuilder sbld = new StringBuilder();
            for (VPurchaseOrderDrcEntity entity : entidadDrc){

                if(count == 0){
                    requester = entity.getUsuarioRequester();
                    creator = entity.getUsuarioCreator();
                    nombreRequester = entity.getNombreRequester();
                }
                to[0] = requester;
                to[1] = creator;

                if(!entity.getUsuarioRequester().equals(requester)||!entity.getUsuarioCreator().equals(creator))
                {
                    message = template.getMessage().replace(PODETAIL,sbld.toString()).replace(USUARIO, nombreRequester).replace(FECHA, fechaCierre);
                    this.mailService.sendMail(EMAIL,to,template.getSubject(), message);
                    requester = entity.getUsuarioRequester();
                    creator = entity.getUsuarioCreator();
                    nombreRequester = entity.getNombreRequester();
                    sbld.setLength(0);
                    sbld.append(entity.getHtmlRec());
                    to[0] = entity.getUsuarioCreator();
                    to[1] = entity.getUsuarioRequester();

                }
                else
                {
                    sbld.append(entity.getHtmlRec());
                }

                count ++;
            }
            poDetail = sbld.toString();
            this.mailService.sendMail(EMAIL,to,template.getSubject(), template.getMessage().replace(PODETAIL,poDetail).replace(USUARIO, nombreRequester).replace(FECHA, fechaCierre));
        } catch (Exception ex) {
            logger.error(ex.getMessage());

            throw new ResourcesNotFoundException();
        }
    }
}
