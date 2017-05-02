package com.eu.controller;

import com.eu.pojo.AVNotificationListResult;
import com.eu.pojo.CMNotificationListResult;
import com.eu.pojo.NotificationResult;
import com.eu.pojo.SYSNotificationListResult;
import com.eu.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lip on 17/5/2.
 */
@Controller
@RequestMapping("/notification")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @RequestMapping("/activity")
    @ResponseBody
    public AVNotificationListResult getAllActivityNotifications(String uid){
        return notificationService.getAllActivityNotifications(uid);
    }

    @RequestMapping("/community")
    @ResponseBody
    public CMNotificationListResult getAllCommunityNotifications(String uid){
        return notificationService.getAllCommunityNotifications(uid);
    }

    @RequestMapping("/system")
    @ResponseBody
    public SYSNotificationListResult getAllSystemNotifications(){
        return notificationService.getAllSystemNotifications();
    }

    @RequestMapping("/msglite")
    @ResponseBody
    public NotificationResult getNotificationLite(String uid){
        return notificationService.getNotificationLiteResult(uid);
    }

}
