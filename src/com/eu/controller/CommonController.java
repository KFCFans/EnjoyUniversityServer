package com.eu.controller;

import com.eu.pojo.Bug;
import com.eu.pojo.RequestResult;
import com.eu.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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
    public RequestResult reportBug(String bug,String uid){

        return commonService.reportBugOrProblem(uid,bug);
    }

    @RequestMapping("/buginfo")
    @ResponseBody
    public List<Bug> getBugs(){
        return commonService.getBugOrProblem();
    }

}
