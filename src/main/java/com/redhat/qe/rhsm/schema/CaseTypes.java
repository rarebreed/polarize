//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.06.24 at 03:03:21 PM EDT 
//


package com.redhat.qe.rhsm.schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for case-types.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="case-types">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="component"/>
 *     &lt;enumeration value="integration"/>
 *     &lt;enumeration value="system"/>
 *     &lt;enumeration value="acceptance"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "case-types")
@XmlEnum
public enum CaseTypes {

    @XmlEnumValue("component")
    COMPONENT("component"),
    @XmlEnumValue("integration")
    INTEGRATION("integration"),
    @XmlEnumValue("system")
    SYSTEM("system"),
    @XmlEnumValue("acceptance")
    ACCEPTANCE("acceptance");
    private final String value;

    CaseTypes(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CaseTypes fromValue(String v) {
        for (CaseTypes c: CaseTypes.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
