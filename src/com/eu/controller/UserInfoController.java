package com.eu.controller;

import com.eu.pojo.Activity;
import com.eu.pojo.Community;
import com.eu.pojo.Userinfo;
import com.eu.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by lip on 17/3/21.
 */
@Controller
@RequestMapping("/info")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("/userinfo")
    @ResponseBody
    public Userinfo getUserInfo(String uid){
        return userInfoService.getUserInfo(uid);
    }

    @RequestMapping("/createdav")
    @ResponseBody
    public List<Activity> getMyCreatedActivities(String uid){
        return userInfoService.getMyCreatedActivities(uid);
    }

    @RequestMapping("/joinedav")
    @ResponseBody
    public List<Activity> getMyJoinedActivities(String uid){
        return userInfoService.getMyJoinedActivities(uid);
    }

    @RequestMapping("/collectedav")
    @ResponseBody
    public List<Activity> getMyCollectedActivies(String uid){
        return userInfoService.getMyCollectedActivities(uid);
    }

    @RequestMapping("/joinedcm")
    @ResponseBody
    public List<Community> getMyCommunitys(String uid){
        return userInfoService.getMyCommunities(uid);
    }

    @RequestMapping("/collectedcm")
    @ResponseBody
    public List<Community> getMyJoinedCommunities(String uid){
        return userInfoService.getMyCollectedCommunities(uid);
    }



}
