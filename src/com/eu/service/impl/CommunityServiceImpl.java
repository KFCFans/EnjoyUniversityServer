package com.eu.service.impl;

import com.eu.mapper.CommunityMapper;
import com.eu.mapper.CommunityauthorityMapper;
import com.eu.mapper.CommunitycollectionMapper;
import com.eu.pojo.*;
import com.eu.service.CommunityService;
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
    public List<Community> getCommonCommunities() {
        return communityMapper.selectByExample(new CommunityExample());
    }

    @Override
    public List<Community> getMyCommunities(String uid) {

        CommunityauthorityExample example = new CommunityauthorityExample();
        CommunityauthorityExample.Criteria  criteria= example.createCriteria();
        criteria.andUidEqualTo(Long.parseLong(uid));
        List<Communityauthority> communityauthorityList = communityauthorityMapper.selectByExample(example);
        List<Integer> cmidList = new ArrayList<>();
        for (Communityauthority communityauthority:communityauthorityList){
            cmidList.add(communityauthority.getCmid());
        }

        return selectCommunities(cmidList);
    }

    @Override
    public List<Community> getMyCollectedCommunities(String uid) {

        CommunitycollectionExample example = new CommunitycollectionExample();
        CommunitycollectionExample.Criteria criteria =example.createCriteria();
        criteria.andUidEqualTo(Long.parseLong(uid));
        List<CommunitycollectionKey> communitycollectionKeys = communitycollectionMapper.selectByExample(example);
        List<Integer> cmidList = new ArrayList<>();
        for (CommunitycollectionKey communitycollectionKey:communitycollectionKeys){
            cmidList.add(communitycollectionKey.getCmid());
        }
        return selectCommunities(cmidList);
    }

    @Override
    public List<Long> getMemberPhoneList(int cmid) {

        CommunityauthorityExample example = new CommunityauthorityExample();
        CommunityauthorityExample.Criteria criteria = example.createCriteria();
        criteria.andCmidEqualTo(cmid);
        List<Communityauthority> communityauthorityList = communityauthorityMapper.selectByExample(example);
        List<Long> phonelist = new ArrayList<>();
        for (Communityauthority communityauthority:communityauthorityList){
            phonelist.add(communityauthority.getUid());
        }
        return phonelist;
    }


    /// 查询一组 id 对应的社团
    private List<Community> selectCommunities(List<Integer> cmidlist){
        CommunityExample example = new CommunityExample();
        CommunityExample.Criteria criteria = example.createCriteria();
        criteria.andCmidIn(cmidlist);
        return communityMapper.selectByExample(example);
    }
}
