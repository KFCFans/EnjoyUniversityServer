package com.eu.pojo;

/**
 * Created by lip on 17/4/19.
 */
public class CommunityContacts {

    private String name;

    private String avatar;

    private Integer position;

    private Long uid;

    private Integer grade;

    private Integer gender;

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
        this.avatar = avatar;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public CommunityContacts(String name, String avatar, Integer position, Long uid, Integer grade, Integer gender) {
        this.name = name;
        this.avatar = avatar;
        this.position = position;
        this.uid = uid;
        this.grade = grade;
        this.gender = gender;
    }
}
