package com.tsang.greenwork.model;

public class Avgwss {
    private String year1;

    private String month1;

    private String day1;

    private String hour1;

    private String avgtemp;

    private String avghum;

    private String avglight;

    private String avgpm1;

    private String avgpm25;

    private String avgpm10;

    public String getYear1() {
        return year1;
    }

    public void setYear1(String year1) {
        this.year1 = year1;
    }

    public String getMonth1() {
        return month1;
    }

    public void setMonth1(String month1) {
        this.month1 = month1;
    }

    public String getDay1() {
        return day1;
    }

    public void setDay1(String day1) {
        this.day1 = day1;
    }

    public String getHour1() {
        return hour1;
    }

    public void setHour1(String hour1) {
        this.hour1 = hour1;
    }

    public String getAvgtemp() {
        return avgtemp;
    }

    public void setAvgtemp(String avgtemp) {
        this.avgtemp = avgtemp;
    }

    public String getAvghum() {
        return avghum;
    }

    public void setAvghum(String avghum) {
        this.avghum = avghum;
    }

    public String getAvglight() {
        return avglight;
    }

    public void setAvglight(String avglight) {
        this.avglight = avglight;
    }

    public String getAvgpm1() {
        return avgpm1;
    }

    public void setAvgpm1(String avgpm1) {
        this.avgpm1 = avgpm1;
    }

    public String getAvgpm25() {
        return avgpm25;
    }

    public void setAvgpm25(String avgpm25) {
        this.avgpm25 = avgpm25;
    }

    public String getAvgpm10() {
        return avgpm10;
    }

    public void setAvgpm10(String avgpm10) {
        this.avgpm10 = avgpm10;
    }

    public Avgwss(String year1, String month1, String day1, String hour1, String avgtemp, String avghum, String avglight, String avgpm1, String avgpm25, String avgpm10) {
        this.year1 = year1;
        this.month1 = month1;
        this.day1 = day1;
        this.hour1 = hour1;
        this.avgtemp = avgtemp;
        this.avghum = avghum;
        this.avglight = avglight;
        this.avgpm1 = avgpm1;
        this.avgpm25 = avgpm25;
        this.avgpm10 = avgpm10;
    }
}