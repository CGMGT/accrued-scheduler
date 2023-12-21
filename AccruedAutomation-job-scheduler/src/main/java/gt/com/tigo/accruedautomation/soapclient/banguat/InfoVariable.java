//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.11 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2022.04.08 a las 05:10:42 PM CST 
//


package gt.com.tigo.accruedautomation.soapclient.banguat;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para InfoVariable complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="InfoVariable"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Variables" type="{http://www.banguat.gob.gt/variables/ws/}ArrayOfVariable" minOccurs="0"/&gt;
 *         &lt;element name="CambioDia" type="{http://www.banguat.gob.gt/variables/ws/}ArrayOfVar" minOccurs="0"/&gt;
 *         &lt;element name="CambioDolar" type="{http://www.banguat.gob.gt/variables/ws/}ArrayOfVarDolar" minOccurs="0"/&gt;
 *         &lt;element name="TotalItems" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InfoVariable", propOrder = {
    "variables",
    "cambioDia",
    "cambioDolar",
    "totalItems"
})
public class InfoVariable {

    @XmlElement(name = "Variables")
    protected ArrayOfVariable variables;
    @XmlElement(name = "CambioDia")
    protected ArrayOfVar cambioDia;
    @XmlElement(name = "CambioDolar")
    protected ArrayOfVarDolar cambioDolar;
    @XmlElement(name = "TotalItems")
    protected int totalItems;

    /**
     * Obtiene el valor de la propiedad variables.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfVariable }
     *     
     */
    public ArrayOfVariable getVariables() {
        return variables;
    }

    /**
     * Define el valor de la propiedad variables.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfVariable }
     *     
     */
    public void setVariables(ArrayOfVariable value) {
        this.variables = value;
    }

    /**
     * Obtiene el valor de la propiedad cambioDia.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfVar }
     *     
     */
    public ArrayOfVar getCambioDia() {
        return cambioDia;
    }

    /**
     * Define el valor de la propiedad cambioDia.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfVar }
     *     
     */
    public void setCambioDia(ArrayOfVar value) {
        this.cambioDia = value;
    }

    /**
     * Obtiene el valor de la propiedad cambioDolar.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfVarDolar }
     *     
     */
    public ArrayOfVarDolar getCambioDolar() {
        return cambioDolar;
    }

    /**
     * Define el valor de la propiedad cambioDolar.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfVarDolar }
     *     
     */
    public void setCambioDolar(ArrayOfVarDolar value) {
        this.cambioDolar = value;
    }

    /**
     * Obtiene el valor de la propiedad totalItems.
     * 
     */
    public int getTotalItems() {
        return totalItems;
    }

    /**
     * Define el valor de la propiedad totalItems.
     * 
     */
    public void setTotalItems(int value) {
        this.totalItems = value;
    }

}
