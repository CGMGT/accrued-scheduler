package gt.com.tigo.accruedautomation.model.accrued;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "v_purchase_order_drc", schema = "", catalog = "")
public class VPurchaseOrderDrcEntity {
    private int id;
    private String poNumber;
    private String recepcion;
    private String proveedor;
    private String concepto;
    private String moneda;
    private Double monto;
    private Double montoGtq;
    private Integer antiguedad;
    private String status;
    private String nombreRequester;
    private String usuarioRequester;
    private String nombreCreator;
    private String usuarioCreator;
    private String nombreJefeRequester;
    private String usuarioJefeRequester;
    private String antiguedadPeriodo;
    private String origen;
    private String entidad;
    private String htmlRec;

    @Id
    @Column(name = "id", nullable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "po_number", nullable = true, length = 150)
    public String getPoNumber() {
        return poNumber;
    }

    public void setPoNumber(String poNumber) {
        this.poNumber = poNumber;
    }

    @Basic
    @Column(name = "recepcion", nullable = true, length = 150)
    public String getRecepcion() {
        return recepcion;
    }

    public void setRecepcion(String recepcion) {
        this.recepcion = recepcion;
    }

    @Basic
    @Column(name = "proveedor", nullable = true, length = 250)
    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    @Basic
    @Column(name = "concepto", nullable = true, length = 1000)
    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    @Basic
    @Column(name = "moneda", nullable = true, length = 50)
    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    @Basic
    @Column(name = "monto", nullable = true, precision = 0)
    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    @Basic
    @Column(name = "monto_gtq", nullable = true, precision = 0)
    public Double getMontoGtq() {
        return montoGtq;
    }

    public void setMontoGtq(Double montoGtq) {
        this.montoGtq = montoGtq;
    }

    @Basic
    @Column(name = "antiguedad", nullable = true)
    public Integer getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(Integer antiguedad) {
        this.antiguedad = antiguedad;
    }

    @Basic
    @Column(name = "status", nullable = true, length = -1)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "nombre_requester", nullable = true, length = 250)
    public String getNombreRequester() {
        return nombreRequester;
    }

    public void setNombreRequester(String nombreRequester) {
        this.nombreRequester = nombreRequester;
    }

    @Basic
    @Column(name = "usuario_requester", nullable = true, length = 150)
    public String getUsuarioRequester() {
        return usuarioRequester;
    }

    public void setUsuarioRequester(String usuarioRequester) {
        this.usuarioRequester = usuarioRequester;
    }

    @Basic
    @Column(name = "nombre_creator", nullable = true, length = 250)
    public String getNombreCreator() {
        return nombreCreator;
    }

    public void setNombreCreator(String nombreCreator) {
        this.nombreCreator = nombreCreator;
    }

    @Basic
    @Column(name = "usuario_creator", nullable = true, length = 150)
    public String getUsuarioCreator() {
        return usuarioCreator;
    }

    public void setUsuarioCreator(String usuarioCreator) {
        this.usuarioCreator = usuarioCreator;
    }

    @Basic
    @Column(name = "nombre_jefe_requester", nullable = true, length = 250)
    public String getNombreJefeRequester() {
        return nombreJefeRequester;
    }

    public void setNombreJefeRequester(String nombreJefeRequester) {
        this.nombreJefeRequester = nombreJefeRequester;
    }

    @Basic
    @Column(name = "usuario_jefe_requester", nullable = true, length = 150)
    public String getUsuarioJefeRequester() {
        return usuarioJefeRequester;
    }

    public void setUsuarioJefeRequester(String usuarioJefeRequester) {
        this.usuarioJefeRequester = usuarioJefeRequester;
    }

    @Basic
    @Column(name = "antiguedad_periodo", nullable = true, length = -1)
    public String getAntiguedadPeriodo() {
        return antiguedadPeriodo;
    }

    public void setAntiguedadPeriodo(String antiguedadPeriodo) {
        this.antiguedadPeriodo = antiguedadPeriodo;
    }

    @Basic
    @Column(name = "origen", nullable = true, length = 150)
    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    @Basic
    @Column(name = "entidad", nullable = true, length = 150)
    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    @Basic
    @Column(name = "html_rec", nullable = true, length = -1)
    public String getHtmlRec() {
        return htmlRec;
    }

    public void setHtmlRec(String htmlRec) {
        this.htmlRec = htmlRec;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VPurchaseOrderDrcEntity that = (VPurchaseOrderDrcEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(poNumber, that.poNumber) &&
                Objects.equals(recepcion, that.recepcion) &&
                Objects.equals(proveedor, that.proveedor) &&
                Objects.equals(concepto, that.concepto) &&
                Objects.equals(moneda, that.moneda) &&
                Objects.equals(monto, that.monto) &&
                Objects.equals(montoGtq, that.montoGtq) &&
                Objects.equals(antiguedad, that.antiguedad) &&
                Objects.equals(status, that.status) &&
                Objects.equals(nombreRequester, that.nombreRequester) &&
                Objects.equals(usuarioRequester, that.usuarioRequester) &&
                Objects.equals(nombreCreator, that.nombreCreator) &&
                Objects.equals(usuarioCreator, that.usuarioCreator) &&
                Objects.equals(nombreJefeRequester, that.nombreJefeRequester) &&
                Objects.equals(usuarioJefeRequester, that.usuarioJefeRequester) &&
                Objects.equals(antiguedadPeriodo, that.antiguedadPeriodo) &&
                Objects.equals(origen, that.origen) &&
                Objects.equals(entidad, that.entidad) &&
                Objects.equals(htmlRec, that.htmlRec);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, poNumber, recepcion, proveedor, concepto, moneda, monto, montoGtq, antiguedad, status, nombreRequester, usuarioRequester, nombreCreator, usuarioCreator, nombreJefeRequester, usuarioJefeRequester, antiguedadPeriodo, origen, entidad, htmlRec);
    }
}
