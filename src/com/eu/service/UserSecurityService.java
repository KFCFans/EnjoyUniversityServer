package com.eu.service;

import com.eu.pojo.RequestResult;
import com.eu.pojo.Userinfo;
import com.taobao.api.ApiException;

/**
 * Created by lip on 17/3/21.
 */
public interface UserSecurityService {


    public RequestResult verifyPhoneNumber(String phone, int choice) throws ApiException;


    public RequestResult createUser(Userinfo userinfo);

    public RequestResult updatePasswordByVerifyPhone(String uid, String newpwd);

    public RequestResult updatePasswordByOldPassword(String uid, String oldpwd, String newpwd);

    public Userinfo login(String username,String password);

    public Boolean checkAccessToken(String accesstoken);

}
