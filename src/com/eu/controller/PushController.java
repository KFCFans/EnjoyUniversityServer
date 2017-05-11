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
import com.eu.mapper.ActivitynotificationMapper;
import com.eu.mapper.CommunitynotificationMapper;
import com.eu.pojo.*;
import com.eu.service.ActivityService;
import com.yunpian.sdk.model.ResultDO;
import com.yunpian.sdk.model.SendBatchSmsInfo;
import com.yunpian.sdk.service.SmsOperator;
import com.yunpian.sdk.service.YunpianRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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

    public static YunpianRestClient yunpianRestClient = new YunpianRestClient("5e7c841e5afdf3851262e1d0c644e3cb");

    @Autowired
    private CommunitynotificationMapper communitynotificationMapper;

    @Autowired
    private ActivitynotificationMapper activitynotificationMapper;

    @Autowired
    private ActivityService activityService;

    private static String masterSecret = "ed8024455aec831690cd1873";

    private static String appKey = "e950097ccf5b347c00354679";

    /**
     * 根据别名发送活动通知
     * @param alias 别名串，ID 与 ID之间逗号隔开
     * @param alert 通知内容
     * @param avid 活动 ID
     * @param avname 活动名称
     * @param sendsms 是否发送短信 0不发送 1发送
     * @return 推送结果
     */
    @RequestMapping("/activityaliaspush")
    @ResponseBody
    public RequestResult pushAvtivityNotificationByAlias(String alias,String alert,int avid,String avname,Integer sendsms){

        Collection<String> aliases = new ArrayList<>();
        String[] aliasarray = alias.split(",");
        for (String uid:aliasarray){
            aliases.add(uid);
        }
        JPushClient jPushClient = new JPushClient(masterSecret,appKey);
        // 构建推送
        Notification notification =  Notification.newBuilder().
                addPlatformNotification(IosNotification.newBuilder()
                        .setAlert(alert)
                        .incrBadge(1)
                        .build()
                )
                .addPlatformNotification(AndroidNotification.alert(alert)).build();

        PushPayload pushPayload = PushPayload.newBuilder()
                .setPlatform(Platform.android_ios())
                .setAudience(Audience.alias(aliases))
                .setNotification(notification).build();
        try {
            jPushClient.sendPush(pushPayload);
        }catch (Exception e){
            return new RequestResult(500,e.getMessage(),null);
        }
        // 是否发送短信
        if (sendsms == 1){
            sendActivitySms(alert,alias,avname);
        }

        // 将推送的消息写入数据库
        Activitynotification activitynotification = new Activitynotification();
        activitynotification.setSender(avname);
        activitynotification.setAvid(avid);
        activitynotification.setSendtime(new Date());
        activitynotification.setMsg(alert);
        for (String uid:aliases){
            activitynotification.setUid(Long.parseLong(uid));
            activitynotificationMapper.insert(activitynotification);
        }
        return new RequestResult(200,"OK",null);
    }


    /**
     * 根据别名推送社团通知
     * @param alias 别名，ID 与 ID 之间用 , 隔开
     * @param alert 推送内容
     * @param cmid 社团 ID
     * @return 推送结果
     */
    @RequestMapping("/communityaliaspush")
    @ResponseBody
    public RequestResult pushNotificationByAlias(String alias,String alert,int cmid,String cmname,Integer sendsms){

        Collection<String> aliases = new ArrayList<>();
        String[] aliasarray = alias.split(",");
        for (String uid:aliasarray){
            aliases.add(uid);
        }
        JPushClient jPushClient = new JPushClient(masterSecret,appKey);
        // 构建推送
        Notification notification =  Notification.newBuilder().
                addPlatformNotification(IosNotification.newBuilder()
                        .setAlert(alert)
                        .incrBadge(1)
                        .build()
                )
                .addPlatformNotification(AndroidNotification.alert(alert)).build();

        PushPayload pushPayload = PushPayload.newBuilder()
                .setPlatform(Platform.android_ios())
                .setAudience(Audience.alias(aliases))
                .setNotification(notification).build();
        try {
            jPushClient.sendPush(pushPayload);
        }catch (Exception e){
            return new RequestResult(500,e.getMessage(),null);
        }

        // 是否发送短信
        if (sendsms == 1){
            sendCommunitySms(alert,alias,cmname);
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

    /**
     * 发送活动接口 调用上面的 pushAvtivityNotificationByAlias，封装了数据库查询操作
     * @param alert 通知内容
     * @param avid 活动 ID
     * @param avname 活动名称
     * @return 200 500
     */
    @RequestMapping("activityPush")
    @ResponseBody
    public RequestResult pushActivityNotification(String alert,int avid,String avname,Integer sendsms){

        UserListResult userListResult = activityService.getParticipatorMemberList(avid,0);
        List<Userinfo> userinfoList = userListResult.getData();
        String alias = "";
        for (Userinfo userinfo:userinfoList){
            alias = alias + userinfo.getUid() + ",";
        }
        return pushAvtivityNotificationByAlias(alias,alert,avid,avname,sendsms);
    }

    /**
     * 发送社团通知
     * @param alert 通知内容
     * @param phonelist 手机号列表 英文逗号隔开 eg. 15061883391，15061883392
     * @param cmname 社团名称
     * @return 200 500
     */
    @RequestMapping("/communitysms")
    @ResponseBody
    public RequestResult sendCommunitySms(String alert,String phonelist,String cmname){

        String sendtext = "【EU科技】"+cmname+"通知您，"+alert+"，详情请登录EU查看。";
        return sendSmsByYunPian(phonelist,sendtext);

    }

    /**
     * 发送活动通知
     * @param alert 活动内容
     * @param phonelist 手机号列表 同上
     * @param avname 活动名称
     * @return 200 500
     */
    @RequestMapping("/activitysms")
    @ResponseBody
    public RequestResult sendActivitySms(String  alert,String phonelist,String avname){

        String sendtext = "【EU科技】您参加的活动"+avname+"提醒您，"+alert+"，详情请登录EU查看。";
        return sendSmsByYunPian(phonelist,sendtext);
    }

    public RequestResult sendSmsByYunPian(String phonelist,String sendtext){
        SmsOperator smsOperator = yunpianRestClient.getSmsOperator();//获取所需操作类
        ResultDO<SendBatchSmsInfo> result = smsOperator.batchSend(phonelist, sendtext);//batchSend还有个重载函数接受List<String>号码集合,可按需灵活使用
        if (result.isSuccess()){
            return new RequestResult(200,"OK",null);
        }else{
            return new RequestResult(500,result.getE().getMessage(),null);
        }
    }



    /*
    // 根据活动标签发送短信，已废弃
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

    // 根据社团标签发送通知，已废弃
    @RequestMapping("/communitytagpush")
    @ResponseBody
    public RequestResult pushCommunityNotificationByTag(String alert,int cmid,String cmname) {

        JPushClient jpushClient = new JPushClient(masterSecret, appKey, null, ClientConfig.getInstance());

        String pushtag = "cm" + cmid;

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
    */
}
