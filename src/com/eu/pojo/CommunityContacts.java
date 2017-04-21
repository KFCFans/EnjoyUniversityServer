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

    private Long studentid;

    private String professionclass;

    public CommunityContacts(String name, String avatar, Integer position, Long uid, Integer grade, Integer gender, Long studentid, String professionclass) {
        this.name = name;
        this.avatar = avatar;
        this.position = position;
        this.uid = uid;
        this.grade = grade;
        this.gender = gender;
        this.studentid = studentid;
        this.professionclass = professionclass;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Long getStudentid() {
        return studentid;
    }

    public void setStudentid(Long studentid) {
        this.studentid = studentid;
    }

    public String getProfessionclass() {
        return professionclass;
    }

    public void setProfessionclass(String professionclass) {
        this.professionclass = professionclass;
    }
}
