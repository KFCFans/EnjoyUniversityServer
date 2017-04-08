package com.eu.service;

import com.eu.pojo.*;

import java.util.List;

/**
 * Created by lip on 17/3/22.
 */
public interface ActivityService {


    /**
     * 返回最新的活动
     * @param mintime 最小的活动时间，若指定此参数，则返回比 mintime 还要小的活动（用于下拉刷新），默认空
     * @param maxtime 最大的活动时间，若指定此参数，则返回比 maxtime 还要大的活动（用于上拉加载），默认空
     * @param count 返回的数据条数，默认10条
     * @return 活动列表数组，Json 格式返回
     */
    public ActivityListResult getCommonActivities(String mintime, String maxtime, Integer count);

    public ActivityListResult getMyCreatedActivities(String uid);

    public ActivityListResult getMyJoinedActivities(String uid);

    public ActivityListResult getMyCollectedActivities(String  uid);

    public PhoneListResult getParticipatorPhoneList(int avid);

    public RequestResult deleteActivity(int avid,String uid);

    public RequestResult changeActivity(Activity activity,String uid);

    public RequestResult participateActivity(String uid,int avid);

    public RequestResult quitActivity(String uid,int avid);

    public RequestResult createActivity(Activity activity);

    public RequestResult collectActivity(String uid,int avid);

    public RequestResult disCollectActivity(String uid,int avid);

    public RequestResult manageParticipators(String uid,int avid,int verifystate,String reason);

    public RequestResult startRegister(String uid,int avid);

    public RequestResult getRegisterInfo(int avid);

    public RequestResult participateRegister(String uid,int avid);

    // 搜索活动
    public ActivityListResult searchActivities(String keywor,Integer page,Integer rows);

    // 结束活动
    public RequestResult closeFinishedActivity(int avid);

    // 非 APP 调用接口，服务器每隔一段时间调用一次。用于判断过期
    public RequestResult autoCloseFinishedActivities();






}
