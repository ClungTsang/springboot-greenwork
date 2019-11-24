package com.tsang.greenwork.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Envequip {
    private String workshopid;

    private String warn;

    private String warnstatus;

    private String fan;

    private String fanstatus;

    private String light;

    private String lightstatus;

    private String fee;

}