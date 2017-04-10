package com.eu.service;

import com.eu.pojo.*;

import java.util.List;

/**
 * Created by lip on 17/3/22.
 */
public interface CommunityService {

    //FIXME: 只有正在招新的社团才能显示在推荐列表中
    public CommunityListResult getCommonCommunities(Integer page, Integer rows);

    public CommunityListResult getMyCommunities(String uid);

    public CommunityListResult getMyCollectedCommunities(String uid);

    public PhoneListResult getMemberPhoneList(int cmid);

    public UserListResult getCommunityMemberList(int cmid);

    public RequestResult participateCommunity(String uid, int cmid,String reason);

    public RequestResult leaveCommunity(String uid,int cmid);

    public RequestResult manageCommunity(String uid,int cmid,int position);

    // 获取社团状态（是否正在招新）
    public RequestResult getCommunityState(int cmid);

    // 修改社团状态（开启／关闭招新）
    public RequestResult changeCommunityState(int cmid,int cmRecruit);

    // 修改社团信息
    public RequestResult changeCommunityInfo(Community community);

    // 收藏社团
    public RequestResult collectCommunity(String uid,int cmid);

    // 取消收藏社团
    public RequestResult disCollectCommunity(String uid,int cmid);

    // 搜索社团
    public CommunityListResult searchCommunity(String keyword,Integer page,Integer rows);

}
