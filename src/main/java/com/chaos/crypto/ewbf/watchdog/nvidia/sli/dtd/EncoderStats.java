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
    "sessionCount",
    "averageFps",
    "averageLatency"
})
@XmlRootElement(name = "encoder_stats")
public class EncoderStats {

    @XmlElement(name = "session_count", required = true)
    protected String sessionCount;
    @XmlElement(name = "average_fps", required = true)
    protected String averageFps;
    @XmlElement(name = "average_latency", required = true)
    protected String averageLatency;

    /**
     * Gets the value of the sessionCount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSessionCount() {
        return sessionCount;
    }

    /**
     * Sets the value of the sessionCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSessionCount(String value) {
        this.sessionCount = value;
    }

    /**
     * Gets the value of the averageFps property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAverageFps() {
        return averageFps;
    }

    /**
     * Sets the value of the averageFps property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAverageFps(String value) {
        this.averageFps = value;
    }

    /**
     * Gets the value of the averageLatency property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAverageLatency() {
        return averageLatency;
    }

    /**
     * Sets the value of the averageLatency property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAverageLatency(String value) {
        this.averageLatency = value;
    }

}
