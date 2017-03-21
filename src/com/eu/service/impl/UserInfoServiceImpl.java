package com.eu.service.impl;

import com.eu.mapper.*;
import com.eu.pojo.*;
import com.eu.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lip on 17/3/21.
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserinfoMapper userinfoMapper;

    @Autowired
    private ActivityMapper activityMapper;

    @Autowired
    private CommunityMapper communityMapper;

    @Autowired
    private ParticipateactivityMapper participateactivityMapper;

    @Autowired
    private ActivitycollectionMapper activitycollectionMapper;

    @Autowired
    private CommunityauthorityMapper communityauthorityMapper;

    @Autowired
    private CommunitycollectionMapper communitycollectionMapper;


    @Override
    public Userinfo getUserInfo(String uid) {

        Userinfo userinfo;
        try {
            userinfo = userinfoMapper.selectByPrimaryKey(Long.parseLong(uid));
        }catch (Exception e){
            return new Userinfo();
        }
        return userinfo;
    }

    @Override
    public List<Activity> getMyCreatedActivities(String uid) {

        ActivityExample example = new ActivityExample();
        ActivityExample.Criteria criteria = example.createCriteria();
        criteria.andUidEqualTo(Long.parseLong(uid));

        return activityMapper.selectByExample(example);
    }

    @Override
    public List<Activity> getMyJoinedActivities(String uid) {
        ParticipateactivityExample example = new ParticipateactivityExample();
        ParticipateactivityExample.Criteria criteria = example.createCriteria();
        criteria.andUidEqualTo(Long.parseLong(uid));
        List<Participateactivity> list= participateactivityMapper.selectByExample(example);
        List<Integer> avidlist = new ArrayList<>();
        for (Participateactivity pav:list){
            avidlist.add(pav.getAvid());
        }
        return selectActivities(avidlist);
    }

    @Override
    public List<Activity> getMyCollectedActivities(String uid) {

        ActivitycollectionExample activitycollectionExample = new ActivitycollectionExample();
        ActivitycollectionExample.Criteria criteria = activitycollectionExample.createCriteria();
        criteria.andUidEqualTo(Long.parseLong(uid));
        List<ActivitycollectionKey> activitycollectionKeys = activitycollectionMapper.selectByExample(activitycollectionExample);
        List<Integer> avidlist = new ArrayList<>();
        for (ActivitycollectionKey activitycollectionKey:activitycollectionKeys){
            avidlist.add(activitycollectionKey.getAvid());
        }

        return selectActivities(avidlist);
    }

    @Override
    public List<Community> getMyCommunities(String uid) {

        CommunityauthorityExample example = new CommunityauthorityExample();
        CommunityauthorityExample.Criteria  criteria= example.createCriteria();
        criteria.andUidEqualTo(Long.parseLong(uid));
        List<Communityauthority> communityauthorityList = communityauthorityMapper.selectByExample(example);
        List<Integer> cmidList = new ArrayList<>();
        for (Communityauthority communityauthority:communityauthorityList){
            cmidList.add(communityauthority.getCmid());
        }

        return selectCommunities(cmidList);
    }

    @Override
    public List<Community> getMyCollectedCommunities(String uid) {

        CommunitycollectionExample example = new CommunitycollectionExample();
        CommunitycollectionExample.Criteria criteria =example.createCriteria();
        criteria.andUidEqualTo(Long.parseLong(uid));
        List<CommunitycollectionKey> communitycollectionKeys = communitycollectionMapper.selectByExample(example);
        List<Integer> cmidList = new ArrayList<>();
        for (CommunitycollectionKey communitycollectionKey:communitycollectionKeys){
            cmidList.add(communitycollectionKey.getCmid());
        }
        return selectCommunities(cmidList);
    }

    /// 查询一组 id 对应的活动
    private List<Activity> selectActivities(List<Integer> avidlist){
        ActivityExample example = new ActivityExample();
        ActivityExample.Criteria criteria = example.createCriteria();
        criteria.andAvidIn(avidlist);
        return activityMapper.selectByExample(example);
    }

    /// 查询一组 id 对应的社团
    private List<Community> selectCommunities(List<Integer> cmidlist){
        CommunityExample example = new CommunityExample();
        CommunityExample.Criteria criteria = example.createCriteria();
        criteria.andCmidIn(cmidlist);
        return communityMapper.selectByExample(example);
    }


}
