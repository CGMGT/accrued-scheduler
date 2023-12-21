package gt.com.tigo.accruedautomation.dao.accrued;

import gt.com.tigo.accruedautomation.model.accrued.XxIntEmpleadosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface XxIntEmpleadosRepository extends JpaRepository<XxIntEmpleadosEntity, Long>, JpaSpecificationExecutor<XxIntEmpleadosEntity> {

    @Modifying
    @Transactional
    @Query(value = "Call sp_carga_empleados_vhur();" , nativeQuery = true)
    void spCargaEmpleadosVhur();
}
