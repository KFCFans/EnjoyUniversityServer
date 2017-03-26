package com.eu.service;

import com.eu.pojo.Community;
import com.eu.pojo.RequestResult;

import java.util.List;

/**
 * Created by lip on 17/3/22.
 */
public interface CommunityService {

    //FIXME: 只有正在招新的社团才能显示在推荐列表中
    public List<Community> getCommonCommunities(int page,int rows);

    public List<Community> getMyCommunities(String uid);

    public List<Community> getMyCollectedCommunities(String uid);

    public List<Long> getMemberPhoneList(int cmid);

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
    public List<Community> searchCommunity(String keyword,int page,int rows);

}
