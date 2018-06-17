//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.03.11 at 04:03:19 PM EET 
//


package com.chaos.crypto.ewbf.watchdog.nvidia.sli.dtd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "productName",
    "productBrand",
    "displayMode",
    "displayActive",
    "persistenceMode",
    "accountingMode",
    "accountingModeBufferSize",
    "driverModel",
    "serial",
    "uuid",
    "minorNumber",
    "vbiosVersion",
    "multigpuBoard",
    "boardId",
    "gpuPartNumber",
    "inforomVersion",
    "gpuOperationMode",
    "gpuVirtualizationMode",
    "pci",
    "fanSpeed",
    "performanceState",
    "clocksThrottleReasons",
    "fbMemoryUsage",
    "bar1MemoryUsage",
    "computeMode",
    "utilization",
    "encoderStats",
    "eccMode",
    "eccErrors",
    "retiredPages",
    "temperature",
    "powerReadings",
    "clocks",
    "applicationsClocks",
    "defaultApplicationsClocks",
    "maxClocks",
    "maxCustomerBoostClocks",
    "clockPolicy",
    "supportedClocks",
    "processes",
    "accountedProcesses"
})
@XmlRootElement(name = "gpu")
public class Gpu {

    @XmlAttribute(name = "id", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String id;
    @XmlElement(name = "product_name", required = true)
    protected String productName;
    @XmlElement(name = "product_brand", required = true)
    protected String productBrand;
    @XmlElement(name = "display_mode", required = true)
    protected String displayMode;
    @XmlElement(name = "display_active", required = true)
    protected String displayActive;
    @XmlElement(name = "persistence_mode", required = true)
    protected String persistenceMode;
    @XmlElement(name = "accounting_mode", required = true)
    protected String accountingMode;
    @XmlElement(name = "accounting_mode_buffer_size", required = true)
    protected String accountingModeBufferSize;
    @XmlElement(name = "driver_model")
    protected DriverModel driverModel;
    @XmlElement(required = true)
    protected String serial;
    @XmlElement(required = true)
    protected String uuid;
    @XmlElement(name = "minor_number", required = true)
    protected String minorNumber;
    @XmlElement(name = "vbios_version", required = true)
    protected String vbiosVersion;
    @XmlElement(name = "multigpu_board", required = true)
    protected String multigpuBoard;
    @XmlElement(name = "board_id", required = true)
    protected String boardId;
    @XmlElement(name = "gpu_part_number", required = true)
    protected String gpuPartNumber;
    @XmlElement(name = "inforom_version", required = true)
    protected InforomVersion inforomVersion;
    @XmlElement(name = "gpu_operation_mode", required = true)
    protected GpuOperationMode gpuOperationMode;
    @XmlElement(name = "gpu_virtualization_mode", required = true)
    protected GpuVirtualizationMode gpuVirtualizationMode;
    @XmlElement(required = true)
    protected Pci pci;
    @XmlElement(name = "fan_speed", required = true)
    protected String fanSpeed;
    @XmlElement(name = "performance_state", required = true)
    protected String performanceState;
    @XmlElement(name = "clocks_throttle_reasons", required = true)
    protected String clocksThrottleReasons;
    @XmlElement(name = "fb_memory_usage", required = true)
    protected FbMemoryUsage fbMemoryUsage;
    @XmlElement(name = "bar1_memory_usage", required = true)
    protected Bar1MemoryUsage bar1MemoryUsage;
    @XmlElement(name = "compute_mode", required = true)
    protected String computeMode;
    @XmlElement(required = true)
    protected Utilization utilization;
    @XmlElement(name = "encoder_stats", required = true)
    protected EncoderStats encoderStats;
    @XmlElement(name = "ecc_mode", required = true)
    protected EccMode eccMode;
    @XmlElement(name = "ecc_errors", required = true)
    protected EccErrors eccErrors;
    @XmlElement(name = "retired_pages", required = true)
    protected RetiredPages retiredPages;
    @XmlElement(required = true)
    protected Temperature temperature;
    @XmlElement(name = "power_readings", required = true)
    protected PowerReadings powerReadings;
    @XmlElement(required = true)
    protected Clocks clocks;
    @XmlElement(name = "applications_clocks", required = true)
    protected ApplicationsClocks applicationsClocks;
    @XmlElement(name = "default_applications_clocks", required = true)
    protected DefaultApplicationsClocks defaultApplicationsClocks;
    @XmlElement(name = "max_clocks", required = true)
    protected MaxClocks maxClocks;
    @XmlElement(name = "max_customer_boost_clocks", required = true)
    protected MaxCustomerBoostClocks maxCustomerBoostClocks;
    @XmlElement(name = "clock_policy", required = true)
    protected ClockPolicy clockPolicy;
    @XmlElement(name = "supported_clocks", required = true)
    protected String supportedClocks;
    @XmlElement(required = true)
    protected String processes;
    @XmlElement(name = "accounted_processes", required = true)
    protected String accountedProcesses;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the productName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Sets the value of the productName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductName(String value) {
        this.productName = value;
    }

    /**
     * Gets the value of the productBrand property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductBrand() {
        return productBrand;
    }

    /**
     * Sets the value of the productBrand property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductBrand(String value) {
        this.productBrand = value;
    }

    /**
     * Gets the value of the displayMode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDisplayMode() {
        return displayMode;
    }

    /**
     * Sets the value of the displayMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDisplayMode(String value) {
        this.displayMode = value;
    }

    /**
     * Gets the value of the displayActive property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDisplayActive() {
        return displayActive;
    }

    /**
     * Sets the value of the displayActive property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDisplayActive(String value) {
        this.displayActive = value;
    }

    /**
     * Gets the value of the persistenceMode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPersistenceMode() {
        return persistenceMode;
    }

    /**
     * Sets the value of the persistenceMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPersistenceMode(String value) {
        this.persistenceMode = value;
    }

    /**
     * Gets the value of the accountingMode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountingMode() {
        return accountingMode;
    }

    /**
     * Sets the value of the accountingMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountingMode(String value) {
        this.accountingMode = value;
    }

    /**
     * Gets the value of the accountingModeBufferSize property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountingModeBufferSize() {
        return accountingModeBufferSize;
    }

    /**
     * Sets the value of the accountingModeBufferSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountingModeBufferSize(String value) {
        this.accountingModeBufferSize = value;
    }

    /**
     * Gets the value of the driverModel property.
     * 
     * @return
     *     possible object is
     *     {@link DriverModel }
     *     
     */
    public DriverModel getDriverModel() {
        return driverModel;
    }

    /**
     * Sets the value of the driverModel property.
     * 
     * @param value
     *     allowed object is
     *     {@link DriverModel }
     *     
     */
    public void setDriverModel(DriverModel value) {
        this.driverModel = value;
    }

    /**
     * Gets the value of the serial property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSerial() {
        return serial;
    }

    /**
     * Sets the value of the serial property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSerial(String value) {
        this.serial = value;
    }

    /**
     * Gets the value of the uuid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * Sets the value of the uuid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUuid(String value) {
        this.uuid = value;
    }

    /**
     * Gets the value of the minorNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMinorNumber() {
        return minorNumber;
    }

    /**
     * Sets the value of the minorNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMinorNumber(String value) {
        this.minorNumber = value;
    }

    /**
     * Gets the value of the vbiosVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVbiosVersion() {
        return vbiosVersion;
    }

    /**
     * Sets the value of the vbiosVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVbiosVersion(String value) {
        this.vbiosVersion = value;
    }

    /**
     * Gets the value of the multigpuBoard property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMultigpuBoard() {
        return multigpuBoard;
    }

    /**
     * Sets the value of the multigpuBoard property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMultigpuBoard(String value) {
        this.multigpuBoard = value;
    }

    /**
     * Gets the value of the boardId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBoardId() {
        return boardId;
    }

    /**
     * Sets the value of the boardId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBoardId(String value) {
        this.boardId = value;
    }

    /**
     * Gets the value of the gpuPartNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGpuPartNumber() {
        return gpuPartNumber;
    }

    /**
     * Sets the value of the gpuPartNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGpuPartNumber(String value) {
        this.gpuPartNumber = value;
    }

    /**
     * Gets the value of the inforomVersion property.
     * 
     * @return
     *     possible object is
     *     {@link InforomVersion }
     *     
     */
    public InforomVersion getInforomVersion() {
        return inforomVersion;
    }

    /**
     * Sets the value of the inforomVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link InforomVersion }
     *     
     */
    public void setInforomVersion(InforomVersion value) {
        this.inforomVersion = value;
    }

    /**
     * Gets the value of the gpuOperationMode property.
     * 
     * @return
     *     possible object is
     *     {@link GpuOperationMode }
     *     
     */
    public GpuOperationMode getGpuOperationMode() {
        return gpuOperationMode;
    }

    /**
     * Sets the value of the gpuOperationMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link GpuOperationMode }
     *     
     */
    public void setGpuOperationMode(GpuOperationMode value) {
        this.gpuOperationMode = value;
    }

    /**
     * Gets the value of the gpuVirtualizationMode property.
     * 
     * @return
     *     possible object is
     *     {@link GpuVirtualizationMode }
     *     
     */
    public GpuVirtualizationMode getGpuVirtualizationMode() {
        return gpuVirtualizationMode;
    }

    /**
     * Sets the value of the gpuVirtualizationMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link GpuVirtualizationMode }
     *     
     */
    public void setGpuVirtualizationMode(GpuVirtualizationMode value) {
        this.gpuVirtualizationMode = value;
    }

    /**
     * Gets the value of the pci property.
     * 
     * @return
     *     possible object is
     *     {@link Pci }
     *     
     */
    public Pci getPci() {
        return pci;
    }

    /**
     * Sets the value of the pci property.
     * 
     * @param value
     *     allowed object is
     *     {@link Pci }
     *     
     */
    public void setPci(Pci value) {
        this.pci = value;
    }

    /**
     * Gets the value of the fanSpeed property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFanSpeed() {
        return fanSpeed;
    }

    /**
     * Sets the value of the fanSpeed property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFanSpeed(String value) {
        this.fanSpeed = value;
    }

    /**
     * Gets the value of the performanceState property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPerformanceState() {
        return performanceState;
    }

    /**
     * Sets the value of the performanceState property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPerformanceState(String value) {
        this.performanceState = value;
    }

    /**
     * Gets the value of the clocksThrottleReasons property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClocksThrottleReasons() {
        return clocksThrottleReasons;
    }

    /**
     * Sets the value of the clocksThrottleReasons property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClocksThrottleReasons(String value) {
        this.clocksThrottleReasons = value;
    }

    /**
     * Gets the value of the fbMemoryUsage property.
     * 
     * @return
     *     possible object is
     *     {@link FbMemoryUsage }
     *     
     */
    public FbMemoryUsage getFbMemoryUsage() {
        return fbMemoryUsage;
    }

    /**
     * Sets the value of the fbMemoryUsage property.
     * 
     * @param value
     *     allowed object is
     *     {@link FbMemoryUsage }
     *     
     */
    public void setFbMemoryUsage(FbMemoryUsage value) {
        this.fbMemoryUsage = value;
    }

    /**
     * Gets the value of the bar1MemoryUsage property.
     * 
     * @return
     *     possible object is
     *     {@link Bar1MemoryUsage }
     *     
     */
    public Bar1MemoryUsage getBar1MemoryUsage() {
        return bar1MemoryUsage;
    }

    /**
     * Sets the value of the bar1MemoryUsage property.
     * 
     * @param value
     *     allowed object is
     *     {@link Bar1MemoryUsage }
     *     
     */
    public void setBar1MemoryUsage(Bar1MemoryUsage value) {
        this.bar1MemoryUsage = value;
    }

    /**
     * Gets the value of the computeMode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComputeMode() {
        return computeMode;
    }

    /**
     * Sets the value of the computeMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComputeMode(String value) {
        this.computeMode = value;
    }

    /**
     * Gets the value of the utilization property.
     * 
     * @return
     *     possible object is
     *     {@link Utilization }
     *     
     */
    public Utilization getUtilization() {
        return utilization;
    }

    /**
     * Sets the value of the utilization property.
     * 
     * @param value
     *     allowed object is
     *     {@link Utilization }
     *     
     */
    public void setUtilization(Utilization value) {
        this.utilization = value;
    }

    /**
     * Gets the value of the encoderStats property.
     * 
     * @return
     *     possible object is
     *     {@link EncoderStats }
     *     
     */
    public EncoderStats getEncoderStats() {
        return encoderStats;
    }

    /**
     * Sets the value of the encoderStats property.
     * 
     * @param value
     *     allowed object is
     *     {@link EncoderStats }
     *     
     */
    public void setEncoderStats(EncoderStats value) {
        this.encoderStats = value;
    }

    /**
     * Gets the value of the eccMode property.
     * 
     * @return
     *     possible object is
     *     {@link EccMode }
     *     
     */
    public EccMode getEccMode() {
        return eccMode;
    }

    /**
     * Sets the value of the eccMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link EccMode }
     *     
     */
    public void setEccMode(EccMode value) {
        this.eccMode = value;
    }

    /**
     * Gets the value of the eccErrors property.
     * 
     * @return
     *     possible object is
     *     {@link EccErrors }
     *     
     */
    public EccErrors getEccErrors() {
        return eccErrors;
    }

    /**
     * Sets the value of the eccErrors property.
     * 
     * @param value
     *     allowed object is
     *     {@link EccErrors }
     *     
     */
    public void setEccErrors(EccErrors value) {
        this.eccErrors = value;
    }

    /**
     * Gets the value of the retiredPages property.
     * 
     * @return
     *     possible object is
     *     {@link RetiredPages }
     *     
     */
    public RetiredPages getRetiredPages() {
        return retiredPages;
    }

    /**
     * Sets the value of the retiredPages property.
     * 
     * @param value
     *     allowed object is
     *     {@link RetiredPages }
     *     
     */
    public void setRetiredPages(RetiredPages value) {
        this.retiredPages = value;
    }

    /**
     * Gets the value of the temperature property.
     * 
     * @return
     *     possible object is
     *     {@link Temperature }
     *     
     */
    public Temperature getTemperature() {
        return temperature;
    }

    /**
     * Sets the value of the temperature property.
     * 
     * @param value
     *     allowed object is
     *     {@link Temperature }
     *     
     */
    public void setTemperature(Temperature value) {
        this.temperature = value;
    }

    /**
     * Gets the value of the powerReadings property.
     * 
     * @return
     *     possible object is
     *     {@link PowerReadings }
     *     
     */
    public PowerReadings getPowerReadings() {
        return powerReadings;
    }

    /**
     * Sets the value of the powerReadings property.
     * 
     * @param value
     *     allowed object is
     *     {@link PowerReadings }
     *     
     */
    public void setPowerReadings(PowerReadings value) {
        this.powerReadings = value;
    }

    /**
     * Gets the value of the clocks property.
     * 
     * @return
     *     possible object is
     *     {@link Clocks }
     *     
     */
    public Clocks getClocks() {
        return clocks;
    }

    /**
     * Sets the value of the clocks property.
     * 
     * @param value
     *     allowed object is
     *     {@link Clocks }
     *     
     */
    public void setClocks(Clocks value) {
        this.clocks = value;
    }

    /**
     * Gets the value of the applicationsClocks property.
     * 
     * @return
     *     possible object is
     *     {@link ApplicationsClocks }
     *     
     */
    public ApplicationsClocks getApplicationsClocks() {
        return applicationsClocks;
    }

    /**
     * Sets the value of the applicationsClocks property.
     * 
     * @param value
     *     allowed object is
     *     {@link ApplicationsClocks }
     *     
     */
    public void setApplicationsClocks(ApplicationsClocks value) {
        this.applicationsClocks = value;
    }

    /**
     * Gets the value of the defaultApplicationsClocks property.
     * 
     * @return
     *     possible object is
     *     {@link DefaultApplicationsClocks }
     *     
     */
    public DefaultApplicationsClocks getDefaultApplicationsClocks() {
        return defaultApplicationsClocks;
    }

    /**
     * Sets the value of the defaultApplicationsClocks property.
     * 
     * @param value
     *     allowed object is
     *     {@link DefaultApplicationsClocks }
     *     
     */
    public void setDefaultApplicationsClocks(DefaultApplicationsClocks value) {
        this.defaultApplicationsClocks = value;
    }

    /**
     * Gets the value of the maxClocks property.
     * 
     * @return
     *     possible object is
     *     {@link MaxClocks }
     *     
     */
    public MaxClocks getMaxClocks() {
        return maxClocks;
    }

    /**
     * Sets the value of the maxClocks property.
     * 
     * @param value
     *     allowed object is
     *     {@link MaxClocks }
     *     
     */
    public void setMaxClocks(MaxClocks value) {
        this.maxClocks = value;
    }

    /**
     * Gets the value of the maxCustomerBoostClocks property.
     * 
     * @return
     *     possible object is
     *     {@link MaxCustomerBoostClocks }
     *     
     */
    public MaxCustomerBoostClocks getMaxCustomerBoostClocks() {
        return maxCustomerBoostClocks;
    }

    /**
     * Sets the value of the maxCustomerBoostClocks property.
     * 
     * @param value
     *     allowed object is
     *     {@link MaxCustomerBoostClocks }
     *     
     */
    public void setMaxCustomerBoostClocks(MaxCustomerBoostClocks value) {
        this.maxCustomerBoostClocks = value;
    }

    /**
     * Gets the value of the clockPolicy property.
     * 
     * @return
     *     possible object is
     *     {@link ClockPolicy }
     *     
     */
    public ClockPolicy getClockPolicy() {
        return clockPolicy;
    }

    /**
     * Sets the value of the clockPolicy property.
     * 
     * @param value
     *     allowed object is
     *     {@link ClockPolicy }
     *     
     */
    public void setClockPolicy(ClockPolicy value) {
        this.clockPolicy = value;
    }

    /**
     * Gets the value of the supportedClocks property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSupportedClocks() {
        return supportedClocks;
    }

    /**
     * Sets the value of the supportedClocks property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSupportedClocks(String value) {
        this.supportedClocks = value;
    }

    /**
     * Gets the value of the processes property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProcesses() {
        return processes;
    }

    /**
     * Sets the value of the processes property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProcesses(String value) {
        this.processes = value;
    }

    /**
     * Gets the value of the accountedProcesses property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountedProcesses() {
        return accountedProcesses;
    }

    /**
     * Sets the value of the accountedProcesses property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountedProcesses(String value) {
        this.accountedProcesses = value;
    }

}
