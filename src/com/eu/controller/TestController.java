package com.eu.controller;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lip on 17/3/20.
 */
@Controller
public class TestController {



    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        //随机生成验证码
        Integer randomcode = 1000+(int)(Math.random()*9000);
        return  randomcode.toString();

    }

}
