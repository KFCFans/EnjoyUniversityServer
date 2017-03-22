package com.eu.service;

import com.eu.pojo.Activity;
import com.eu.pojo.Community;
import com.eu.pojo.Userinfo;

import java.util.List;

/**
 * Created by lip on 17/3/21.
 */
public interface UserInfoService {

    public Userinfo getUserInfoWithPermission(String uid,String accesstoken);

    public Userinfo getUserInfoWithoutPermission(String uid);

    public List<Userinfo> getParticipatorList(List<Long> uidlist);


}
