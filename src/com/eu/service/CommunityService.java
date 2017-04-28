package com.eu.service;

import com.eu.pojo.*;

import java.util.List;

/**
 * Created by lip on 17/3/22.
 */
public interface CommunityService {

    //FIXME: 只有正在招新的社团才能显示在推荐列表中
    public CommunityListResult getCommonCommunities(Integer page, Integer rows);

    // 获取我的社团名称列表以及上次选中的社团（用于下拉选择框）
    public CommunityNameListResult getMyCommunities(String uid);

    public CommunityListResult getMyCollectedCommunities(String uid);

    public CommunityMemberListResult getMemberPhoneList(int cmid);

    public UserListResult getCommunityMemberList(int cmid);

    public RequestResult participateCommunity(String uid, int cmid,String reason,String cmname);

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

    // 根据社团 ID 获取社团信息
    public CommunityResult getCommunityInfoByID(int cmid);

    // 获取社团通讯录（包括头像，姓名，性别，年级，职位，手机号）
    public CommunityContactsListResult getCommunityContactsByID(int cmid);

    // 设置下一次默认的社团
    /**
     * 操作逻辑 查询的时候得到值排序，最大的就是上次选中的，默认显示最大的
     * 点击后，最大值＋1回传数据库
     */
    public RequestResult setDefaultCommunity(String uid,int cmid,int num);

    public RequestResult deliverCommunity(String newboss,String oldboss,int cmid);

    /**
     * 批量修改用户申请社团状态
     * @param uids 用户 uid ，用逗号隔开 ,eg 15061883391，15061884292
     * @param cmid  社团 ID
     * @param position 职位
     * @return 400 200
     */
    public RequestResult verifyApplyCommunityMemberList(String uids,int cmid,int position);

}
