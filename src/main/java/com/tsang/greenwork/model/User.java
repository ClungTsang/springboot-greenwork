package com.tsang.greenwork.model;

import java.util.Date;

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

    public User(String telephone, String username, String account, String password, String job, Date hiredate, String phonemac, String checkin, String checked, String machineid, String workshopid) {
        this.telephone = telephone;
        this.username = username;
        this.account = account;
        this.password = password;
        this.job = job;
        this.hiredate = hiredate;
        this.phonemac = phonemac;
        this.checkin = checkin;
        this.checked = checked;
        this.machineid = machineid;
        this.workshopid = workshopid;
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

    public String getTelephone() {
        return telephone;
    }

    public String getUsername() {
        return username;
    }

    public String getAccount() {
        return account;
    }

    public String getPassword() {
        return password;
    }

    public String getJob() {
        return job;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public String getPhonemac() {
        return phonemac;
    }

    public String getCheckin() {
        return checkin;
    }

    public String getChecked() {
        return checked;
    }

    public String getMachineid() {
        return machineid;
    }

    public String getWorkshopid() {
        return workshopid;
    }

    public User() {
        super();
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public void setPhonemac(String phonemac) {
        this.phonemac = phonemac;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public void setChecked(String checked) {
        this.checked = checked;
    }

    public void setMachineid(String machineid) {
        this.machineid = machineid;
    }

    public void setWorkshopid(String workshopid) {
        this.workshopid = workshopid;
    }
}