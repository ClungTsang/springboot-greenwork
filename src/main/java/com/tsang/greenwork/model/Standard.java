package com.tsang.greenwork.model;

public class Standard {
    private String name;

    private String low;

    private String hight;

    public Standard() {
        super();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public void setHight(String hight) {
        this.hight = hight;
    }

    public Standard(String name, String low, String hight) {
        this.name = name;
        this.low = low;
        this.hight = hight;
    }

    public String getName() {
        return name;
    }

    public String getLow() {
        return low;
    }

    public String getHight() {
        return hight;
    }
}