package com.eu.controller;

import com.eu.pojo.Activity;
import com.eu.pojo.RequestResult;
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

    @RequestMapping("/deleteav")
    @ResponseBody
    public RequestResult deleteActivity(int avid,String uid){
        return activityService.deleteActivity(avid,uid);
    }

    @RequestMapping("/changeav")
    @ResponseBody
    public RequestResult changeActivity(Activity activity,String uid){
        return activityService.changeActivity(activity, uid);
    }

    @RequestMapping("/participateav")
    @ResponseBody
    public RequestResult paticipateActivity(int avid,String uid){
        return activityService.participateActivity(uid,avid);
    }

    @RequestMapping("/quitav")
    @ResponseBody
    public RequestResult quitActivity(String uid,int avid){
        return activityService.quitActivity(uid, avid);
    }

    //FIXME: - 由于浏览器无法传入 Date 数据，无法测试
    @RequestMapping("/createav")
    @ResponseBody
    public RequestResult createActivity(Activity activity){
        return activityService.createActivity(activity);
    }


}
