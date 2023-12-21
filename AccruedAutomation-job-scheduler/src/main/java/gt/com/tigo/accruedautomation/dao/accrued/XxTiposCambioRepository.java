package gt.com.tigo.accruedautomation.dao.accrued;

import gt.com.tigo.accruedautomation.model.accrued.XxTiposCambioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface XxTiposCambioRepository extends JpaRepository<XxTiposCambioEntity, Long>, JpaSpecificationExecutor<XxTiposCambioEntity> {

    @Modifying
    @Transactional
    @Query(value = "Call sp_carga_tipos_cambio();" , nativeQuery = true)
    void spCargaTiposCambio();

    @Modifying
    @Transactional
    @Query(
            value = "Call sp_accrued_ejecuta_carga_datos_dwh();",
            nativeQuery = true
    )
    void procesarDatosDWH();
}
