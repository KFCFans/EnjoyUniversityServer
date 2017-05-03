package com.eu.mapper;

import com.eu.pojo.Systemnotification;
import com.eu.pojo.SystemnotificationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SystemnotificationMapper {
    int countByExample(SystemnotificationExample example);

    int deleteByExample(SystemnotificationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Systemnotification record);

    int insertSelective(Systemnotification record);

    List<Systemnotification> selectByExample(SystemnotificationExample example);

    Systemnotification selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Systemnotification record, @Param("example") SystemnotificationExample example);

    int updateByExample(@Param("record") Systemnotification record, @Param("example") SystemnotificationExample example);

    int updateByPrimaryKeySelective(Systemnotification record);

    int updateByPrimaryKey(Systemnotification record);
}