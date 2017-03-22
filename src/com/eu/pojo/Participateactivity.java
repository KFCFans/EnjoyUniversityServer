package com.eu.pojo;

public class Participateactivity extends ParticipateactivityKey {
    private Integer verifystate;

    private String reason;

    public Integer getVerifystate() {
        return verifystate;
    }

    public void setVerifystate(Integer verifystate) {
        this.verifystate = verifystate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }
}