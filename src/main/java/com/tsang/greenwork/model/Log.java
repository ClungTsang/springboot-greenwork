package com.tsang.greenwork.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@AllArgsConstructor
@Data
public class Log {
    private String operater;

    public void setOperater(String operater) {
        this.operater = operater;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    private String telephone;

    private String content;

    private Date updated;

    public Log() {
        super();
    }

    public String getOperater() {
        return operater;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getContent() {
        return content;
    }

    public Date getUpdated() {
        return updated;
    }
}