package com.tsang.greenwork.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

public class Machinfor {
    private String machineid;

    private String machinemodel;

    private String leader;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date buyingtime;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date productivetime;

    private String workshopid;

    private BigDecimal latitude;

    private BigDecimal longitude;

    public Machinfor(String machineid, String machinemodel, String leader, Date buyingtime, Date productivetime, String workshopid, BigDecimal latitude, BigDecimal longitude) {
        this.machineid = machineid;
        this.machinemodel = machinemodel;
        this.leader = leader;
        this.buyingtime = buyingtime;
        this.productivetime = productivetime;
        this.workshopid = workshopid;
        this.latitude = latitude;
        this.longitude = longitude;
    }
    public Machinfor(String machineid, String leader, String workshopid) {
        this.machineid = machineid;
        this.leader = leader;
        this.workshopid = workshopid;
    }

    public Machinfor(String machineid, String machinemodel, Date buyingtime, Date productivetime, String workshopid, BigDecimal latitude, BigDecimal longitude) {
        this.machineid = machineid;
        this.machinemodel = machinemodel;
        this.buyingtime = buyingtime;
        this.productivetime = productivetime;
        this.workshopid = workshopid;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Machinfor(String machineid, String machinemodel, String leader, Date buyingtime, Date productivetime, String workshopid) {
        this.machineid = machineid;
        this.machinemodel = machinemodel;
        this.leader = leader;
        this.buyingtime = buyingtime;
        this.productivetime = productivetime;
        this.workshopid = workshopid;
    }

    public Machinfor(String machineid, String leader) {
        this.machineid = machineid;
        this.leader = leader;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public Machinfor() {
        super();
    }

    public String getMachineid() {
        return machineid;
    }

    public String getMachinemodel() {
        return machinemodel;
    }

    public String getLeader() {
        return leader;
    }

    public Date getBuyingtime() {
        return buyingtime;
    }

    public Date getProductivetime() {
        return productivetime;
    }

    public String getWorkshopid() {
        return workshopid;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setMachineid(String machineid) {
        this.machineid = machineid;
    }

    public void setMachinemodel(String machinemodel) {
        this.machinemodel = machinemodel;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public void setBuyingtime(Date buyingtime) {
        this.buyingtime = buyingtime;
    }

    public void setProductivetime(Date productivetime) {
        this.productivetime = productivetime;
    }

    public void setWorkshopid(String workshopid) {
        this.workshopid = workshopid;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }
}