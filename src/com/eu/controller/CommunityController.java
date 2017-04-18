package com.eu.controller;

import com.eu.pojo.*;
import com.eu.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by lip on 17/3/22.
 */
@Controller
@RequestMapping("/community")
public class CommunityController {

    @Autowired
    private CommunityService communityService;

    @RequestMapping("/commoncm")
    @ResponseBody
    public CommunityListResult getCommomCommunities(Integer page, Integer rows){
        return communityService.getCommonCommunities(page, rows);
    }

    @RequestMapping("/mycommunitylist")
    @ResponseBody
    public CommunityNameListResult getMyCommunitys(String uid){
        return communityService.getMyCommunities(uid);
    }

    @RequestMapping("/collectedcm")
    @ResponseBody
    public CommunityListResult getMyJoinedCommunities(String uid){
        return communityService.getMyCollectedCommunities(uid);
    }

    @RequestMapping("/memberlist")
    @ResponseBody
    public CommunityMemberListResult getMemberPhoneList(int cmid){
        return communityService.getMemberPhoneList(cmid);
    }

    @RequestMapping("/memberinfolist")
    @ResponseBody
    public UserListResult getCommunityMemberList(int cmid){
        return communityService.getCommunityMemberList(cmid);
    }

    @RequestMapping("participatecm")
    @ResponseBody
    public RequestResult participateCommunity(String uid,String reason,int cmid,String cmname){
        return communityService.participateCommunity(uid, cmid, reason,cmname);
    }

    @RequestMapping("/leavecm")
    @ResponseBody
    public RequestResult leaveCommunity(String uid,int cmid){
        return communityService.leaveCommunity(uid, cmid);
    }

    @RequestMapping("/managecm")
    @ResponseBody
    public RequestResult manageCommunity(String uid,int cmid,int position){
        return communityService.manageCommunity(uid, cmid, position);
    }

    @RequestMapping("/recruitstate")
    @ResponseBody
    public RequestResult getActivityState(int cmid){
        return communityService.getCommunityState(cmid);
    }

    @RequestMapping("/changerecruit")
    @ResponseBody
    public RequestResult changeActivityState(int cmid,int recruit){
        return communityService.changeCommunityState(cmid, recruit);
    }

    @RequestMapping("/changecm")
    @ResponseBody
    public RequestResult changeCommunity(Community community){
        return communityService.changeCommunityInfo(community);
    }

    @RequestMapping("/collectcm")
    @ResponseBody
    public RequestResult collectCommunity(String uid,int cmid){
        return communityService.collectCommunity(uid, cmid);
    }

    @RequestMapping("/discollectcm")
    @ResponseBody
    public RequestResult disCollectCommunity(String uid,int cmid){
        return communityService.disCollectCommunity(uid, cmid);
    }

    @RequestMapping("/search")
    @ResponseBody
    public CommunityListResult searchCommunity(String keyword,Integer page,Integer rows){
        return communityService.searchCommunity(keyword,page,rows);
    }

    @RequestMapping("/getcommunity")
    @ResponseBody
    public CommunityResult getCommunityByID(int cmid){
        return communityService.getCommunityInfoByID(cmid);
    }

    @RequestMapping("/setdefaultcm")
    @ResponseBody
    public RequestResult setDefaultCommunity(int cmid,String uid,int num){
        return communityService.setDefaultCommunity(uid, cmid, num);
    }
}
