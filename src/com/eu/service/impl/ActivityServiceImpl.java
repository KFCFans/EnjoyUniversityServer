package com.eu.service.impl;

import com.eu.mapper.ActivityMapper;
import com.eu.mapper.ActivitycollectionMapper;
import com.eu.mapper.ParticipateactivityMapper;
import com.eu.pojo.*;
import com.eu.service.ActivityService;
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
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityMapper activityMapper;

    @Autowired
    private ActivitycollectionMapper activitycollectionMapper;

    @Autowired
    private ParticipateactivityMapper participateactivityMapper;


    @Override
    public List<Activity> getCommonActivities(int page,int rows) {

        // 设置默认值
        if (rows == 0){
            rows = 20;
        }
        PageHelper.startPage(page,rows);
        List<Activity> activityList = activityMapper.selectByExample(new ActivityExample());

        return activityList;
    }

    @Override
    public List<Activity> getMyCreatedActivities(String uid) {

        ActivityExample example = new ActivityExample();
        ActivityExample.Criteria criteria = example.createCriteria();
        criteria.andUidEqualTo(Long.parseLong(uid));

        return activityMapper.selectByExample(example);
    }

    @Override
    public List<Activity> getMyJoinedActivities(String uid) {
        ParticipateactivityExample example = new ParticipateactivityExample();
        ParticipateactivityExample.Criteria criteria = example.createCriteria();
        criteria.andUidEqualTo(Long.parseLong(uid));
        List<Participateactivity> list= participateactivityMapper.selectByExample(example);
        List<Integer> avidlist = new ArrayList<>();
        for (Participateactivity pav:list){
            avidlist.add(pav.getAvid());
        }
        return selectActivities(avidlist);
    }

    @Override
    public List<Activity> getMyCollectedActivities(String uid) {

        ActivitycollectionExample activitycollectionExample = new ActivitycollectionExample();
        ActivitycollectionExample.Criteria criteria = activitycollectionExample.createCriteria();
        criteria.andUidEqualTo(Long.parseLong(uid));
        List<ActivitycollectionKey> activitycollectionKeys = activitycollectionMapper.selectByExample(activitycollectionExample);
        List<Integer> avidlist = new ArrayList<>();
        for (ActivitycollectionKey activitycollectionKey:activitycollectionKeys){
            avidlist.add(activitycollectionKey.getAvid());
        }

        return selectActivities(avidlist);
    }

    @Override
    public List<Long> getParticipatorPhoneList(int avid) {

        ParticipateactivityExample participateactivityExample = new ParticipateactivityExample();
        ParticipateactivityExample.Criteria criteria = participateactivityExample.createCriteria();
        criteria.andAvidEqualTo(avid);
        List<Participateactivity> list = participateactivityMapper.selectByExample(participateactivityExample);
        List<Long> phonelist = new ArrayList<>();
        for(Participateactivity participateactivity:list){
            phonelist.add(participateactivity.getUid());
        }

        return phonelist;
    }

    @Override
    public RequestResult deleteActivity(int avid,String uid) {

        if (!activityMapper.selectByPrimaryKey(avid).getUid().toString().equals(uid)){
            return new RequestResult(400,"faild","没有权限删除活动");
        }

        try {
            activityMapper.deleteByPrimaryKey(avid);
        }catch (Exception e){
            return new RequestResult(500,"faild",e.getMessage());
        }

        return new RequestResult(200,"OK",null);
    }

    @Override
    public RequestResult changeActivity(Activity activity,String uid) {

        if (!activityMapper.selectByPrimaryKey(activity.getAvid()).getUid().toString().equals(uid)){
            return new RequestResult(400,"faild","没有权限修改活动");
        }

        try {
            activityMapper.updateByPrimaryKeySelective(activity);
        }catch (Exception e){
            return new RequestResult(500,"faild",e.getMessage());
        }

        return new RequestResult(200,"OK",null);
    }

    @Override
    public RequestResult participateActivity(String uid, int avid) {

        Participateactivity participateactivity = new Participateactivity();
        participateactivity.setAvid(avid);
        participateactivity.setUid(Long.parseLong(uid));
//        participateactivity.setVerifystate(0);
        try {
            participateactivityMapper.insertSelective(participateactivity);
        }catch (Exception e){
            return new RequestResult(500,"faild",e.getMessage());
        }

        return new RequestResult(200,"OK",null);
    }

    @Override
    public RequestResult quitActivity(String uid, int avid) {

        ParticipateactivityKey participateactivityKey = new ParticipateactivityKey();
        participateactivityKey.setUid(Long.parseLong(uid));
        participateactivityKey.setAvid(avid);
        try {
            participateactivityMapper.deleteByPrimaryKey(participateactivityKey);

        }catch (Exception e){
            return new RequestResult(500,"faild",null);
        }
        return new RequestResult(200,"OK",null);
    }

    @Override
    public RequestResult createActivity(Activity activity) {

        try {
            activityMapper.insert(activity);
        }catch (Exception e){
            return new RequestResult(500,"faild",e.getMessage());
        }
        return new RequestResult(200,"OK",null);
    }

    @Override
    public RequestResult collectActivity(String uid, int avid) {
        ActivitycollectionKey activitycollectionKey = new ActivitycollectionKey();
        activitycollectionKey.setUid(Long.parseLong(uid));
        activitycollectionKey.setAvid(avid);
        try {
            activitycollectionMapper.insert(activitycollectionKey);
        }catch (Exception e){
            return new RequestResult(500,"faild",e.getMessage());
        }

        return new RequestResult(200,"OK",null);
    }

    @Override
    public RequestResult disCollectActivity(String uid, int avid) {
        ActivitycollectionKey activitycollectionKey = new ActivitycollectionKey();
        activitycollectionKey.setUid(Long.parseLong(uid));
        activitycollectionKey.setAvid(avid);
        try {
            activitycollectionMapper.deleteByPrimaryKey(activitycollectionKey);
        }catch (Exception e){
            return new RequestResult(500,"faild",e.getMessage());
        }

        return new RequestResult(200,"OK",null);
    }


    @Override
    public RequestResult manageParticipators(String uid, int avid,int verifystate,String reason) {

        Participateactivity participateactivity = new Participateactivity();
        participateactivity.setVerifystate(verifystate);
        participateactivity.setAvid(avid);
        participateactivity.setReason(reason);
        participateactivity.setUid(Long.parseLong(uid));
        try {
            participateactivityMapper.updateByPrimaryKey(participateactivity);
        }catch (Exception e){
            return new RequestResult(500,"faild",e.getMessage());
        }

        return new RequestResult(200,"OK",null);
    }

    @Override
    public RequestResult startRegister(String uid, int avid) {

        if (!activityMapper.selectByPrimaryKey(avid).getUid().toString().equals(uid)){
            return new RequestResult(400,"faild","没有权限发起签到");
        }
        //随机生成签到码
        Integer randomcode = 1000+(int)(Math.random()*9000);

        Activity activity = new Activity();
        activity.setAvid(avid);
        activity.setAvRegister(randomcode);
        try {
            activityMapper.updateByPrimaryKeySelective(activity);
        }catch (Exception e){
            return new RequestResult(500,"faild",e.getMessage());
        }
        return new RequestResult(200,"OK",randomcode.toString());
    }

    @Override
    public RequestResult getRegisterInfo(int avid) {

        Integer code;
        try {
            code = activityMapper.selectByPrimaryKey(avid).getAvRegister();
        }catch (Exception e){
            return new RequestResult(500,"faild",e.getMessage());
        }
        if (code == -1){
            return new RequestResult(400,"faild","该活动无需签到");
        }
        if (code == 0 ){
            return new RequestResult(400,"faild","尚未开始签到");
        }
        return new RequestResult(200,"OK",code.toString());


    }

    @Override
    public RequestResult participateRegister(String uid, int avid) {

        Participateactivity participateactivity = new Participateactivity();
        participateactivity.setUid(Long.parseLong(uid));
        participateactivity.setAvid(avid);
        participateactivity.setVerifystate(1);
        try {
            participateactivityMapper.updateByPrimaryKeySelective(participateactivity);
        }catch (Exception e){
            return new RequestResult(500,"faild",e.getMessage());
        }
        return new RequestResult(200,"OK",null);
    }

    @Override
    public List<Activity> searchActivities(String keyword) {

        ActivityExample example = new ActivityExample();
        ActivityExample.Criteria criteria = example.createCriteria();
        criteria.andAvTitleLike("%"+keyword+"%");
        List<Activity> list;
        try {
            list = activityMapper.selectByExample(example);
        }catch (Exception e){
            return null;
        }

        return list;
    }


    /// 查询一组 id 对应的活动
    private List<Activity> selectActivities(List<Integer> avidlist){
        ActivityExample example = new ActivityExample();
        ActivityExample.Criteria criteria = example.createCriteria();
        criteria.andAvidIn(avidlist);
        return activityMapper.selectByExample(example);
    }
}
