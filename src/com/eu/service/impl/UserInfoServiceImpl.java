package com.eu.service.impl;

import com.eu.mapper.*;
import com.eu.pojo.*;
import com.eu.service.UserInfoService;
import com.github.pagehelper.PageHelper;
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
    public UserInfoResult getUserInfoWithPermission(String uid, String accesstoken) {
        Userinfo userinfo;
        try {
            userinfo = userinfoMapper.selectByPrimaryKey(Long.parseLong(uid));
        }catch (Exception e){
            return new UserInfoResult(500,e.getMessage(),null);
        }
        if (!userinfo.getAccesstoken().equals(accesstoken)){
            return new UserInfoResult(401,"faild",null);
        }
        return new UserInfoResult(200,"OK",userinfo);
    }

    @Override
    public UserInfoResult getUserInfoWithoutPermission(String uid) {

        try {
            Userinfo userinfo = userinfoMapper.selectByPrimaryKey(Long.parseLong(uid));
            userinfo.hidePersonalSecret(true);
            return new UserInfoResult(200,"OK",userinfo);
        }catch (Exception e){
            return new UserInfoResult(500,e.getMessage(),null);
        }
    }

    @Override
    public UserListResult getParticipatorList(List<Long> uidlist) {

        List<Userinfo> list;
        try {
            list = userinfoMapper.selectByPrimaryKeyList(uidlist);
        }catch (Exception e){
            return new UserListResult(500,e.getMessage(),null);
        }
        return new UserListResult(200,"OK",list);
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
    public UserListResult searchUser(String keyword,Integer page,Integer rows) {

        // Java 没有默认值，说多了都是泪啊
        if (page == null){
            page = 1;
        }
        if (rows ==null){
            rows = 15;
        }
        if (rows == 0 ){
            rows = 15;
        }

        List<Userinfo> userinfoList;
        UserinfoExample example = new UserinfoExample();

        UserinfoExample.Criteria criteria = example.createCriteria();
        criteria.andNameLike("%"+keyword+"%");

        try {
            PageHelper.startPage(page,rows);
            userinfoList = userinfoMapper.selectByExample(example);
        }catch (Exception e){
            return new UserListResult(500,e.getMessage(),null);
        }

        return new UserListResult(200,"OK",userinfoList);
    }

    @Override
    public RequestResult deductReputation(List<Long> uidlist) {
        try {
            userinfoMapper.deductReputation(uidlist);
        }catch (Exception e){
            return new RequestResult(500,"faild",e.getMessage());
        }

        return new RequestResult(200,"OK",null);
    }

    @Override
    public RequestResult increaseReputation(List<Long> uidlist) {
        try {
            userinfoMapper.increaseReputation(uidlist);
        }catch (Exception e){
            return new RequestResult(500,"faild",e.getMessage());
        }
        return new RequestResult(200,"OK",null);
    }



}
