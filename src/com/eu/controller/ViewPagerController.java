package com.eu.controller;

import com.eu.pojo.Viewpager;
import com.eu.service.ViewPagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lip on 17/3/20.
 */

@Controller
public class ViewPagerController {

    @Autowired
    public ViewPagerService viewPagerService;

    @RequestMapping("/viewpager")
    @ResponseBody
    public List<Viewpager> getViewPagers(){


        return viewPagerService.getViewPagers();

    }

}
