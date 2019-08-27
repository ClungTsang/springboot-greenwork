package com.tsang.greenwork.model;

public class Avgws {
    private String year1;

    private String month1;

    private String day1;

    private String hour1;

    private String avgpm;

    private String avgtemp;

    private String avghum;


    public Avgws(String year1, String month1, String day1, String hour1, String avgpm, String avgtemp, String avghum) {
        this.year1 = year1;
        this.month1 = month1;
        this.day1 = day1;
        this.hour1 = hour1;
        this.avgpm = avgpm;
        this.avgtemp = avgtemp;
        this.avghum = avghum;
    }

    public String getYear1() {
        return year1;
    }

    public String getMonth1() {
        return month1;
    }

    public String getDay1() {
        return day1;
    }

    public String getHour1() {
        return hour1;
    }

    public String getAvgpm() {
        return avgpm;
    }

    public void setYear1(String year1) {
        this.year1 = year1;
    }

    public void setMonth1(String month1) {
        this.month1 = month1;
    }

    public void setDay1(String day1) {
        this.day1 = day1;
    }

    public void setHour1(String hour1) {
        this.hour1 = hour1;
    }

    public void setAvgpm(String avgpm) {
        this.avgpm = avgpm;
    }

    public void setAvgtemp(String avgtemp) {
        this.avgtemp = avgtemp;
    }

    public void setAvghum(String avghum) {
        this.avghum = avghum;
    }

    public String getAvgtemp() {
        return avgtemp;
    }

    public String getAvghum() {
        return avghum;
    }
}