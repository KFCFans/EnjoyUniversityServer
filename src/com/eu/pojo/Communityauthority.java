package com.eu.pojo;

public class Communityauthority extends CommunityauthorityKey {
    private Integer position;

    private String reason;

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }
}