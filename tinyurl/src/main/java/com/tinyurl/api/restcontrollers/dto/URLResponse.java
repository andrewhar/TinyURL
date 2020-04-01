package com.tinyurl.api.restcontrollers.dto;

import java.util.Date;

public class URLResponse {
    private int id;
    private String orgURL;
    private String tinyURL;
    private Date LocalDateTime;
    private String msg;

    private String errorMsg;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrgURL() {
        return orgURL;
    }

    public void setOrgURL(String orgURL) {
        this.orgURL = orgURL;
    }

    public String getTinyURL() {
        return tinyURL;
    }

    public void setTinyURL(String tinyURL) {
        this.tinyURL = tinyURL;
    }

    public Date getLocalDateTime() {
        return LocalDateTime;
    }

    public void setLocalDateTime(Date localDateTime) {
        LocalDateTime = localDateTime;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


}
