package com.tsang.greenwork.model;

public class Wsinfor {
    private String workshopid;

    private String workshopname;

    private String statuss;

    private String autoo;

    public Wsinfor(String workshopid, String workshopname, String statuss, String autoo) {
        this.workshopid = workshopid;
        this.workshopname = workshopname;
        this.statuss = statuss;
        this.autoo = autoo;
    }

    public String getWorkshopid() {
        return workshopid;
    }

    public String getWorkshopname() {
        return workshopname;
    }

    public String getStatuss() {
        return statuss;
    }

    public String getAutoo() {
        return autoo;
    }
}