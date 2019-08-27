package com.tsang.greenwork.model;

public class Elefee {
    public void setRangee(String rangee) {
        this.rangee = rangee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    private String rangee;

    private Double fee;

    public Elefee(String rangee, Double fee) {
        this.rangee = rangee;
        this.fee = fee;
    }

    public String getRangee() {
        return rangee;
    }

    public Double getFee() {
        return fee;
    }
}