package com.tsang.greenwork.model;

import java.util.Date;

public class Machruntime {
    private String machineid;

    private String situation;

    private String nrgconsumption;

    private String frequency;

    private Date updated;

    private String workshopid;

    private Long time;

    public Machruntime(String machineid, Long time) {
        this.machineid = machineid;
        this.time = time;
    }

    public Machruntime(String machineid, String situation, String nrgconsumption, String frequency, String workshopid) {
        this.machineid = machineid;
        this.situation = situation;
        this.nrgconsumption = nrgconsumption;
        this.frequency = frequency;
        this.workshopid = workshopid;
    }

    public Machruntime(String machineid, String situation, String nrgconsumption, String frequency) {
        this.machineid = machineid;
        this.situation = situation;
        this.nrgconsumption = nrgconsumption;
        this.frequency = frequency;
    }

    public Machruntime(String machineid, String situation, String nrgconsumption, String frequency,String workshopid, Date updated) {
        this.machineid = machineid;
        this.situation = situation;
        this.nrgconsumption = nrgconsumption;
        this.frequency = frequency;
        this.updated = updated;
        this.workshopid = workshopid;
    }

    public String getMachineid() {
        return machineid;
    }

    public String getSituation() {
        return situation;
    }

    public String getNrgconsumption() {
        return nrgconsumption;
    }

    public String getFrequency() {
        return frequency;
    }

    public Date getUpdated() {
        return updated;
    }

    public String getWorkshopid() {
        return workshopid;
    }

    public Long getTime() {
        return time;
    }

    public void setWorkshopid(String workshopid) {
        this.workshopid = workshopid;
    }

    public void setNrgconsumption(String nrgconsumption) {
        this.nrgconsumption = nrgconsumption;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }
}