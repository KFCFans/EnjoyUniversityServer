package com.eu.mapper;

import com.eu.pojo.ActivitycollectionExample;
import com.eu.pojo.ActivitycollectionKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ActivitycollectionMapper {
    int countByExample(ActivitycollectionExample example);

    int deleteByExample(ActivitycollectionExample example);

    int deleteByPrimaryKey(ActivitycollectionKey key);

    int insert(ActivitycollectionKey record);

    int insertSelective(ActivitycollectionKey record);

    List<ActivitycollectionKey> selectByExample(ActivitycollectionExample example);

    int updateByExampleSelective(@Param("record") ActivitycollectionKey record, @Param("example") ActivitycollectionExample example);

    int updateByExample(@Param("record") ActivitycollectionKey record, @Param("example") ActivitycollectionExample example);
}