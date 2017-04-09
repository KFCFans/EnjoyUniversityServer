package com.eu.service.impl;

import com.eu.mapper.UserinfoMapper;
import com.eu.pojo.RequestResult;
import com.eu.pojo.Userinfo;
import com.eu.pojo.UserinfoExample;
import com.eu.service.UserSecurityService;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;
import java.util.UUID;

@Service
public class UserSecurityServiceImpl implements UserSecurityService {

    @Autowired
    private UserinfoMapper userinfoMapper;


    /**
     * 验证手机号
     * @param phone 手机号码
     * @param choice 业务选择，0代表注册验证（要求不存在手机号），1代表忘记密码验证（要求存在手机号）
     * @return 处理结果，200 成功返回验证码，400 失败返回错误信息，500 异常
     */
    @Override
    public RequestResult verifyPhoneNumber(String phone, int choice) {

        if (choice == 0 && isUidExisted(phone)){
            return new RequestResult(400,"faild","当前用户已注册");
        }

        if (choice == 1 && (!isUidExisted(phone))){
            return new RequestResult(400,"faild","用户不存在");
        }

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
        return new RequestResult(status,msg,code);
    }


    @Override
    public RequestResult createUser(Userinfo userinfo) {

        if (!userinfo.LegalToDataBase()){
            return new RequestResult(400,"faild","请完善个人信息");
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
            return new RequestResult(500,"faild",e.getMessage());
        }


        return new RequestResult(200,"OK",token);
    }

    @Override
    public RequestResult updatePasswordByVerifyPhone(String uid, String newpwd) {

        String token = UUID.randomUUID().toString();

        Userinfo userinfo = new Userinfo();
        userinfo.setUid(Long.parseLong(uid));
        userinfo.setPassword(DigestUtils.md5DigestAsHex(newpwd.getBytes()));
        userinfo.setAccesstoken(token);

        // updateByPrimaryKeySelective 表示传入字段不为空才更新
        try {
            userinfoMapper.updateByPrimaryKeySelective(userinfo);
        }catch (Exception e){
            return new RequestResult(500,"faild",e.getMessage());
        }

        return new RequestResult(200,"OK",token);
    }

    @Override
    public RequestResult updatePasswordByOldPassword(String uid, String oldpwd, String newpwd) {

        Userinfo userinfo = userinfoMapper.selectByPrimaryKey(Long.parseLong(uid));
        if (!userinfo.getPassword().equals(DigestUtils.md5DigestAsHex(oldpwd.getBytes()))){
            return new RequestResult(401,"faild","密码错误");
        }
        //修改密码(直接调用通过手机验证后的方法)
        return updatePasswordByVerifyPhone(uid,newpwd);
    }


    @Override
    public RequestResult login(String username, String password) {

        Userinfo userinfo;
        String md5pwd = DigestUtils.md5DigestAsHex(password.getBytes());

        try {
            userinfo = userinfoMapper.selectByPrimaryKey(Long.parseLong(username));
        }catch (Exception e){
            return new RequestResult(500,"faild",e.getMessage());
        }


        if (!userinfo.getPassword().equals(md5pwd)){

            return new RequestResult(401,"faild","用户名或密码错误");
        }
        return new RequestResult(200,"OK",userinfo.getAccesstoken());
    }

    @Override
    public Boolean checkAccessToken(String accesstoken) {

        UserinfoExample example = new UserinfoExample();
        UserinfoExample.Criteria  criteria= example.createCriteria();
        criteria.andAccesstokenEqualTo(accesstoken);
        List<Userinfo> list = userinfoMapper.selectByExample(example);

        if (list == null || list.size()==0){
            return false;
        }

        return true;
    }

    // 发送短信前验证
    private Boolean isUidExisted(String phone){
        long uid = Long.parseLong(phone);
        Userinfo userinfo = userinfoMapper.selectByPrimaryKey(uid);
        if (userinfo==null){
            return false;
        }
        return true;
    }
}
