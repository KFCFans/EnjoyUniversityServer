package com.eu.service.impl;

import com.eu.mapper.ViewpagerMapper;
import com.eu.pojo.Viewpager;
import com.eu.pojo.ViewpagerExample;
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
}
