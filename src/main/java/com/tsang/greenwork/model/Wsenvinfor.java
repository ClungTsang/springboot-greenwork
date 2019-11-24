package com.tsang.greenwork.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class Wsenvinfor {
    private String workshopid;

    private String temperature;

    private String humidity;

    private String light;

    private String pm1;

    private String pm25;

    private String pm10;

    private String ele;

    private String signall;

    private String fre;

    private String nrg;

    private Date updated;

    private Long time;


    public Wsenvinfor(String workshopid, Long time) {
        this.workshopid = workshopid;
        this.time = time;
    }

    public Wsenvinfor(String workshopid, String temperature, String humidity, String light, String pm1, String pm25, String pm10, String ele, String signall, String fre, String nrg, Date updated) {
        this.workshopid = workshopid;
        this.temperature = temperature;
        this.humidity = humidity;
        this.light = light;
        this.pm1 = pm1;
        this.pm25 = pm25;
        this.pm10 = pm10;
        this.ele = ele;
        this.signall = signall;
        this.fre = fre;
        this.nrg = nrg;
        this.updated = updated;
    }

    public Wsenvinfor(String workshopid,  String temperature, String humidity,String light,String pm1, String pm25, String pm10,String ele, String signall) {
        this.workshopid = workshopid;
        this.temperature = temperature;
        this.humidity = humidity;
        this.light = light;
        this.pm1 = pm1;
        this.pm25 = pm25;
        this.pm10 = pm10;
        this.ele = ele;
        this.signall = signall;
    }

    public Wsenvinfor(String workshopid,String temperature, String humidity, String light, String pm1, String pm25, String pm10) {
        this.workshopid = workshopid;
        this.temperature = temperature;
        this.humidity = humidity;
        this.light = light;
        this.pm1 = pm1;
        this.pm25 = pm25;
        this.pm10 = pm10;
    }
}