package com.eu.service;

import com.eu.pojo.Community;
import com.eu.pojo.RequestResult;

import java.util.List;

/**
 * Created by lip on 17/3/22.
 */
public interface CommunityService {

    public List<Community> getCommonCommunities();

    public List<Community> getMyCommunities(String uid);

    public List<Community> getMyCollectedCommunities(String uid);

    public List<Long> getMemberPhoneList(int cmid);

    public RequestResult participateCommunity(String uid, int cmid,String reason);

    public RequestResult leaveCommunity(String uid,int cmid);

    public RequestResult manageCommunity(String uid,int cmid,int position);

}
