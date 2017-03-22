package com.eu.service.impl;

import com.eu.mapper.ActivityMapper;
import com.eu.mapper.ActivitycollectionMapper;
import com.eu.mapper.ParticipateactivityMapper;
import com.eu.pojo.*;
import com.eu.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lip on 17/3/22.
 */
@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityMapper activityMapper;

    @Autowired
    private ActivitycollectionMapper activitycollectionMapper;

    @Autowired
    private ParticipateactivityMapper participateactivityMapper;

    @Override
    public List<Activity> getCommonActivities() {

        return activityMapper.selectByExample(new ActivityExample());
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


    /// 查询一组 id 对应的活动
    private List<Activity> selectActivities(List<Integer> avidlist){
        ActivityExample example = new ActivityExample();
        ActivityExample.Criteria criteria = example.createCriteria();
        criteria.andAvidIn(avidlist);
        return activityMapper.selectByExample(example);
    }
}
