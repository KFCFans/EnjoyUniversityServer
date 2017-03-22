package com.eu.controller;

import com.eu.pojo.Activity;
import com.eu.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by lip on 17/3/22.
 */
@Controller
@RequestMapping("/activity")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @RequestMapping("/commomav")
    @ResponseBody
    public List<Activity> getCommomActivities(){
        return activityService.getCommonActivities();
    }

    @RequestMapping("/createdav")
    @ResponseBody
    public List<Activity> getMyCreatedActivities(String uid){
        return activityService.getMyCreatedActivities(uid);
    }

    @RequestMapping("/joinedav")
    @ResponseBody
    public List<Activity> getMyJoinedActivities(String uid){
        return activityService.getMyJoinedActivities(uid);
    }

    @RequestMapping("/collectedav")
    @ResponseBody
    public List<Activity> getMyCollectedActivies(String uid){
        return activityService.getMyCollectedActivities(uid);
    }

    @RequestMapping("/phonelist")
    @ResponseBody
    public List<Long> getParticipatorPhoneList(int avid){
        return activityService.getParticipatorPhoneList(avid);
    }

}
