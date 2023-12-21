package gt.com.tigo.accruedautomation.model.vhur;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EmpleadosVhurEntity {
    private String estado;
    private String nombreEmpleado;
    private String correoTigo;
    private String nombreJefe;
    private String correoJefe;
    private String unidadDeNegocio;

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    @Id
    public String getCorreoTigo() {
        return correoTigo;
    }

    public void setCorreoTigo(String correoTigo) {
        this.correoTigo = correoTigo;
    }

    public String getNombreJefe() {
        return nombreJefe;
    }

    public void setNombreJefe(String nombreJefe) {
        this.nombreJefe = nombreJefe;
    }

    public String getCorreoJefe() {
        return correoJefe;
    }

    public void setCorreoJefe(String correoJefe) {
        this.correoJefe = correoJefe;
    }

    public String getUnidadDeNegocio() {
        return unidadDeNegocio;
    }

    public void setUnidadDeNegocio(String unidadDeNegocio) {
        this.unidadDeNegocio = unidadDeNegocio;
    }



}
