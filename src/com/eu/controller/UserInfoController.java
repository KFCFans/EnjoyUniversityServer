package com.eu.controller;

import com.eu.pojo.Userinfo;
import com.eu.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
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
    public Userinfo getUserInfoWithPermission(String uid,String accesstoken){
        return userInfoService.getUserInfoWithPermission(uid, accesstoken);
    }

    @RequestMapping("/introinfo")
    @ResponseBody
    public Userinfo getUserInfoWithoutPerssion(String uid){
        return userInfoService.getUserInfoWithoutPermission(uid);
    }

    @RequestMapping("/userlist")
    @ResponseBody
    public List<Userinfo> getParticipatorList(String uidlist){

        String[] uids = uidlist.split(",");
        List<Long> list = new ArrayList<>();
        for (int i = 0;i<uids.length;i++){
            list.add(Long.parseLong(uids[i]));
        }
        return userInfoService.getParticipatorList(list);

    }


}
