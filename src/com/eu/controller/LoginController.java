package com.eu.controller;

import com.eu.pojo.VerificationCode;
import com.eu.service.LoginService;
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
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping("/verifyphone/{phone}")
    @ResponseBody
    public VerificationCode verifyPhoneNumber(@PathVariable String phone) throws ApiException {

        VerificationCode verificationCode = loginService.verifyPhoneNumber(phone);
        return verificationCode;

    }

}
