package com.eu.controller;

import com.eu.pojo.Community;
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

    @RequestMapping("/commomcm")
    @ResponseBody
    private List<Community> getCommomCommunities(){
        return communityService.getCommonCommunities();
    }

    @RequestMapping("/joinedcm")
    @ResponseBody
    public List<Community> getMyCommunitys(String uid){
        return communityService.getMyCommunities(uid);
    }

    @RequestMapping("/collectedcm")
    @ResponseBody
    public List<Community> getMyJoinedCommunities(String uid){
        return communityService.getMyCollectedCommunities(uid);
    }

    @RequestMapping("/phonelist")
    @ResponseBody
    public List<Long> getMemberPhoneList(int cmid){
        return communityService.getMemberPhoneList(cmid);
    }
    
}
