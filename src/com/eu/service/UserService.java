package com.eu.service;

import com.eu.pojo.UserResult;
import com.eu.pojo.Userinfo;
import com.taobao.api.ApiException;

/**
 * Created by lip on 17/3/21.
 */
public interface UserService {


    public UserResult verifyPhoneNumber(String phone) throws ApiException;

    public UserResult checkPhoneNumber(String phone);

    public UserResult createUser(Userinfo userinfo);

    public UserResult login(String username,String password);

}
