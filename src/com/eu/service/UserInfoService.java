package com.eu.service;

import com.eu.pojo.*;

import java.util.List;

/**
 * Created by lip on 17/3/21.
 */
public interface UserInfoService {

    public UserInfoResult getUserInfoWithPermission(String uid,String accesstoken);

    public UserInfoResult getUserInfoWithoutPermission(String uid);

    public UserListResult getParticipatorList(List<Long> uidlist);

    public RequestResult changeReputation(String uid,int reputation);

    public RequestResult changeUserInfo(Userinfo userinfo);

    public RequestResult verifyUser(String uid);

    public UserListResult searchUser(String keyword,Integer page,Integer rows);

    // 批量修改节操值
    public RequestResult deductReputation(List<Long> uidlist);

    public RequestResult increaseReputation(List<Long> uidlist);





}
