package com.eu.mapper;

import com.eu.pojo.Activitynotification;
import com.eu.pojo.ActivitynotificationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ActivitynotificationMapper {
    int countByExample(ActivitynotificationExample example);

    int deleteByExample(ActivitynotificationExample example);

    int insert(Activitynotification record);

    int insertSelective(Activitynotification record);

    List<Activitynotification> selectByExample(ActivitynotificationExample example);

    int updateByExampleSelective(@Param("record") Activitynotification record, @Param("example") ActivitynotificationExample example);

    int updateByExample(@Param("record") Activitynotification record, @Param("example") ActivitynotificationExample example);
}