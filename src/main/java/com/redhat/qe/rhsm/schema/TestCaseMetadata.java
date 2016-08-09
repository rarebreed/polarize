//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.08.09 at 12:28:39 PM EDT 
//


package com.redhat.qe.rhsm.schema;

import java.util.ArrayList;
import java.util.List;
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
 *       &lt;sequence>
 *         &lt;element name="workitems">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="testcase" type="{com.redhat.qe.rhsm.TestCaseType}testcase" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="project-id" use="required" type="{com.redhat.qe.rhsm.PolarizeTypes}project-vals" />
 *       &lt;attribute name="dry-run" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "workitems"
})
@XmlRootElement(name = "TestCaseMetadata")
public class TestCaseMetadata {

    @XmlElement(required = true)
    protected TestCaseMetadata.Workitems workitems;
    @XmlAttribute(name = "project-id", required = true)
    protected ProjectVals projectId;
    @XmlAttribute(name = "dry-run")
    protected Boolean dryRun;

    /**
     * Gets the value of the workitems property.
     * 
     * @return
     *     possible object is
     *     {@link TestCaseMetadata.Workitems }
     *     
     */
    public TestCaseMetadata.Workitems getWorkitems() {
        return workitems;
    }

    /**
     * Sets the value of the workitems property.
     * 
     * @param value
     *     allowed object is
     *     {@link TestCaseMetadata.Workitems }
     *     
     */
    public void setWorkitems(TestCaseMetadata.Workitems value) {
        this.workitems = value;
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
     * Gets the value of the dryRun property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDryRun() {
        return dryRun;
    }

    /**
     * Sets the value of the dryRun property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDryRun(Boolean value) {
        this.dryRun = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="testcase" type="{com.redhat.qe.rhsm.TestCaseType}testcase" maxOccurs="unbounded"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "testcase"
    })
    public static class Workitems {

        @XmlElement(required = true)
        protected List<Testcase> testcase;

        /**
         * Gets the value of the testcase property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the testcase property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getTestcase().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Testcase }
         * 
         * 
         */
        public List<Testcase> getTestcase() {
            if (testcase == null) {
                testcase = new ArrayList<Testcase>();
            }
            return this.testcase;
        }

    }

}
