package com.tsang.greenwork.model;

public class Avgmach {
    private String year1;

    private String month1;

    private String day1;

    private String hour1;

    private String avgnrg;

    private String avgfre;

    public Avgmach(String year1, String month1, String day1, String hour1, String avgnrg, String avgfre) {
        this.year1 = year1;
        this.month1 = month1;
        this.day1 = day1;
        this.hour1 = hour1;
        this.avgnrg = avgnrg;
        this.avgfre = avgfre;
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

    public String getAvgnrg() {
        return avgnrg;
    }

    public String getAvgfre() {
        return avgfre;
    }

}