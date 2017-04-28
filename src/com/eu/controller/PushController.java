package com.eu.controller;

import cn.jiguang.common.ClientConfig;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.Notification;
import com.eu.pojo.RequestResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by lip on 17/4/28.
 */
@Controller
@RequestMapping("/push")
public class PushController {

    private static String masterSecret = "507fa5d70928e7a037ab22cd";

    private static String appKey = "7dd9d0f83f93c23e2c295dc0";

    @RequestMapping("/tagpush")
    @ResponseBody
    public RequestResult pushNotificationByTag(String pushtag, String alert) {

        JPushClient jpushClient = new JPushClient(masterSecret, appKey, null, ClientConfig.getInstance());

        // For push, all you need do is to build PushPayload object.
        PushPayload payload = PushPayload.newBuilder()
                .setPlatform(Platform.android_ios())
                .setAudience(Audience.tag(pushtag))
                .setNotification(Notification.alert(alert)).build();

        try {
            PushResult result = jpushClient.sendPush(payload);
            return new RequestResult(200, "OK", result.toString());
        } catch (Exception e) {
            return new RequestResult(500, e.getMessage(), null);
        }
    }

    @RequestMapping("/aliaspush")
    @ResponseBody
    public RequestResult pushNotificationByAlias(String alias,String alert){

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
            return new RequestResult(200,"OK",null);
        }catch (Exception e){
            return new RequestResult(500,e.getMessage(),null);
        }

    }
}
