package com.eu.service;

import com.eu.pojo.Activity;
import com.eu.pojo.Community;
import com.eu.pojo.Userinfo;

import java.util.List;

/**
 * Created by lip on 17/3/21.
 */
public interface UserInfoService {

    public Userinfo getUserInfo(String uid);

    public List<Activity> getMyCreatedActivities(String uid);

    public List<Activity> getMyJoinedActivities(String uid);

    public List<Activity> getMyCollectedActivities(String  uid);

    public List<Community> getMyCommunities(String uid);

    public List<Community> getMyCollectedCommunities(String uid);


}
