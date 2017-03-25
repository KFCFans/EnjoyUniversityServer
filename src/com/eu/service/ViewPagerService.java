package com.eu.service;

import com.eu.pojo.RequestResult;
import com.eu.pojo.Viewpager;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by lip on 17/3/20.
 */
public interface ViewPagerService {

    public List<Viewpager> getViewPagers();

    public RequestResult addViewPagers(String url);

    public RequestResult removeViewPagers(String url);

}
