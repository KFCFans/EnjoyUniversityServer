package com.eu.service.impl;

import com.eu.mapper.CommunityMapper;
import com.eu.mapper.CommunityauthorityMapper;
import com.eu.mapper.CommunitycollectionMapper;
import com.eu.pojo.*;
import com.eu.service.CommunityService;
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
    public CommunityListResult getMyCommunities(String uid) {

        CommunityauthorityExample example = new CommunityauthorityExample();
        CommunityauthorityExample.Criteria  criteria= example.createCriteria();
        criteria.andUidEqualTo(Long.parseLong(uid));
        List<Community> list;
        try {
            List<Communityauthority> communityauthorityList = communityauthorityMapper.selectByExample(example);
            List<Integer> cmidList = new ArrayList<>();
            for (Communityauthority communityauthority:communityauthorityList){
                cmidList.add(communityauthority.getCmid());
            }
            list = selectCommunities(cmidList);
        }catch (Exception e){
            return new CommunityListResult(500,e.getMessage(),null);
        }
        return new CommunityListResult(200,"OK",list);

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

    @Override
    public PhoneListResult getMemberPhoneList(int cmid) {

        CommunityauthorityExample example = new CommunityauthorityExample();
        CommunityauthorityExample.Criteria criteria = example.createCriteria();
        List<Long> phonelist = new ArrayList<>();
        criteria.andCmidEqualTo(cmid);
        try {
            List<Communityauthority> communityauthorityList = communityauthorityMapper.selectByExample(example);
            for (Communityauthority communityauthority:communityauthorityList){
                phonelist.add(communityauthority.getUid());
            }
        }catch (Exception e){
            return new PhoneListResult(500,e.getMessage(),null);
        }

        return new PhoneListResult(200,"OK",phonelist);
    }

    @Override
    public RequestResult participateCommunity(String uid, int cmid, String reason) {

        Communityauthority communityauthority = new Communityauthority();
        communityauthority.setPosition(-3);
        communityauthority.setReason(reason);
        communityauthority.setCmid(cmid);
        communityauthority.setUid(Long.parseLong(uid));
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
     * @return
     */
    @Override
    public RequestResult manageCommunity(String uid, int cmid, int position) {

        Communityauthority communityauthority = new Communityauthority();
        communityauthority.setPosition(position);
        communityauthority.setUid(Long.parseLong(uid));
        communityauthority.setCmid(cmid);
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


    /// 查询一组 id 对应的社团
    private List<Community> selectCommunities(List<Integer> cmidlist) throws Exception{
        CommunityExample example = new CommunityExample();
        CommunityExample.Criteria criteria = example.createCriteria();
        criteria.andCmidIn(cmidlist);

        return communityMapper.selectByExample(example);


    }
}
