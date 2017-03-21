package com.eu.controller;

import com.eu.pojo.UserResult;
import com.eu.pojo.Userinfo;
import com.eu.service.UserService;
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
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/verifyphone/{phone}")
    @ResponseBody
    public UserResult verifyPhoneNumber(@PathVariable String phone) throws ApiException {

        return userService.verifyPhoneNumber(phone);

    }

    @RequestMapping("/checkphone/{phone}")
    @ResponseBody
    public UserResult checkPhoneNumber(@PathVariable String phone){

        return userService.checkPhoneNumber(phone);
    }

    @RequestMapping("/newuser")
    @ResponseBody
    public UserResult createUser(Userinfo userinfo){

        return userService.createUser(userinfo);
    }

    @RequestMapping("/login")
    @ResponseBody
    public UserResult login(String uid,String password){

        return userService.login(uid, password);
    }

}
