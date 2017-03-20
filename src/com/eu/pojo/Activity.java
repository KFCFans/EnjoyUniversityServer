package com.eu.pojo;

import java.util.Date;

public class Activity {
    private Integer avid;

    private String avTitle;

    private Date avStarttime;

    private Date avEndtime;

    private Float avPrice;

    private String avDetail;

    private Integer avExpectnum;

    private Long uid;

    private String avLogo;

    private Integer avState;

    private String avBackground;

    public Integer getAvid() {
        return avid;
    }

    public void setAvid(Integer avid) {
        this.avid = avid;
    }

    public String getAvTitle() {
        return avTitle;
    }

    public void setAvTitle(String avTitle) {
        this.avTitle = avTitle == null ? null : avTitle.trim();
    }

    public Date getAvStarttime() {
        return avStarttime;
    }

    public void setAvStarttime(Date avStarttime) {
        this.avStarttime = avStarttime;
    }

    public Date getAvEndtime() {
        return avEndtime;
    }

    public void setAvEndtime(Date avEndtime) {
        this.avEndtime = avEndtime;
    }

    public Float getAvPrice() {
        return avPrice;
    }

    public void setAvPrice(Float avPrice) {
        this.avPrice = avPrice;
    }

    public String getAvDetail() {
        return avDetail;
    }

    public void setAvDetail(String avDetail) {
        this.avDetail = avDetail == null ? null : avDetail.trim();
    }

    public Integer getAvExpectnum() {
        return avExpectnum;
    }

    public void setAvExpectnum(Integer avExpectnum) {
        this.avExpectnum = avExpectnum;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getAvLogo() {
        return avLogo;
    }

    public void setAvLogo(String avLogo) {
        this.avLogo = avLogo == null ? null : avLogo.trim();
    }

    public Integer getAvState() {
        return avState;
    }

    public void setAvState(Integer avState) {
        this.avState = avState;
    }

    public String getAvBackground() {
        return avBackground;
    }

    public void setAvBackground(String avBackground) {
        this.avBackground = avBackground == null ? null : avBackground.trim();
    }
}