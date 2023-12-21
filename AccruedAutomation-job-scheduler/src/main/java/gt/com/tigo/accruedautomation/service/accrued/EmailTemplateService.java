package gt.com.tigo.accruedautomation.service.accrued;

import gt.com.tigo.accruedautomation.dao.accrued.EmailTemplateRepository;
import gt.com.tigo.accruedautomation.dto.DataTableRequestDto;
import gt.com.tigo.accruedautomation.dto.PaginatedDataDto;
import gt.com.tigo.accruedautomation.model.accrued.EmailTemplateEntity;
import gt.com.tigo.accruedautomation.service.ICatalog;
import gt.com.tigo.accruedautomation.util.exception.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class EmailTemplateService implements ICatalog<EmailTemplateEntity> {
    private static final Logger logger = LoggerFactory.getLogger(EmailTemplateService.class);

    @Autowired
    private EmailTemplateRepository emailTemplateRepository;

    @Override
    public List<EmailTemplateEntity> findAll() throws ResourcesNotFoundException {
        return Collections.emptyList();
    }

    @Override
    public PaginatedDataDto<EmailTemplateEntity> findAllByPage(DataTableRequestDto dataTableRequestDto) throws ResourcesNotFoundException {
        return null;
    }

    @Override
    public EmailTemplateEntity findById(Long id) throws ResourceNotFoundException {
        return null;
    }

    public EmailTemplateEntity findByName(String name) throws ResourceNotFoundException {
        logger.debug(String.format("@%s::findByName(%s)", this.getClass().getName(), name));


        return this.emailTemplateRepository.findByNombre(name);
    }

    public String getFechaCierre() throws ResourceNotFoundException {
        logger.debug(String.format("@%s::getFechaCierre()", this.getClass().getName()));

        return this.emailTemplateRepository.fechaCierre();
    }

    public String enviaNotificaciones() throws ResourceNotFoundException {
        logger.debug(String.format("@%s::EnviaNotificaciones()", this.getClass().getName()));

        return this.emailTemplateRepository.enviaNotificaciones();
    }

    public String updateNotificaciones() throws ResourceNotFoundException, ResourceCreateException {
        logger.debug(String.format("@%s::UpdateNotificaciones()", this.getClass().getName()));

        try{
            this.emailTemplateRepository.actualizaStatusNotificaciones();
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            throw new ResourceCreateException();
        }

        return null;
    }

    @Override
    public EmailTemplateEntity create(EmailTemplateEntity entity, Long requesterId) throws RequesterNotFoundException, ResourceCreateException {
        return null;
    }

    @Override
    public EmailTemplateEntity update(EmailTemplateEntity entity, Long requesterId) throws RequesterNotFoundException, ResourceUpdateException {
        return null;
    }

    @Override
    public EmailTemplateEntity delete(Long entityId, Long requesterId) throws RequesterNotFoundException, ResourceNotFoundException, ResourceUpdateException {
        return null;
    }
}
