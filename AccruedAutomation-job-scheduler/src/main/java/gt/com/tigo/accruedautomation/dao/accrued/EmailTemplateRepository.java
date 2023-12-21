package gt.com.tigo.accruedautomation.dao.accrued;

import gt.com.tigo.accruedautomation.model.accrued.EmailTemplateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface EmailTemplateRepository extends JpaRepository<EmailTemplateEntity, Long>, JpaSpecificationExecutor<EmailTemplateEntity> {
    EmailTemplateEntity findByNombre(String nombre);

    @Query(
            value = "SELECT f_get_fecha_cierre_pos()fecha",
            nativeQuery = true
    )
    String fechaCierre();

    @Query(
            value = "SELECT f_get_envia_notificaciones()envia",
            nativeQuery = true
    )
    String enviaNotificaciones();

    @Modifying
    @Transactional
    @Query(value = "Call sp_actualiza_status_notificaciones();" , nativeQuery = true)
    void actualizaStatusNotificaciones();
}
