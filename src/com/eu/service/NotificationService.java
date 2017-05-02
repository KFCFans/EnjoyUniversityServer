package com.eu.service;

import com.eu.pojo.AVNotificationListResult;
import com.eu.pojo.CMNotificationListResult;
import com.eu.pojo.NotificationResult;
import com.eu.pojo.SYSNotificationListResult;

/**
 * Created by lip on 17/5/2.
 */
public interface NotificationService {

    public SYSNotificationListResult getAllSystemNotifications();

    public AVNotificationListResult getAllActivityNotifications(String uid);

    public CMNotificationListResult getAllCommunityNotifications(String uid);

    public NotificationResult getNotificationLiteResult(String uid);

}
