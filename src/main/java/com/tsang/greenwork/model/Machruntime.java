package com.tsang.greenwork.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
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

}