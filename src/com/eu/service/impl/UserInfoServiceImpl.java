package com.eu.service.impl;

import com.eu.mapper.*;
import com.eu.pojo.*;
import com.eu.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lip on 17/3/21.
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserinfoMapper userinfoMapper;

    @Override
    public Userinfo getUserInfoWithPermission(String uid, String accesstoken) {
        Userinfo userinfo;
        try {
            userinfo = userinfoMapper.selectByPrimaryKey(Long.parseLong(uid));
        }catch (Exception e){
            return new Userinfo();
        }
        if (!userinfo.getAccesstoken().equals(accesstoken)){
            return new Userinfo();
        }
        return userinfo;
    }

    @Override
    public Userinfo getUserInfoWithoutPermission(String uid) {

        Userinfo userinfo = userinfoMapper.selectByPrimaryKey(Long.parseLong(uid));
        userinfo.hidePersonalSecret(true);
        return userinfo;
    }


}
