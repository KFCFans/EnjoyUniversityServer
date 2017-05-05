package com.eu.controller;

import cn.jiguang.common.ClientConfig;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;
import cn.jpush.api.push.model.notification.PlatformNotification;
import com.eu.mapper.ActivitynotificationMapper;
import com.eu.mapper.CommunityauthorityMapper;
import com.eu.mapper.CommunitynotificationMapper;
import com.eu.mapper.ParticipateactivityMapper;
import com.eu.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Created by lip on 17/4/28.
 */
@Controller
@RequestMapping("/push")
public class PushController {

    @Autowired
    private CommunitynotificationMapper communitynotificationMapper;

    @Autowired
    private ActivitynotificationMapper activitynotificationMapper;

    @Autowired
    private ParticipateactivityMapper participateactivityMapper;

    @Autowired
    private CommunityauthorityMapper communityauthorityMapper;

    private static String masterSecret = "507fa5d70928e7a037ab22cd";

    private static String appKey = "7dd9d0f83f93c23e2c295dc0";

    /**
     * 根据活动标签推送活动信息
     * @param alert 推送内容
     * @param avid 活动 ID
     * @return 执行结果
     */
    @RequestMapping("/activitytagpush")
    @ResponseBody
    public RequestResult pushNotificationByTag(String alert,int avid,String avname) {

        JPushClient jpushClient = new JPushClient(masterSecret, appKey, null, ClientConfig.getInstance());

        String pushtag = "av" + avid;

        // 构建推送
        Notification notification =  Notification.newBuilder().
                addPlatformNotification(IosNotification.newBuilder()
                        .setAlert(alert)
                        .incrBadge(1)
                        .build()
                )
                .addPlatformNotification(AndroidNotification.alert(alert)).build();
        // For push, all you need do is to build PushPayload object.
        PushPayload payload = PushPayload.newBuilder()
                .setPlatform(Platform.android_ios())
                .setAudience(Audience.tag(pushtag))
                .setNotification(notification).build();

        // 推送消息
        try {

            jpushClient.sendPush(payload);

        } catch (Exception e) {
            return new RequestResult(500, e.getMessage(), null);
        }

        // 将推送的消息写入数据库
        ParticipateactivityExample example = new ParticipateactivityExample();
        ParticipateactivityExample.Criteria criteria = example.createCriteria();
        criteria.andAvidEqualTo(avid);
        List<Participateactivity> participateactivityList = participateactivityMapper.selectByExample(example);
        Activitynotification activitynotification = new Activitynotification();
        activitynotification.setMsg(alert);
        activitynotification.setSendtime(new Date());
        activitynotification.setAvid(avid);
        activitynotification.setSender(avname);
        for(Participateactivity participateactivity:participateactivityList){
            activitynotification.setUid(participateactivity.getUid());
            activitynotificationMapper.insert(activitynotification);
        }

        return new RequestResult(200, "OK", null);
    }

    /**
     * 通过社团标签推送社团通知
     * @param alert 通知内容
     * @param cmid 社团 ID
     * @return 执行结果
     */
    @RequestMapping("/communitytagpush")
    @ResponseBody
    public RequestResult pushCommunityNotificationByTag(String alert,int cmid,String cmname) {

        JPushClient jpushClient = new JPushClient(masterSecret, appKey, null, ClientConfig.getInstance());

        String pushtag = "cm" + cmid;

        // For push, all you need do is to build PushPayload object.
        PushPayload payload = PushPayload.newBuilder()
                .setPlatform(Platform.android_ios())
                .setAudience(Audience.tag(pushtag))
                .setNotification(Notification.alert(alert)).build();
        // 推送消息
        try {
            jpushClient.sendPush(payload);

        } catch (Exception e) {
            return new RequestResult(500, e.getMessage(), null);
        }

        // 将推送的消息写入数据库
        CommunityauthorityExample example = new CommunityauthorityExample();
        CommunityauthorityExample.Criteria criteria = example.createCriteria();
        criteria.andCmidEqualTo(cmid);
        List<Communityauthority> communityauthorities = communityauthorityMapper.selectByExample(example);
        Communitynotification communitynotification = new Communitynotification();
        communitynotification.setMsg(alert);
        communitynotification.setSendtime(new Date());
        communitynotification.setCmid(cmid);
        communitynotification.setSender(cmname);
        for(Communityauthority communityauthority:communityauthorities){
            communitynotification.setUid(communityauthority.getUid());
            communitynotificationMapper.insert(communitynotification);
        }

        return new RequestResult(200, "OK", null);
    }


    /**
     * 根据社团别名推送社团通知
     * @param alias 别名，ID 与 ID 之间用 , 隔开
     * @param alert 推送内容
     * @param cmid 社团 ID
     * @return 推送结果
     */
    @RequestMapping("/communityaliaspush")
    @ResponseBody
    public RequestResult pushNotificationByAlias(String alias,String alert,int cmid,String cmname){

        Collection<String> aliases = new ArrayList<>();
        String[] aliasarray = alias.split(",");
        for (String uid:aliasarray){
            aliases.add(uid);
        }
        JPushClient jPushClient = new JPushClient(masterSecret,appKey);
        PushPayload pushPayload = PushPayload.newBuilder()
                .setPlatform(Platform.android_ios())
                .setAudience(Audience.alias(aliases))
                .setNotification(Notification.alert(alert)).build();
        try {
            jPushClient.sendPush(pushPayload);
        }catch (Exception e){
            return new RequestResult(500,e.getMessage(),null);
        }

        // 将推送的消息写入数据库
        Communitynotification communitynotification = new Communitynotification();
        communitynotification.setMsg(alert);
        communitynotification.setSendtime(new Date());
        communitynotification.setCmid(cmid);
        communitynotification.setSender(cmname);
        for (String uid:aliases){
            communitynotification.setUid(Long.parseLong(uid));
            communitynotificationMapper.insert(communitynotification);
        }

        return new RequestResult(200,"OK",null);

    }
}
