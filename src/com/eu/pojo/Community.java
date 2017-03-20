package com.eu.pojo;

public class Community {
    private Integer cmid;

    private String cmLogo;

    private String cmDetail;

    private String cmName;

    private String cmBackground;

    private String cmType;

    private String cmAttr;

    private Integer cmRecruit;

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

    public String getCmType() {
        return cmType;
    }

    public void setCmType(String cmType) {
        this.cmType = cmType == null ? null : cmType.trim();
    }

    public String getCmAttr() {
        return cmAttr;
    }

    public void setCmAttr(String cmAttr) {
        this.cmAttr = cmAttr == null ? null : cmAttr.trim();
    }

    public Integer getCmRecruit() {
        return cmRecruit;
    }

    public void setCmRecruit(Integer cmRecruit) {
        this.cmRecruit = cmRecruit;
    }
}