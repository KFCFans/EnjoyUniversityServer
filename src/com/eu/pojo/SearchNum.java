package com.eu.pojo;

/**
 * Created by lip on 17/4/24.
 */
public class SearchNum {

    public Integer activityNum;

    public Integer communityNum;

    public Integer userNum;

    public Integer getActivityNum() {
        return activityNum;
    }

    public void setActivityNum(Integer activityNum) {
        this.activityNum = activityNum;
    }

    public Integer getCommunityNum() {
        return communityNum;
    }

    public void setCommunityNum(Integer communityNum) {
        this.communityNum = communityNum;
    }

    public Integer getUserNum() {
        return userNum;
    }

    public void setUserNum(Integer userNum) {
        this.userNum = userNum;
    }

    public SearchNum(Integer activityNum, Integer communityNum, Integer userNum) {

        this.activityNum = activityNum;
        this.communityNum = communityNum;
        this.userNum = userNum;
    }
}
