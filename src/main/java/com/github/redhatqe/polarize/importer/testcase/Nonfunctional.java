//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.09.13 at 10:59:40 AM EDT 
//


package com.github.redhatqe.polarize.importer.testcase;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="subtype1" default="-">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *             &lt;enumeration value="-"/>
 *             &lt;enumeration value="compliance"/>
 *             &lt;enumeration value="documentation"/>
 *             &lt;enumeration value="i18nl10n"/>
 *             &lt;enumeration value="installability"/>
 *             &lt;enumeration value="interoperability"/>
 *             &lt;enumeration value="performance"/>
 *             &lt;enumeration value="reliability"/>
 *             &lt;enumeration value="scalability"/>
 *             &lt;enumeration value="security"/>
 *             &lt;enumeration value="usability"/>
 *             &lt;enumeration value="recoveryfailover"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="subtype2" default="-">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *             &lt;enumeration value="-"/>
 *             &lt;enumeration value="compliance"/>
 *             &lt;enumeration value="documentation"/>
 *             &lt;enumeration value="i18nl10n"/>
 *             &lt;enumeration value="installability"/>
 *             &lt;enumeration value="interoperability"/>
 *             &lt;enumeration value="performance"/>
 *             &lt;enumeration value="reliability"/>
 *             &lt;enumeration value="scalability"/>
 *             &lt;enumeration value="security"/>
 *             &lt;enumeration value="usability"/>
 *             &lt;enumeration value="recoveryfailover"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "nonfunctional")
public class Nonfunctional {

    @XmlAttribute(name = "subtype1")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String subtype1;
    @XmlAttribute(name = "subtype2")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String subtype2;

    /**
     * Gets the value of the subtype1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubtype1() {
        if (subtype1 == null) {
            return "-";
        } else {
            return subtype1;
        }
    }

    /**
     * Sets the value of the subtype1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubtype1(String value) {
        this.subtype1 = value;
    }

    /**
     * Gets the value of the subtype2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubtype2() {
        if (subtype2 == null) {
            return "-";
        } else {
            return subtype2;
        }
    }

    /**
     * Sets the value of the subtype2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubtype2(String value) {
        this.subtype2 = value;
    }

}
