package com.eu.controller;

import com.eu.pojo.RequestResult;
import com.eu.pojo.UserInfoResult;
import com.eu.pojo.UserListResult;
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
    public UserInfoResult getUserInfoWithPermission(String uid, String accesstoken){
        return userInfoService.getUserInfoWithPermission(uid, accesstoken);
    }

    @RequestMapping("/introinfo")
    @ResponseBody
    public UserInfoResult getUserInfoWithoutPerssion(String uid){
        return userInfoService.getUserInfoWithoutPermission(uid);
    }

    @RequestMapping("/userlist")
    @ResponseBody
    public UserListResult getParticipatorList(String uidlist){

        String[] uids = uidlist.split(",");
        List<Long> list = new ArrayList<>();
        for (int i = 0;i<uids.length;i++){
            list.add(Long.parseLong(uids[i]));
        }
        return userInfoService.getParticipatorList(list);
    }

    @RequestMapping("/reputation")
    @ResponseBody
    public RequestResult manageReputation(String uid,int reputation){
        return userInfoService.changeReputation(uid, reputation);
    }

    @RequestMapping("/changeinfo")
    @ResponseBody
    public RequestResult changeUserInfo(Userinfo userinfo){
        return userInfoService.changeUserInfo(userinfo);
    }

    // 此接口需要管理员权限，认证不是随便认证的
    @RequestMapping("/verify")
    @ResponseBody
    public RequestResult verifyUser(String uid){
        return userInfoService.verifyUser(uid);
    }

    @RequestMapping("/search")
    @ResponseBody
    public UserListResult searchUser(String keyword,Integer page,Integer rows){
        return userInfoService.searchUser(keyword, page, rows);
    }


}
