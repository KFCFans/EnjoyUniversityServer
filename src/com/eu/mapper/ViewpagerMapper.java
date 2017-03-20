package com.eu.mapper;

import com.eu.pojo.Viewpager;
import com.eu.pojo.ViewpagerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ViewpagerMapper {

    public List<Viewpager> selectViewPagers();

}