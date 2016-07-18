//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.07.18 at 01:45:10 PM EDT 
//


package com.redhat.qe.rhsm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="testcase" type="{com.redhat.qe.rhsm.TestCaseType}testcase"/>
 *         &lt;element name="requirement" type="{com.redhat.qe.rhsm.RequirementType}req-type"/>
 *       &lt;/choice>
 *       &lt;attribute name="project-id" use="required" type="{com.redhat.qe.rhsm.PolarizeTypes}project-vals" />
 *       &lt;attribute name="type" use="required" type="{com.redhat.qe.rhsm.PolarizeTypes}wi-types" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "testcase",
    "requirement"
})
@XmlRootElement(name = "WorkItem", namespace = "com.redhat.qe.rhsm.WorkItemType")
public class WorkItem {

    @XmlElement(namespace = "com.redhat.qe.rhsm.WorkItemType")
    protected Testcase testcase;
    @XmlElement(namespace = "com.redhat.qe.rhsm.WorkItemType")
    protected ReqType requirement;
    @XmlAttribute(name = "project-id", required = true)
    protected ProjectVals projectId;
    @XmlAttribute(name = "type", required = true)
    protected WiTypes type;

    /**
     * Gets the value of the testcase property.
     * 
     * @return
     *     possible object is
     *     {@link Testcase }
     *     
     */
    public Testcase getTestcase() {
        return testcase;
    }

    /**
     * Sets the value of the testcase property.
     * 
     * @param value
     *     allowed object is
     *     {@link Testcase }
     *     
     */
    public void setTestcase(Testcase value) {
        this.testcase = value;
    }

    /**
     * Gets the value of the requirement property.
     * 
     * @return
     *     possible object is
     *     {@link ReqType }
     *     
     */
    public ReqType getRequirement() {
        return requirement;
    }

    /**
     * Sets the value of the requirement property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReqType }
     *     
     */
    public void setRequirement(ReqType value) {
        this.requirement = value;
    }

    /**
     * Gets the value of the projectId property.
     * 
     * @return
     *     possible object is
     *     {@link ProjectVals }
     *     
     */
    public ProjectVals getProjectId() {
        return projectId;
    }

    /**
     * Sets the value of the projectId property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProjectVals }
     *     
     */
    public void setProjectId(ProjectVals value) {
        this.projectId = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link WiTypes }
     *     
     */
    public WiTypes getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link WiTypes }
     *     
     */
    public void setType(WiTypes value) {
        this.type = value;
    }

}
