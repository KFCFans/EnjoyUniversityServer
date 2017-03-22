package com.eu.service;

import com.eu.pojo.Activity;
import com.eu.pojo.Community;
import com.eu.pojo.RequestResult;
import com.eu.pojo.Userinfo;

import java.util.List;

/**
 * Created by lip on 17/3/22.
 */
public interface ActivityService {

    public List<Activity> getCommonActivities();

    public List<Activity> getMyCreatedActivities(String uid);

    public List<Activity> getMyJoinedActivities(String uid);

    public List<Activity> getMyCollectedActivities(String  uid);

    public List<Long> getParticipatorPhoneList(int avid);

    public RequestResult deleteActivity(int avid,String uid);

    public RequestResult changeActivity(Activity activity,String uid);

    public RequestResult participateActivity(String uid,int avid);

    public RequestResult quitActivity(String uid,int avid);

    public RequestResult createActivity(Activity activity);

    public RequestResult manageParticipators(String uid,int avid,int verifystate);




}
