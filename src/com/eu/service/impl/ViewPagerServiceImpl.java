package com.eu.service.impl;

import com.eu.mapper.ViewpagerMapper;
import com.eu.pojo.RequestResult;
import com.eu.pojo.Viewpager;
import com.eu.service.ViewPagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lip on 17/3/20.
 */
@Service
public class ViewPagerServiceImpl implements ViewPagerService {

    @Autowired
    public ViewpagerMapper viewpagerMapper;

    @Override
    public List<Viewpager> getViewPagers() {

        return viewpagerMapper.selectViewPagers();
    }

    /**
     * 批量增加 ViewPager
     * @param url
     * @return
     */
    @Override
    public RequestResult addViewPagers(String url) {
        return null;
    }

    @Override
    public RequestResult removeViewPagers(String url) {
        return null;
    }
}
