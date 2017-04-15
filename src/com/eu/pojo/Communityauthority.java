package com.eu.pojo;

public class Communityauthority extends CommunityauthorityKey {
    private Integer position;

    private String reason;

    private String cmname;

    private Integer lastselect;

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

    public String getCmname() {
        return cmname;
    }

    public void setCmname(String cmname) {
        this.cmname = cmname == null ? null : cmname.trim();
    }

    public Integer getLastselect() {
        return lastselect;
    }

    public void setLastselect(Integer lastselect) {
        this.lastselect = lastselect;
    }
}