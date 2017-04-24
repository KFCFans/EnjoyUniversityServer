package com.eu.service.impl;

import com.eu.mapper.*;
import com.eu.pojo.*;
import com.eu.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lip on 17/3/31.
 */
@Service
public class CommonServiceImpl implements CommonService {

    @Autowired
    private BugMapper bugMapper;

    @Autowired
    private MultiTableQueryMapper multiTableQueryMapper;

    @Override
    public RequestResult reportBugOrProblem(String uid,String bug,String contactinfo) {

        Bug b = new Bug();
        b.setProblem(bug);
        b.setUid(Long.parseLong(uid));
        b.setContactinfo(contactinfo);
        try {
            bugMapper.insert(b);
        }catch (Exception e){
            return new RequestResult(500,"faild",e.getMessage());
        }
        return new RequestResult(200,"OK","感谢您的反馈，我们会尽力解决问题！");
    }

    @Override
    public BugListResult getBugOrProblem() {

        BugExample example = new BugExample();

        try {

            return new BugListResult(200,"OK",bugMapper.selectByExample(example));
        }catch (Exception e){
            return new BugListResult(500,e.getMessage(),null);
        }
    }

    @Override
    public RequestResult getSearchResultNum(String keyword) {

        Integer activitynum;
        Integer communitynum;
        Integer usernum;
        try {
            activitynum = multiTableQueryMapper.searchActivityCountByKeyword("%"+keyword+"%");
            communitynum = multiTableQueryMapper.searchCommunityCountByKeyword("%"+keyword+"%");
            usernum = multiTableQueryMapper.searchUserCountByKeyword("%"+keyword+"%");
        }catch (Exception e){
            return new RequestResult(500,e.getMessage(),null);
        }
        // 拼接 json
        String resultdata = "{\"activityNum\":"+activitynum+",\"communityNum\":"+communitynum+",\"userNum\":"+usernum+"}";
        return new RequestResult(200,"OK",resultdata);
    }
}
