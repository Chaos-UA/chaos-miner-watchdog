//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.03.11 at 04:03:19 PM EET 
//


package com.chaos.crypto.ewbf.watchdog.nvidia.sli.dtd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "currentGom",
    "pendingGom"
})
@XmlRootElement(name = "gpu_operation_mode")
public class GpuOperationMode {

    @XmlElement(name = "current_gom", required = true)
    protected String currentGom;
    @XmlElement(name = "pending_gom", required = true)
    protected String pendingGom;

    /**
     * Gets the value of the currentGom property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrentGom() {
        return currentGom;
    }

    /**
     * Sets the value of the currentGom property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrentGom(String value) {
        this.currentGom = value;
    }

    /**
     * Gets the value of the pendingGom property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPendingGom() {
        return pendingGom;
    }

    /**
     * Sets the value of the pendingGom property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPendingGom(String value) {
        this.pendingGom = value;
    }

}
