package com.eu.pojo;

/**
 * Created by lip on 17/5/2.
 */
public class NotificationLite {

    private String systemNotification;

    private String activityNotification;

    private String communityNotification;

    public NotificationLite(String systemNotification, String activityNotification, String communityNotification) {
        this.systemNotification = systemNotification;
        this.activityNotification = activityNotification;
        this.communityNotification = communityNotification;
    }

    public String getSystemNotification() {
        return systemNotification;
    }

    public void setSystemNotification(String systemNotification) {
        this.systemNotification = systemNotification;
    }

    public String getActivityNotification() {
        return activityNotification;
    }

    public void setActivityNotification(String activityNotification) {
        this.activityNotification = activityNotification;
    }

    public String getCommunityNotification() {
        return communityNotification;
    }

    public void setCommunityNotification(String communityNotification) {
        this.communityNotification = communityNotification;
    }
}
