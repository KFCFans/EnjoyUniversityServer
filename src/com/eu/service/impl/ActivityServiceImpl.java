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

import java.util.*;

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

    @Autowired
    private UserInfoService userInfoService;


    @Override
    public ActivityListResult getCommonActivities(String mintime, String maxtime, Integer count) {

        // count 默认 10 条
        if (count == null||count == 0){
            count = 10;
        }

        // 初始化查询条件
        ActivityExample example = new ActivityExample();
        ActivityExample.Criteria criteria = example.createCriteria();
        criteria.andAvStarttimeGreaterThan(new Date());
        example.setOrderByClause("av_starttime asc LIMIT "+count.toString());

        try{
            // 若都没有参数，则是第一次加载数据，获取最新的数据
            if ((mintime ==null || mintime.isEmpty())&&(maxtime ==null || maxtime.isEmpty())){

                return new ActivityListResult(200,"OK",activityMapper.selectByExample(example));

            }
            // 只有最小时间，表示下拉刷新，获取比 mintime 时间小的活动
            else if ((mintime !=null && !mintime.isEmpty())&&(maxtime ==null || maxtime.isEmpty())){

                criteria.andAvStarttimeLessThan(new Date(Long.parseLong(mintime)));

                return new ActivityListResult(200,"OK",activityMapper.selectByExample(example));

            }
            // 只有最大时间，表示上拉加载更多，获取比 maxtime 时间大的活动
            else if ((mintime ==null || mintime.isEmpty())&&(maxtime !=null && !maxtime.isEmpty())){


                // 时间越大，越安全
                criteria.andAvStarttimeGreaterThan(new Date(Long.parseLong(maxtime)));
                return new ActivityListResult(200,"OK",activityMapper.selectByExample(example));
            }
        }catch (Exception e){
            return new ActivityListResult(500,e.getMessage(),null);
        }


        return new ActivityListResult(400,"无效的请求",null);
    }

    @Override
    public ActivityListResult getMyCreatedActivities(String uid) {

        ActivityExample example = new ActivityExample();
        ActivityExample.Criteria criteria = example.createCriteria();
        criteria.andUidEqualTo(Long.parseLong(uid));

        List<Activity> list;
        try {
            list = activityMapper.selectByExample(example);
        }catch (Exception e){
            return new ActivityListResult(500,e.getMessage(),null);
        }
        return new ActivityListResult(200,"OK",list);
    }

    @Override
    public ActivityListResult getMyJoinedActivities(String uid) {

        List<Activity> activityList;

        ParticipateactivityExample example = new ParticipateactivityExample();
        ParticipateactivityExample.Criteria criteria = example.createCriteria();
        criteria.andUidEqualTo(Long.parseLong(uid));
        try {
            List<Participateactivity> list= participateactivityMapper.selectByExample(example);
            List<Integer> avidlist = new ArrayList<>();
            for (Participateactivity pav:list){
                avidlist.add(pav.getAvid());
            }
            activityList = selectActivities(avidlist);
        }catch (Exception e){
            return new ActivityListResult(500,e.getMessage(),null);
        }

        return new ActivityListResult(200,"OK",activityList);
    }

    @Override
    public ActivityListResult getMyCollectedActivities(String uid) {

        ActivitycollectionExample activitycollectionExample = new ActivitycollectionExample();
        ActivitycollectionExample.Criteria criteria = activitycollectionExample.createCriteria();
        criteria.andUidEqualTo(Long.parseLong(uid));
        List<Activity> activityList;
        try {
            List<ActivitycollectionKey> activitycollectionKeys = activitycollectionMapper.selectByExample(activitycollectionExample);
            List<Integer> avidlist = new ArrayList<>();
            for (ActivitycollectionKey activitycollectionKey:activitycollectionKeys){
                avidlist.add(activitycollectionKey.getAvid());
            }

            activityList = selectActivities(avidlist);
        }catch (Exception e){
            return new ActivityListResult(500,e.getMessage(),null);
        }
        return new ActivityListResult(200,"OK",activityList);

    }

    @Override
    public PhoneListResult getParticipatorPhoneList(int avid) {

        ParticipateactivityExample participateactivityExample = new ParticipateactivityExample();
        ParticipateactivityExample.Criteria criteria = participateactivityExample.createCriteria();
        criteria.andAvidEqualTo(avid);
        List<Long> phonelist = new ArrayList<>();
        try {
            List<Participateactivity> list = participateactivityMapper.selectByExample(participateactivityExample);
            for(Participateactivity participateactivity:list){
                phonelist.add(participateactivity.getUid());
            }
        }catch (Exception e){
            return new PhoneListResult(500,e.getMessage(),null);
        }


        return new PhoneListResult(200,"OK",phonelist);
    }

    @Override
    public UserListResult getParticipatorMemberList(int avid) {
        ParticipateactivityExample participateactivityExample = new ParticipateactivityExample();
        ParticipateactivityExample.Criteria criteria = participateactivityExample.createCriteria();
        criteria.andAvidEqualTo(avid);
        List<Long> phonelist = new ArrayList<>();
        List<Userinfo> userinfos = new ArrayList<>();
        try {
            List<Participateactivity> list = participateactivityMapper.selectByExample(participateactivityExample);
            for(Participateactivity participateactivity:list){
                phonelist.add(participateactivity.getUid());
            }
            userinfos = userInfoService.getParticipatorList(phonelist).getData();
        }catch (Exception e){
            return new UserListResult(500,e.getMessage(),null);
        }
        return new UserListResult(200,"OK",userinfos);
    }

    @Override
    public RequestResult deleteActivity(int avid,String uid) {

        if (!activityMapper.selectByPrimaryKey(avid).getUid().toString().equals(uid)){
            return new RequestResult(401,"faild","没有权限删除活动");
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
            return new RequestResult(401,"faild","没有权限修改活动");
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

        if (activity.getAvState() == null){
            activity.setAvState(0);
        }

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
            return new RequestResult(401,"faild","没有权限发起签到");
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
    public RequestResult autoCloseFinishedActivities() {

        // 获取一天前的时间
        Date date =new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(calendar.DATE,-1);
        date = calendar.getTime();

        ActivityExample example = new ActivityExample();
        ActivityExample.Criteria criteria = example.createCriteria();
        criteria.andAvEndtimeLessThanOrEqualTo(date);

        Activity activity = new Activity();
        activity.setAvRegister(-1);

        List<Activity> activityList = activityMapper.selectByExample(example);
        List<Integer> avid = new ArrayList<>();
        for(Activity activity1:activityList){
            closeFinishedActivity(activity1.getAvid());
        }

        return null;
    }

    @Override
    public ActivityListResult searchActivities(String keyword,Integer page,Integer rows) {

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

        ActivityExample example = new ActivityExample();
        ActivityExample.Criteria criteria = example.createCriteria();
        criteria.andAvTitleLike("%"+keyword+"%");
        List<Activity> list;
        try {
            PageHelper.startPage(page,rows);
            list = activityMapper.selectByExample(example);
        }catch (Exception e){
            return new ActivityListResult(500,e.getMessage(),null);
        }

        return new ActivityListResult(200,"OK",list);
    }

    /**
     * 只有发起活动这才有资格结束活动，在调用接口前需要做权限判断
     * @param avid 活动 ID
     * @return  200 400 500
     */
    @Override
    public RequestResult closeFinishedActivity(int avid) {

        int flag = 0;
        Activity activity = new Activity();
        activity.setAvid(avid);
        activity.setAvRegister(-1);
        try {
           flag= activityMapper.updateByPrimaryKeySelective(activity);
        }catch (Exception e){
            return new RequestResult(500,"faild",e.getMessage());
        }
        if (flag == 0){
            return new RequestResult(400,"faild","没有活动被关闭");
        }

        ParticipateactivityExample example = new ParticipateactivityExample();
        ParticipateactivityExample.Criteria criteria = example.createCriteria();
        criteria.andAvidEqualTo(avid);
        List<Participateactivity> participateactivityList = participateactivityMapper.selectByExample(example);
        List<Long> deductuidlist = new ArrayList<>();
        List<Long> increaseuidlist = new ArrayList<>();
        for (Participateactivity participateactivity:participateactivityList){
            if (participateactivity.getVerifystate() == 0){
                deductuidlist.add(participateactivity.getUid());
            }
            if (participateactivity.getVerifystate() == 1){
                increaseuidlist.add(participateactivity.getUid());
            }
        }

        userInfoService.deductReputation(deductuidlist);
        userInfoService.increaseReputation(increaseuidlist);
        if (increaseuidlist.size() > 0){
            userInfoService.correctReputation(increaseuidlist);
        }

        return new RequestResult(200,"OK",null);
    }


    /// 查询一组 id 对应的活动
    private List<Activity> selectActivities(List<Integer> avidlist) throws Exception{
        ActivityExample example = new ActivityExample();
        ActivityExample.Criteria criteria = example.createCriteria();
        criteria.andAvidIn(avidlist);
        return activityMapper.selectByExample(example);
    }
}
