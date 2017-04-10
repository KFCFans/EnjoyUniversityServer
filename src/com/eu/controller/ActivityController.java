package com.eu.controller;

import com.eu.pojo.*;
import com.eu.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * Created by lip on 17/3/22.
 */
@Controller
@RequestMapping("/activity")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @RequestMapping("/commonav")
    @ResponseBody
    public ActivityListResult getCommomActivities(String mintime, String maxtime, Integer count){
        return activityService.getCommonActivities(mintime, maxtime, count);
    }

    @RequestMapping("/createdav")
    @ResponseBody
    public ActivityListResult getMyCreatedActivities(String uid){
        return activityService.getMyCreatedActivities(uid);
    }

    @RequestMapping("/joinedav")
    @ResponseBody
    public ActivityListResult getMyJoinedActivities(String uid){
        return activityService.getMyJoinedActivities(uid);
    }

    @RequestMapping("/collectedav")
    @ResponseBody
    public ActivityListResult getMyCollectedActivies(String uid){
        return activityService.getMyCollectedActivities(uid);
    }

    @RequestMapping("/phonelist")
    @ResponseBody
    public PhoneListResult getParticipatorPhoneList(int avid){
        return activityService.getParticipatorPhoneList(avid);
    }

    @RequestMapping("/memberlist")
    @ResponseBody
    public UserListResult getParticipatorMemberList(int avid){
        return activityService.getParticipatorMemberList(avid);
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
    public RequestResult createActivity(Activity activity,String avendtime,String avstarttime,String avenrolldeadline){
        activity.setAvEndtime(new Date((Long.parseLong(avendtime))));
        activity.setAvEnrolldeadline(new Date(Long.parseLong(avenrolldeadline)));
        activity.setAvStarttime(new Date(Long.parseLong(avstarttime)));
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
    public ActivityListResult searchActivities(String keyword, Integer page, Integer rows){


        return activityService.searchActivities(keyword,page,rows);
    }

    @RequestMapping("/closeav")
    @ResponseBody
    public RequestResult closeActivity(int avid){
        return activityService.closeFinishedActivity(avid);
    }

    /**
     * 此接口不由 App 执行，服务器定时执行此接口，关闭到期的活动
     * @return 由于服务器执行，没有返回值
     */
    @RequestMapping("/autocloseav")
    @ResponseBody
    public RequestResult autoCloseActicities(){
        return activityService.autoCloseFinishedActivities();
    }


}
