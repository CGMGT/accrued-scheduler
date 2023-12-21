package gt.com.tigo.accruedautomation.dao.vhur;

import gt.com.tigo.accruedautomation.model.vhur.EmpleadosVhurEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpleadosVhurRepository extends JpaRepository<EmpleadosVhurEntity, Long>{


    @Query(value = "Select distinct ESTADO_EMPLEADO estado, NOMBRE_COMPLETO nombreEmpleado, \n" +
            "       LOWER(CORREO_TIGO) correoTigo, NOMBRE_JEFE nombreJefe, LOWER(EMAIL_JEFE) correoJefe, NOMBRE_BU unidadDeNegocio \n" +
            " from VIEW_ACCRUED_AUTOMATION_FINANZAS \n" +
            " where ISNULL(CORREO_TIGO,'NO APLICA') <> 'NO APLICA' AND LEN(RTRIM(CORREO_TIGO)) > 1" , nativeQuery = true)
    List<EmpleadosVhurEntity> findAll();

    @Query(value = "Select distinct ESTADO_EMPLEADO estado, NOMBRE_COMPLETO nombreEmpleado, \n" +
            "       LOWER(CORREO_TIGO) correoTigo, NOMBRE_JEFE nombreJefe, LOWER(EMAIL_JEFE) correoJefe, NOMBRE_BU unidadDeNegocio \n" +
            "from VIEW_ACCRUED_AUTOMATION_FINANZAS " +
            "where ISNULL(CORREO_TIGO,'NO APLICA') <> 'NO APLICA' AND LEN(RTRIM(CORREO_TIGO)) > 1 " +
            "order by NOMBRE_COMPLETO OFFSET ?1 ROWS FETCH NEXT ?2 ROWS ONLY" ,
            countQuery = "select count(*) from VIEW_ACCRUED_AUTOMATION_FINANZAS",
            nativeQuery = true)
    List<EmpleadosVhurEntity> findAllByPage(long offset, long fetchRows);
}
