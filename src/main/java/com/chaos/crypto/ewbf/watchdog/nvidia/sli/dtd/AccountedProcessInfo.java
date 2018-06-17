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
    "pid",
    "gpuUtil",
    "memoryUtil",
    "maxMemoryUsage",
    "time",
    "isRunning"
})
@XmlRootElement(name = "accounted_process_info")
public class AccountedProcessInfo {

    @XmlElement(required = true)
    protected String pid;
    @XmlElement(name = "gpu_util", required = true)
    protected String gpuUtil;
    @XmlElement(name = "memory_util", required = true)
    protected String memoryUtil;
    @XmlElement(name = "max_memory_usage", required = true)
    protected String maxMemoryUsage;
    @XmlElement(required = true)
    protected String time;
    @XmlElement(name = "is_running", required = true)
    protected String isRunning;

    /**
     * Gets the value of the pid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPid() {
        return pid;
    }

    /**
     * Sets the value of the pid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPid(String value) {
        this.pid = value;
    }

    /**
     * Gets the value of the gpuUtil property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGpuUtil() {
        return gpuUtil;
    }

    /**
     * Sets the value of the gpuUtil property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGpuUtil(String value) {
        this.gpuUtil = value;
    }

    /**
     * Gets the value of the memoryUtil property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMemoryUtil() {
        return memoryUtil;
    }

    /**
     * Sets the value of the memoryUtil property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMemoryUtil(String value) {
        this.memoryUtil = value;
    }

    /**
     * Gets the value of the maxMemoryUsage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaxMemoryUsage() {
        return maxMemoryUsage;
    }

    /**
     * Sets the value of the maxMemoryUsage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaxMemoryUsage(String value) {
        this.maxMemoryUsage = value;
    }

    /**
     * Gets the value of the time property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTime() {
        return time;
    }

    /**
     * Sets the value of the time property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTime(String value) {
        this.time = value;
    }

    /**
     * Gets the value of the isRunning property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsRunning() {
        return isRunning;
    }

    /**
     * Sets the value of the isRunning property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsRunning(String value) {
        this.isRunning = value;
    }

}
