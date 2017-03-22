package com.eu.service;

import com.eu.pojo.UserResult;
import com.eu.pojo.Userinfo;
import com.taobao.api.ApiException;

/**
 * Created by lip on 17/3/21.
 */
public interface UserSecurityService {


    public UserResult verifyPhoneNumber(String phone,int choice) throws ApiException;


    public UserResult createUser(Userinfo userinfo);

    public UserResult updatePasswordByVerifyPhone(String uid,String newpwd);

    public UserResult updatePasswordByOldPassword(String uid,String oldpwd,String newpwd);

    public Userinfo login(String username,String password);

    public Boolean checkAccessToken(String accesstoken);

}
