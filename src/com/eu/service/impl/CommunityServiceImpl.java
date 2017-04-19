package com.eu.service.impl;

import com.eu.mapper.CommunityMapper;
import com.eu.mapper.CommunityauthorityMapper;
import com.eu.mapper.CommunitycollectionMapper;
import com.eu.mapper.MultiTableQueryMapper;
import com.eu.pojo.*;
import com.eu.service.CommunityService;
import com.eu.service.UserInfoService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lip on 17/3/22.
 */
@Service
public class CommunityServiceImpl implements CommunityService {

    @Autowired
    private CommunityMapper communityMapper;

    @Autowired
    private CommunityauthorityMapper communityauthorityMapper;

    @Autowired
    private CommunitycollectionMapper communitycollectionMapper;

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private MultiTableQueryMapper multiTableQueryMapper;

    @Override
    public CommunityListResult getCommonCommunities(Integer page,Integer rows) {

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

        CommunityExample example = new CommunityExample();
        example.setOrderByClause("cm_heat desc");

        PageHelper.startPage(page, rows);
        try {
            return new CommunityListResult(200,"OK",communityMapper.selectByExample(example));
        }catch (Exception e){
            return new CommunityListResult(500,e.getMessage(),null);
        }

    }

    @Override
    public CommunityNameListResult getMyCommunities(String uid) {

        CommunityauthorityExample example = new CommunityauthorityExample();
        CommunityauthorityExample.Criteria  criteria= example.createCriteria();
        criteria.andUidEqualTo(Long.parseLong(uid));
        List<Communityauthority> list;
        try {
            list = communityauthorityMapper.selectByExample(example);
        }catch (Exception e){
            return new CommunityNameListResult(500,e.getMessage(),null);
        }
        return new CommunityNameListResult(200,"OK",list);
    }

    @Override
    public CommunityListResult getMyCollectedCommunities(String uid) {

        CommunitycollectionExample example = new CommunitycollectionExample();
        CommunitycollectionExample.Criteria criteria =example.createCriteria();
        criteria.andUidEqualTo(Long.parseLong(uid));
        List<Community> communityList;
        try {
            List<CommunitycollectionKey> communitycollectionKeys = communitycollectionMapper.selectByExample(example);
            List<Integer> cmidList = new ArrayList<>();
            for (CommunitycollectionKey communitycollectionKey:communitycollectionKeys){
                cmidList.add(communitycollectionKey.getCmid());
            }
            communityList = selectCommunities(cmidList);
        }catch (Exception e){
            return new CommunityListResult(500,e.getMessage(),null);
        }

        return new CommunityListResult(200,"OK",communityList);
    }

    /**
     *  获取参加社团的用户简易信息已经上次进去的社团（只查询 CommunityAuthority 表）
     * @param cmid 社团 ID
     * @return CommunityAuthority 数组
     */
    @Override
    public CommunityMemberListResult getMemberPhoneList(int cmid) {

        CommunityauthorityExample example = new CommunityauthorityExample();
        CommunityauthorityExample.Criteria criteria = example.createCriteria();
        criteria.andCmidEqualTo(cmid);
        // 大于 0 的才出现在我的社团中（还在申请的为－1）
        criteria.andLastselectGreaterThanOrEqualTo(0);
        List<Communityauthority> communityauthorityList;
        try {
             communityauthorityList = communityauthorityMapper.selectByExample(example);
        }catch (Exception e){
            return new CommunityMemberListResult(500,e.getMessage(),null);
        }

        return new CommunityMemberListResult(200,"OK",communityauthorityList);
    }

    /**
     * 获取社团参与者的详细信息
     * @param cmid 社团ID
     * @return 用户信息列表
     */
    @Override
    public UserListResult getCommunityMemberList(int cmid) {

        List<Userinfo> list;
        List<Long> phonelist = new ArrayList<>();
        for (Communityauthority communityauthority: getMemberPhoneList(cmid).getData()){
            phonelist.add(communityauthority.getUid());
        }
        try {

            list = userInfoService.getParticipatorList(phonelist).getData();

        }catch (Exception e){
            return new UserListResult(500,e.getMessage(),null);
        }
        return new UserListResult(200,"OK",list);
    }

    /**
     * 申请加入社团
     * @param uid 用户 ID
     * @param cmid 社团 ID
     * @param reason 申请理由
     * @param cmname 社团名称（增加冗余换取性能）
     * @return 200 500
     */
    @Override
    public RequestResult participateCommunity(String uid, int cmid, String reason,String cmname) {

        Communityauthority communityauthority = new Communityauthority();
        communityauthority.setPosition(-3);
        communityauthority.setReason(reason);
        communityauthority.setCmid(cmid);
        communityauthority.setUid(Long.parseLong(uid));
        communityauthority.setCmname(cmname);
        communityauthority.setLastselect(-1);
        try {
            communityauthorityMapper.insert(communityauthority);
        }catch (Exception e){
            return new RequestResult(500,"faild",e.getMessage());
        }
        return new RequestResult(200,"OK",null);
    }

    @Override
    public RequestResult leaveCommunity(String uid, int cmid) {

        CommunityauthorityKey communityauthorityKey = new CommunityauthorityKey();
        communityauthorityKey.setUid(Long.parseLong(uid));
        communityauthorityKey.setCmid(cmid);
        int succeed = 0;
        try {
            succeed=communityauthorityMapper.deleteByPrimaryKey(communityauthorityKey);
        }catch (Exception e){
            return new RequestResult(500,"faild",e.getMessage());
        }
        if (succeed == 0){
            return new RequestResult(400,"faild","删除失败");
        }

        return new RequestResult(200,"OK",null);
    }

    /**
     * 设置管理员
     * @param uid 要设置的人的 uid
     * @param cmid  要设置社团的 cmid
     * @param position 要设置的职位
     * @return 200 400 500
     */
    @Override
    public RequestResult manageCommunity(String uid, int cmid, int position) {

        Communityauthority communityauthority = new Communityauthority();
        communityauthority.setPosition(position);
        communityauthority.setUid(Long.parseLong(uid));
        communityauthority.setCmid(cmid);
        if (position > 0){
            communityauthority.setLastselect(0);
        }
        int succeed = 0;
        try {
            succeed=communityauthorityMapper.updateByPrimaryKeySelective(communityauthority);
        }catch (Exception e){
            return new RequestResult(500,"faild",e.getMessage());
        }
        if (succeed == 0){
            return new RequestResult(400,"faild","修改失败");
        }

        return new RequestResult(200,"OK",null);
    }

    @Override
    public RequestResult getCommunityState(int cmid) {

        Integer state = -1111;

        try {
            Community community = communityMapper.selectByPrimaryKey(cmid);
            state = community.getCmRecruit();
        }catch (Exception e){
            return new RequestResult(500,"faild",e.getMessage());
        }
        if (state==-1111){
            return new RequestResult(400,"faild","查询失败");
        }

        return new RequestResult(200,"OK",state.toString());
    }

    @Override
    public RequestResult changeCommunityState(int cmid, int cmRecruit) {

        Community community = new Community();
        community.setCmid(cmid);
        community.setCmRecruit(cmRecruit);
        try {
            communityMapper.updateByPrimaryKeySelective(community);
        }catch (Exception e){
            return new RequestResult(500,"faild",e.getMessage());
        }

        return new RequestResult(200,"OK",null);
    }

    @Override
    public RequestResult changeCommunityInfo(Community community) {
        try {
            communityMapper.updateByPrimaryKeySelective(community);
        }catch (Exception e){
            return new RequestResult(500,"faild",e.getMessage());
        }
        return new RequestResult(200,"OK",null);
    }

    @Override
    public RequestResult collectCommunity(String uid, int cmid) {
        CommunitycollectionKey communitycollectionKey = new CommunitycollectionKey();
        communitycollectionKey.setUid(Long.parseLong(uid));
        communitycollectionKey.setCmid(cmid);
        try {
            communitycollectionMapper.insert(communitycollectionKey);
        }catch (Exception e){
            return new RequestResult(500,"faild",e.getMessage());
        }

        return new RequestResult(200,"OK",null);
    }

    @Override
    public RequestResult disCollectCommunity(String uid, int cmid) {
        CommunitycollectionKey communitycollectionKey = new CommunitycollectionKey();
        communitycollectionKey.setUid(Long.parseLong(uid));
        communitycollectionKey.setCmid(cmid);
        try {
            communitycollectionMapper.deleteByPrimaryKey(communitycollectionKey);
        }catch (Exception e){
            return new RequestResult(500,"faild",e.getMessage());
        }

        return new RequestResult(200,"OK",null);
    }

    @Override
    public CommunityListResult searchCommunity(String keyword,Integer page,Integer rows) {

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
        System.out.println("rows->"+rows);
        System.out.println("page->"+page);

        CommunityExample example = new CommunityExample();
        CommunityExample.Criteria criteria = example.createCriteria();
        criteria.andCmNameLike("%"+keyword+"%");
        List<Community> list;
        try {
            PageHelper.startPage(page,rows);
            list = communityMapper.selectByExample(example);
        }catch (Exception e){
            return new CommunityListResult(500,e.getMessage(),null);
        }
        return new CommunityListResult(200,"OK",list);
    }

    @Override
    public CommunityResult getCommunityInfoByID(int cmid) {

        try {
            return new CommunityResult(200,"OK",communityMapper.selectByPrimaryKey(cmid));
        }catch (Exception e){
            return new CommunityResult(500,e.getMessage(),null);
        }

    }

    @Override
    public CommunityContactsListResult getCommunityContactsByID(int cmid) {
        try {
            return new CommunityContactsListResult(200,"OK",multiTableQueryMapper.selectContactsByCmid(cmid));
        }catch (Exception e){
            return new CommunityContactsListResult(500,e.getMessage(),null);
        }
    }

    @Override
    public RequestResult setDefaultCommunity(String uid, int cmid,int num) {

        Communityauthority communityauthority = new Communityauthority();
        communityauthority.setCmid(cmid);
        communityauthority.setUid(Long.parseLong(uid));
        communityauthority.setLastselect(num);
        try {
            communityauthorityMapper.updateByPrimaryKeySelective(communityauthority);
        }catch (Exception e){
            return new RequestResult(500,e.getMessage(),null);
        }
        return new RequestResult(200,"OK",null);
    }


    /// 查询一组 id 对应的社团
    private List<Community> selectCommunities(List<Integer> cmidlist) throws Exception{
        CommunityExample example = new CommunityExample();
        CommunityExample.Criteria criteria = example.createCriteria();
        criteria.andCmidIn(cmidlist);

        return communityMapper.selectByExample(example);


    }
}
