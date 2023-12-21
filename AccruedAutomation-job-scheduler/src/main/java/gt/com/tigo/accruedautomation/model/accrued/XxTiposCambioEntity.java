package gt.com.tigo.accruedautomation.model.accrued;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "xx_tipos_cambio", schema = "", catalog = "")
public class XxTiposCambioEntity {
    private String moneda;
    private String simbolo;
    private Date fecha;
    private BigDecimal referencia;
    private Date fechaCreacion;
    private String estado;

    @Basic
    @Column(name = "moneda", nullable = false, length = 50)
    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    @Basic
    @Column(name = "simbolo", nullable = false, length = 10)
    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    @Id
    @Column(name = "fecha", nullable = false)
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Basic
    @Column(name = "referencia", nullable = false, precision = 6)
    public BigDecimal getReferencia() {
        return referencia;
    }

    public void setReferencia(BigDecimal referencia) {
        this.referencia = referencia;
    }

    @Basic
    @Column(name = "fecha_creacion", nullable = false)
    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @Basic
    @Column(name = "estado", nullable = true, length = 10)
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        XxTiposCambioEntity that = (XxTiposCambioEntity) o;
        return Objects.equals(moneda, that.moneda) &&
                Objects.equals(simbolo, that.simbolo) &&
                Objects.equals(fecha, that.fecha) &&
                Objects.equals(referencia, that.referencia) &&
                Objects.equals(fechaCreacion, that.fechaCreacion) &&
                Objects.equals(estado, that.estado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(moneda, simbolo, fecha, referencia, fechaCreacion, estado);
    }
}
