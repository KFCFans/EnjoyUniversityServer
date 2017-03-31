package com.eu.mapper;

import com.eu.pojo.Bug;
import com.eu.pojo.BugExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BugMapper {
    int countByExample(BugExample example);

    int deleteByExample(BugExample example);

    int deleteByPrimaryKey(Long uid);

    int insert(Bug record);

    int insertSelective(Bug record);

    List<Bug> selectByExample(BugExample example);

    Bug selectByPrimaryKey(Long uid);

    int updateByExampleSelective(@Param("record") Bug record, @Param("example") BugExample example);

    int updateByExample(@Param("record") Bug record, @Param("example") BugExample example);

    int updateByPrimaryKeySelective(Bug record);

    int updateByPrimaryKey(Bug record);
}