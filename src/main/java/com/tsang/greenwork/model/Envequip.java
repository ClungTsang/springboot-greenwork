package com.tsang.greenwork.model;

public class Envequip {
    private String workshopid;

    private String warn;

    private String warnstatus;

    private String fan;

    private String fanstatus;

    private String light;

    private String lightstatus;

    private String fee;

    public Envequip(String workshopid, String warn, String warnstatus, String fan, String fanstatus, String light, String lightstatus, String fee) {
        this.workshopid = workshopid;
        this.warn = warn;
        this.warnstatus = warnstatus;
        this.fan = fan;
        this.fanstatus = fanstatus;
        this.light = light;
        this.lightstatus = lightstatus;
        this.fee = fee;
    }

    public String getWorkshopid() {
        return workshopid;
    }

    public String getWarn() {
        return warn;
    }

    public String getWarnstatus() {
        return warnstatus;
    }

    public String getFan() {
        return fan;
    }

    public String getFanstatus() {
        return fanstatus;
    }

    public String getLight() {
        return light;
    }

    public String getLightstatus() {
        return lightstatus;
    }

    public String getFee() {
        return fee;
    }
}