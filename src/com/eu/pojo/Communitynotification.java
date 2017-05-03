package com.eu.pojo;

import java.util.Date;

public class Communitynotification extends CommunitynotificationKey {
    private String msg;

    private Date sendtime;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg == null ? null : msg.trim();
    }

    public Date getSendtime() {
        return sendtime;
    }

    public void setSendtime(Date sendtime) {
        this.sendtime = sendtime;
    }
}