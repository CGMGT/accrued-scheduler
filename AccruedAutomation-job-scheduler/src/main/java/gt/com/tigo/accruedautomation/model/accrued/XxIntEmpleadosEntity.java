package gt.com.tigo.accruedautomation.model.accrued;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "xx_int_empleados", schema = "", catalog = "")
public class XxIntEmpleadosEntity {
    private String estado;
    private String nombreEmpleado;
    private String correoTigo;
    private String nombreJefe;
    private String correoJefe;
    private String unidadDeNegocio;

    @Basic
    @Column(name = "estado", nullable = false, length = 50)
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Basic
    @Column(name = "nombre_empleado", nullable = true, length = 200)
    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    @Id
    @Basic
    @Column(name = "correo_tigo", nullable = false, length = 100)
    public String getCorreoTigo() {
        return correoTigo;
    }

    public void setCorreoTigo(String correoTigo) {
        this.correoTigo = correoTigo;
    }

    @Basic
    @Column(name = "nombre_jefe", nullable = true, length = 200)
    public String getNombreJefe() {
        return nombreJefe;
    }

    public void setNombreJefe(String nombreJefe) {
        this.nombreJefe = nombreJefe;
    }

    @Basic
    @Column(name = "correo_jefe", nullable = true, length = 100)
    public String getCorreoJefe() {
        return correoJefe;
    }

    public void setCorreoJefe(String correoJefe) {
        this.correoJefe = correoJefe;
    }

    @Basic
    @Column(name = "unidad_de_negocio", nullable = true, length = 100)
    public String getUnidadDeNegocio() {
        return unidadDeNegocio;
    }

    public void setUnidadDeNegocio(String unidadDeNegocio) {
        this.unidadDeNegocio = unidadDeNegocio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        XxIntEmpleadosEntity that = (XxIntEmpleadosEntity) o;
        return Objects.equals(estado, that.estado) &&
                Objects.equals(nombreEmpleado, that.nombreEmpleado) &&
                Objects.equals(correoTigo, that.correoTigo) &&
                Objects.equals(nombreJefe, that.nombreJefe) &&
                Objects.equals(correoJefe, that.correoJefe) &&
                Objects.equals(unidadDeNegocio, that.unidadDeNegocio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(estado, nombreEmpleado, correoTigo, nombreJefe, correoJefe, unidadDeNegocio);
    }
}
