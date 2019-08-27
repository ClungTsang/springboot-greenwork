package com.tsang.greenwork.model;

import java.util.Date;

public class Wsenvinfor {
    private String workshopid;

    private String pm;

    private String temperature;

    private String humidity;

    private String ele;

    private String signall;

    private String fre;

    private String nrg;

    private Date updated;

    private Long time;

    public Long getTime() {
        return time;
    }

    public Wsenvinfor(String workshopid, Long time) {
        this.workshopid = workshopid;
        this.time = time;
    }

    public Wsenvinfor(String workshopid, String pm, String temperature, String humidity, String ele, String signall, String fre, String nrg, Date updated) {
        this.workshopid = workshopid;
        this.pm = pm;
        this.temperature = temperature;
        this.humidity = humidity;
        this.ele = ele;
        this.signall = signall;
        this.fre = fre;
        this.nrg = nrg;
        this.updated = updated;
    }

    public Wsenvinfor(String workshopid, String pm, String temperature, String humidity, String ele, String signall) {
        this.workshopid = workshopid;
        this.pm = pm;
        this.temperature = temperature;
        this.humidity = humidity;
        this.ele = ele;
        this.signall = signall;
    }

    public Wsenvinfor() {
        super();
    }

    public String getWorkshopid() {
        return workshopid;
    }

    public String getPm() {
        return pm;
    }

    public String getTemperature() {
        return temperature;
    }

    public String getHumidity() {
        return humidity;
    }

    public String getEle() {
        return ele;
    }

    public String getSignall() {
        return signall;
    }

    public String getFre() {
        return fre;
    }

    public String getNrg() {
        return nrg;
    }

    public void setPm(String pm) {
        this.pm = pm;
    }

    public Date getUpdated() {
        return updated;
    }
}