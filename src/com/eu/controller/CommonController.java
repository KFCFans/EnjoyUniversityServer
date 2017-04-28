package com.eu.controller;

import com.eu.pojo.BugListResult;
import com.eu.pojo.RequestResult;
import com.eu.pojo.SerchNumResult;
import com.eu.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lip on 17/3/31.
 */

@Controller
@RequestMapping("/common")
public class CommonController {

    @Autowired
    private CommonService commonService;

    @RequestMapping("/bugreport")
    @ResponseBody
    public RequestResult reportBug(String bug,String uid,String contactinfo){

        return commonService.reportBugOrProblem(uid,bug,contactinfo);
    }

    @RequestMapping("/buginfo")
    @ResponseBody
    public BugListResult getBugs(){
        return commonService.getBugOrProblem();
    }

    @RequestMapping("/searchnum")
    @ResponseBody
    public SerchNumResult getSearchNum(String keyword){
        return commonService.getSearchResultNum(keyword);
    }

}
