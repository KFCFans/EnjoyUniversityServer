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

    @Override
    public List<Userinfo> getParticipatorList(List<Long> uidlist) {

        return userinfoMapper.selectByPrimaryKeyList(uidlist);
    }

    @Override
    public RequestResult changeReputation(String uid, int reputation) {

        Userinfo userinfo = new Userinfo();
        userinfo.setUid(Long.parseLong(uid));
        userinfo.setReputation(reputation);
        try {
            userinfoMapper.updateByPrimaryKeySelective(userinfo);
        }catch (Exception e){
            return new RequestResult(500,"faild",e.getMessage());
        }
        return new RequestResult(200,"OK",null);
    }

    @Override
    public RequestResult changeUserInfo(Userinfo userinfo) {

        try {
            userinfoMapper.updateByPrimaryKeySelective(userinfo);
        }catch (Exception e){
            return new RequestResult(500,"faild",e.getMessage());
        }
        return new RequestResult(200,"OK",null);
    }

    @Override
    public RequestResult verifyUser(String uid) {

        Userinfo userinfo = new Userinfo();
        userinfo.setUid(Long.parseLong(uid));
        userinfo.setVerified(1);

        try {
            userinfoMapper.updateByPrimaryKeySelective(userinfo);
        }catch (Exception e){
            return new RequestResult(500,"faild",e.getMessage());
        }
        return new RequestResult(200,"OK",null);
    }

    @Override
    public List<Userinfo> searchUser(String keyword) {

        List<Userinfo> userinfoList;
        UserinfoExample nicknameexample = new UserinfoExample();

        UserinfoExample.Criteria criteria = nicknameexample.createCriteria();
        criteria.andNicknameLike("%"+keyword+"%");

        try {
            userinfoList = userinfoMapper.selectByExample(nicknameexample);
        }catch (Exception e){
            return null;
        }

        return userinfoList;
    }


}
