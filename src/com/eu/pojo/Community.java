package com.eu.pojo;

public class Community {
    private Integer cmid;

    private String cmLogo;

    private String cmDetail;

    private String cmName;

    private String cmBackground;

    private Integer cmType;

    private Integer cmAttr;

    private Integer cmRecruit;

    private Integer cmHeat;

    private String cmAnnouncement;

    public Integer getCmid() {
        return cmid;
    }

    public void setCmid(Integer cmid) {
        this.cmid = cmid;
    }

    public String getCmLogo() {
        return cmLogo;
    }

    public void setCmLogo(String cmLogo) {
        this.cmLogo = cmLogo == null ? null : cmLogo.trim();
    }

    public String getCmDetail() {
        return cmDetail;
    }

    public void setCmDetail(String cmDetail) {
        this.cmDetail = cmDetail == null ? null : cmDetail.trim();
    }

    public String getCmName() {
        return cmName;
    }

    public void setCmName(String cmName) {
        this.cmName = cmName == null ? null : cmName.trim();
    }

    public String getCmBackground() {
        return cmBackground;
    }

    public void setCmBackground(String cmBackground) {
        this.cmBackground = cmBackground == null ? null : cmBackground.trim();
    }

    public Integer getCmType() {
        return cmType;
    }

    public void setCmType(Integer cmType) {
        this.cmType = cmType;
    }

    public Integer getCmAttr() {
        return cmAttr;
    }

    public void setCmAttr(Integer cmAttr) {
        this.cmAttr = cmAttr;
    }

    public Integer getCmRecruit() {
        return cmRecruit;
    }

    public void setCmRecruit(Integer cmRecruit) {
        this.cmRecruit = cmRecruit;
    }

    public Integer getCmHeat() {
        return cmHeat;
    }

    public void setCmHeat(Integer cmHeat) {
        this.cmHeat = cmHeat;
    }

    public String getCmAnnouncement() {
        return cmAnnouncement;
    }

    public void setCmAnnouncement(String cmAnnouncement) {
        this.cmAnnouncement = cmAnnouncement == null ? null : cmAnnouncement.trim();
    }
}