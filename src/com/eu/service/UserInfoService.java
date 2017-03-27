package com.eu.service;

import com.eu.pojo.Activity;
import com.eu.pojo.Community;
import com.eu.pojo.RequestResult;
import com.eu.pojo.Userinfo;

import java.util.List;

/**
 * Created by lip on 17/3/21.
 */
public interface UserInfoService {

    public Userinfo getUserInfoWithPermission(String uid,String accesstoken);

    public Userinfo getUserInfoWithoutPermission(String uid);

    public List<Userinfo> getParticipatorList(List<Long> uidlist);

    public RequestResult changeReputation(String uid,int reputation);

    public RequestResult changeUserInfo(Userinfo userinfo);

    public RequestResult verifyUser(String uid);

    public List<Userinfo> searchUser(String keyword,Integer page,Integer rows);

    // 批量修改节操值
    public RequestResult deductReputation(List<Long> uidlist);

    public RequestResult increaseReputation(List<Long> uidlist);

    public RequestResult correctReputation(List<Long> uidlist);




}
