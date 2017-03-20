package com.eu.mapper;

import com.eu.pojo.CommunitycollectionExample;
import com.eu.pojo.CommunitycollectionKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommunitycollectionMapper {
    int countByExample(CommunitycollectionExample example);

    int deleteByExample(CommunitycollectionExample example);

    int deleteByPrimaryKey(CommunitycollectionKey key);

    int insert(CommunitycollectionKey record);

    int insertSelective(CommunitycollectionKey record);

    List<CommunitycollectionKey> selectByExample(CommunitycollectionExample example);

    int updateByExampleSelective(@Param("record") CommunitycollectionKey record, @Param("example") CommunitycollectionExample example);

    int updateByExample(@Param("record") CommunitycollectionKey record, @Param("example") CommunitycollectionExample example);
}