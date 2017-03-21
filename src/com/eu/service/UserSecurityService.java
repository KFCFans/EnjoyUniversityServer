package com.eu.service;

import com.eu.pojo.UserResult;
import com.eu.pojo.Userinfo;
import com.taobao.api.ApiException;

/**
 * Created by lip on 17/3/21.
 */
public interface UserSecurityService {


    public UserResult verifyPhoneNumber(String phone) throws ApiException;

    public UserResult checkUid(String phone);

    public UserResult createUser(Userinfo userinfo);

    public Userinfo login(String username,String password);

    public Boolean checkAccessToken(String uid,String accesstoken);

}
