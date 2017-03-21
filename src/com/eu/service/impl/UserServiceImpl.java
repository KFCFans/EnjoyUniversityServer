package com.eu.service.impl;

import com.eu.pojo.VerificationCode;
import com.eu.service.UserService;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;
import org.springframework.stereotype.Service;

/**
 * Created by lip on 17/3/21.
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public VerificationCode verifyPhoneNumber(String phone) throws ApiException {

        //随机生成验证码
        Integer randomcode = 1000+(int)(Math.random()*9000);
        String code = randomcode.toString();

        // 发送短信
        TaobaoClient client = new DefaultTaobaoClient("https://eco.taobao.com/router/rest", "23708874", "094ea180fed761b671b3b059aac6f09f");
        AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
        req.setExtend( "" );
        req.setSmsType( "normal" );
        req.setSmsFreeSignName( "EU科技" );
        req.setSmsParamString( "{number:'"+code+"'}" );
        req.setRecNum(phone);
        req.setSmsTemplateCode( "SMS_56610387" );
        AlibabaAliqinFcSmsNumSendResponse rsp = client.execute(req);
        System.out.println(rsp.getBody());
        System.out.println(rsp.getResult().getSuccess());


       // 返回验证码数据
        VerificationCode verificationCode = new VerificationCode(code,rsp.getResult().getSuccess());

        return verificationCode;
    }
}
