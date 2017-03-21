package com.eu.controller;

import com.eu.pojo.UserResult;
import com.eu.pojo.Userinfo;
import com.eu.service.UserSecurityService;
import com.taobao.api.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lip on 17/3/21.
 */
@Controller
@RequestMapping("/user")
public class UserSecurityController {

    @Autowired
    private UserSecurityService userSecurityService;

    @RequestMapping("/verifyphone/{phone}")
    @ResponseBody
    public UserResult verifyPhoneNumber(@PathVariable String phone) throws ApiException {

        return userSecurityService.verifyPhoneNumber(phone);

    }

    @RequestMapping("/checkuid/{phone}")
    @ResponseBody
    public UserResult checkUid(@PathVariable String phone){

        return userSecurityService.checkUid(phone);
    }

    @RequestMapping("/newuser")
    @ResponseBody
    public UserResult createUser(Userinfo userinfo){

        return userSecurityService.createUser(userinfo);
    }

    @RequestMapping("/login")
    @ResponseBody
    public Userinfo login(String uid,String password){

        return userSecurityService.login(uid, password);
    }

}
