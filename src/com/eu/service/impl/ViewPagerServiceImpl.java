package com.eu.service.impl;

import com.eu.mapper.ViewpagerMapper;
import com.eu.pojo.RequestResult;
import com.eu.pojo.ViewPagerListResult;
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
    public ViewPagerListResult getViewPagers() {

        try {
            return new ViewPagerListResult(200,"OK",viewpagerMapper.selectViewPagers());
        }catch (Exception e) {
            return new ViewPagerListResult(500, e.getMessage(), null);
        }
    }

    /**
     * 批量增加 ViewPager 暂时不开放此接口，此服务器为用户提供服务，用户无权限更改 ViewPager
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
