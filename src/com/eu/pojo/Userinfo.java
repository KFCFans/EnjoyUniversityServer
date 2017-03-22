package com.eu.pojo;

public class Userinfo {
    private Long uid;

    private String avatar;

    private String nickname;

    private Integer gender;

    private String professionclass;

    private Long studentid;

    private String name;

    private String description;

    private String password;

    private String accesstoken;

    private Integer reputation;

    private Integer verified;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getProfessionclass() {
        return professionclass;
    }

    public void setProfessionclass(String professionclass) {
        this.professionclass = professionclass == null ? null : professionclass.trim();
    }

    public Long getStudentid() {
        return studentid;
    }

    public void setStudentid(Long studentid) {
        this.studentid = studentid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getAccesstoken() {
        return accesstoken;
    }

    public void setAccesstoken(String accesstoken) {
        this.accesstoken = accesstoken == null ? null : accesstoken.trim();
    }

    public Integer getReputation() {
        return reputation;
    }

    public void setReputation(Integer reputation) {
        this.reputation = reputation;
    }

    public Integer getVerified() {
        return verified;
    }

    public void setVerified(Integer verified) {
        this.verified = verified;
    }

    // 判断符不符合规定
    public Boolean LegalToDataBase(){
        if (uid==null||gender==null||name==null||studentid==null||password==null){
            return false;
        }
        return true;
    }

    // 除自己以外的人访问信息需要去掉密码
    public void hidePersonalSecret(Boolean bool){

        if (!bool){
            return;
        }
        // 隐藏密码和token
        setPassword(null);
        setAccesstoken(null);

    }

}