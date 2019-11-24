package com.tsang.greenwork.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String telephone;

    private String username;

    private String account;

    private String password;

    private String job;

    private Date hiredate;

    private String phonemac;

    private String checkin;

    private String checked;

    private String machineid;

    private String workshopid;

    public User(String telephone, String username, String account, String password, String phonemac) {
        this.telephone = telephone;
        this.username = username;
        this.account = account;
        this.password = password;
        this.phonemac = phonemac;
    }


    public User(String telephone, String checked) {
        this.telephone = telephone;
        this.checked = checked;
    }

    public User(String telephone, String machineid, String workshopid) {
        this.telephone = telephone;
        this.machineid = machineid;
        this.workshopid = workshopid;
    }

}