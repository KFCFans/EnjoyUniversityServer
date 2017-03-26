package com.eu.controller;

import com.eu.pojo.Activity;
import com.eu.pojo.RequestResult;
import com.eu.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public List<Activity> getCommomActivities(int page,int rows){
        return activityService.getCommonActivities(page, rows);
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

    @RequestMapping("/manage")
    @ResponseBody
    public RequestResult manageParticipators(String uid,int avid,int verifystate,String reason){
        return activityService.manageParticipators(uid, avid, verifystate,reason);
    }

    @RequestMapping("/startregister")
    @ResponseBody
    public RequestResult startActivityRegister(String uid,int avid){
        return activityService.startRegister(uid, avid);
    }

    @RequestMapping("getregister")
    @ResponseBody
    public RequestResult getRegisterInfo(int avid){
        return activityService.getRegisterInfo(avid);
    }

    @RequestMapping("/participateregister")
    @ResponseBody
    public RequestResult participateRegister(String uid,int avid){
        return activityService.participateRegister(uid,avid);
    }

    @RequestMapping("/collectav")
    @ResponseBody
    public RequestResult collectActivity(String uid,int avid){
        return activityService.collectActivity(uid, avid);
    }

    @RequestMapping("discollectav")
    @ResponseBody
    public RequestResult disCollectActivity(String uid,int avid){
        return activityService.disCollectActivity(uid, avid);
    }

    @RequestMapping("/search")
    @ResponseBody
    public List<Activity> searchActivities(String keyword, Integer page, Integer rows){

        //FIXME: 需要解决 int 不能接受空

        return activityService.searchActivities(keyword,page,rows);
    }


}
