//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.07.18 at 01:45:10 PM EDT 
//


package com.redhat.qe.rhsm.schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wi-types.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="wi-types">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="TestCase"/>
 *     &lt;enumeration value="Requirement"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "wi-types", namespace = "com.redhat.qe.rhsm.PolarizeTypes")
@XmlEnum
public enum WiTypes {

    @XmlEnumValue("TestCase")
    TEST_CASE("TestCase"),
    @XmlEnumValue("Requirement")
    REQUIREMENT("Requirement");
    private final String value;

    WiTypes(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static WiTypes fromValue(String v) {
        for (WiTypes c: WiTypes.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
