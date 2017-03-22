package com.eu.service.impl;

import com.eu.mapper.*;
import com.eu.pojo.*;
import com.eu.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lip on 17/3/21.
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserinfoMapper userinfoMapper;

    @Override
    public Userinfo getUserInfo(String uid) {

        Userinfo userinfo;
        try {
            userinfo = userinfoMapper.selectByPrimaryKey(Long.parseLong(uid));
        }catch (Exception e){
            return new Userinfo();
        }
        return userinfo;
    }




}
