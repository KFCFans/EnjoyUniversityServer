package com.eu.mapper;

import com.eu.pojo.Communitynotification;
import com.eu.pojo.CommunitynotificationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommunitynotificationMapper {
    int countByExample(CommunitynotificationExample example);

    int deleteByExample(CommunitynotificationExample example);

    int insert(Communitynotification record);

    int insertSelective(Communitynotification record);

    List<Communitynotification> selectByExample(CommunitynotificationExample example);

    int updateByExampleSelective(@Param("record") Communitynotification record, @Param("example") CommunitynotificationExample example);

    int updateByExample(@Param("record") Communitynotification record, @Param("example") CommunitynotificationExample example);
}