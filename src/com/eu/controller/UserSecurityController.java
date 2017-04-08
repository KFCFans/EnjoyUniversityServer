package com.eu.controller;

import com.eu.pojo.RequestResult;
import com.eu.pojo.Userinfo;
import com.eu.service.UserSecurityService;
import com.taobao.api.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @RequestMapping("/verifyphone")
    @ResponseBody
    public RequestResult verifyPhoneNumber(String phone, Integer choice) throws ApiException {

        return userSecurityService.verifyPhoneNumber(phone,choice);

    }


    @RequestMapping("/newuser")
    @ResponseBody
    public RequestResult createUser(Userinfo userinfo){

        return userSecurityService.createUser(userinfo);
    }

    @RequestMapping("/login")
    @ResponseBody
    public RequestResult login(String uid,String password){

        return userSecurityService.login(uid, password);
    }

    @RequestMapping("/changepwdbyphone")
    @ResponseBody
    public RequestResult updatePasswordByVerifyPhone(String uid, String newpwd){
        return userSecurityService.updatePasswordByVerifyPhone(uid,newpwd);
    }

    @RequestMapping("/changepwd")
    @ResponseBody
    public RequestResult updatePasswordByOldPwd(String uid, String oldpwd, String newpwd){
        return userSecurityService.updatePasswordByOldPassword(uid, oldpwd, newpwd);
    }

}
