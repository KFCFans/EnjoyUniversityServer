package com.eu.service;

import com.eu.pojo.Bug;
import com.eu.pojo.BugListResult;
import com.eu.pojo.RequestResult;
import com.eu.pojo.SerchNumResult;

import java.util.List;

/**
 * Created by lip on 17/3/31.
 */
public interface CommonService {

    // 用户提交 BUG 接口
    public RequestResult reportBugOrProblem(String uid,String bug,String contactinfo);

    // 开发者查看反馈接口
    public BugListResult getBugOrProblem();

    // 获取搜索结果个数
    public SerchNumResult getSearchResultNum(String keyword);


}
