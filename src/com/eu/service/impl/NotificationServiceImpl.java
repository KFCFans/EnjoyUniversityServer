package com.eu.service.impl;

import com.eu.mapper.ActivitynotificationMapper;
import com.eu.mapper.CommunitynotificationMapper;
import com.eu.mapper.SystemnotificationMapper;
import com.eu.pojo.*;
import com.eu.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lip on 17/5/2.
 */
@Service
public class NotificationServiceImpl implements NotificationService{

    @Autowired
    private ActivitynotificationMapper activitynotificationMapper;

    @Autowired
    private CommunitynotificationMapper communitynotificationMapper;

    @Autowired
    private SystemnotificationMapper systemnotificationMapper;

    @Override
    public SYSNotificationListResult getAllSystemNotifications() {

        SystemnotificationExample example = new SystemnotificationExample();
        example.setOrderByClause("sendtime asc");
        List<Systemnotification> list;
        try {
            list =  systemnotificationMapper.selectByExample(example);
        }catch (Exception e){
            return new SYSNotificationListResult(500,e.getMessage(),null);
        }

        return new SYSNotificationListResult(200,"OK",list);
    }

    @Override
    public AVNotificationListResult getAllActivityNotifications(String uid) {

        ActivitynotificationExample example = new ActivitynotificationExample();
        ActivitynotificationExample.Criteria criteria = example.createCriteria();
        criteria.andUidEqualTo(Long.parseLong(uid));
        example.setOrderByClause("sendtime asc");
        List<Activitynotification> list;
        try {
            list = activitynotificationMapper.selectByExample(example);
        }catch (Exception e){
            return new AVNotificationListResult(500,e.getMessage(),null);
        }
        return new AVNotificationListResult(200,"OK",list);
    }

    @Override
    public CMNotificationListResult getAllCommunityNotifications(String uid) {
        CommunitynotificationExample example = new CommunitynotificationExample();
        CommunitynotificationExample.Criteria criteria = example.createCriteria();
        criteria.andUidEqualTo(Long.parseLong(uid));
        example.setOrderByClause("sendtime asc");
        List<Communitynotification> list;
        try {
            list = communitynotificationMapper.selectByExample(example);
        }catch (Exception e){
            return new CMNotificationListResult(500,e.getMessage(),null);
        }
        return new CMNotificationListResult(200,"OK",list);
    }

    @Override
    public NotificationResult getNotificationLiteResult(String uid) {

        NotificationLite lite;

        SystemnotificationExample systemnotificationExample = new SystemnotificationExample();
        systemnotificationExample.setOrderByClause("sendtime desc LIMIT 1");

        CommunitynotificationExample communitynotificationExample = new CommunitynotificationExample();
        communitynotificationExample.setOrderByClause("sendtime desc LIMIT 1");
        CommunitynotificationExample.Criteria communityCriteria = communitynotificationExample.createCriteria();
        communityCriteria.andUidEqualTo(Long.parseLong(uid));

        ActivitynotificationExample activitynotificationExample = new ActivitynotificationExample();
        activitynotificationExample.setOrderByClause("sendtime desc LIMIT 1");
        ActivitynotificationExample.Criteria activityCriteria = activitynotificationExample.createCriteria();
        activityCriteria.andUidEqualTo(Long.parseLong(uid));

        try {
            String systemMsg = systemnotificationMapper.selectByExample(systemnotificationExample).get(0).getMsg();
            String communityMsg = communitynotificationMapper.selectByExample(communitynotificationExample).get(0).getMsg();
            String activityMsg = activitynotificationMapper.selectByExample(activitynotificationExample).get(0).getMsg();
            lite = new NotificationLite(systemMsg,activityMsg,communityMsg);
        }catch (Exception e){
            return new NotificationResult(500,e.getMessage(),null);
        }

        return new NotificationResult(200,"OK",lite);

    }
}
