package com.eu.service.impl;

import com.eu.mapper.UserinfoMapper;
import com.eu.pojo.UserResult;
import com.eu.pojo.Userinfo;
import com.eu.service.UserSecurityService;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.UUID;

@Service
public class UserSecurityServiceImpl implements UserSecurityService {

    @Autowired
    private UserinfoMapper userinfoMapper;

    @Override
    public UserResult verifyPhoneNumber(String phone) {

        Integer status = 200;
        String msg = "OK";

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
        AlibabaAliqinFcSmsNumSendResponse rsp = null;
        try {
            rsp = client.execute(req);
        } catch (ApiException e) {
            status = 500;
            msg = e.getErrMsg();
        }

        System.out.println(rsp.getResult().getSuccess());


       // 返回验证码数据
        return new UserResult(status,msg,code);
    }

    @Override
    public UserResult checkUid(String phone) {


        String data = "false";
        long uid = Long.parseLong(phone);

        Userinfo userinfo = userinfoMapper.selectByPrimaryKey(uid);
        if (userinfo==null){
            data = "true";
        }
        UserResult userResult = new UserResult(200,"OK",data);
        return userResult;
    }

    @Override
    public UserResult createUser(Userinfo userinfo) {

        if (!userinfo.isLegalToDataBase()){
            return new UserResult(400,"faild","请完善个人信息");
        }

        // 利用 Spring自带的md5工具加密
        String md5pwd = DigestUtils.md5DigestAsHex(userinfo.getPassword().getBytes());
        userinfo.setPassword(md5pwd);
        // 生成 AccessToken 登陆令牌
        String token = UUID.randomUUID().toString();
        userinfo.setAccesstoken(token);

        // 捕获异常
        try {
            userinfoMapper.insert(userinfo);
        }catch (Exception e){
            return new UserResult(500,"faild",e.getMessage());
        }


        return new UserResult(200,"OK",token);
    }

    @Override
    public Userinfo login(String username, String password) {

        Userinfo userinfo;
        String md5pwd = DigestUtils.md5DigestAsHex(password.getBytes());

        try {
            userinfo = userinfoMapper.selectByPrimaryKey(Long.parseLong(username));
        }catch (Exception e){
            return new Userinfo();
        }


        if (!userinfo.getPassword().equals(md5pwd)){

            return new Userinfo();
        }
        return userinfo;
    }

    @Override
    public Boolean checkAccessToken(String uid,String accesstoken) {
        String token = userinfoMapper.selectAccessTokenByPrimaryKey(Long.parseLong(uid));
        if (token.equals(accesstoken)){
            return true;
        }
        return false;
    }
}
