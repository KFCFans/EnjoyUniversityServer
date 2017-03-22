package com.eu.controller;

import com.eu.pojo.Userinfo;
import com.eu.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


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


}
