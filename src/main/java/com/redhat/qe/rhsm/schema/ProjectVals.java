//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.08.09 at 12:28:39 PM EDT 
//


package com.redhat.qe.rhsm.schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for project-vals.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="project-vals">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="RHEL6"/>
 *     &lt;enumeration value="RedHatEnterpriseLinux7"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "project-vals", namespace = "com.redhat.qe.rhsm.PolarizeTypes")
@XmlEnum
public enum ProjectVals {

    @XmlEnumValue("RHEL6")
    RHEL_6("RHEL6"),
    @XmlEnumValue("RedHatEnterpriseLinux7")
    RED_HAT_ENTERPRISE_LINUX_7("RedHatEnterpriseLinux7");
    private final String value;

    ProjectVals(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ProjectVals fromValue(String v) {
        for (ProjectVals c: ProjectVals.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
