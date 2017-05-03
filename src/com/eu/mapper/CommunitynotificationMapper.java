package com.eu.mapper;

import com.eu.pojo.Communitynotification;
import com.eu.pojo.CommunitynotificationExample;
import com.eu.pojo.CommunitynotificationKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommunitynotificationMapper {
    int countByExample(CommunitynotificationExample example);

    int deleteByExample(CommunitynotificationExample example);

    int deleteByPrimaryKey(CommunitynotificationKey key);

    int insert(Communitynotification record);

    int insertSelective(Communitynotification record);

    List<Communitynotification> selectByExample(CommunitynotificationExample example);

    Communitynotification selectByPrimaryKey(CommunitynotificationKey key);

    int updateByExampleSelective(@Param("record") Communitynotification record, @Param("example") CommunitynotificationExample example);

    int updateByExample(@Param("record") Communitynotification record, @Param("example") CommunitynotificationExample example);

    int updateByPrimaryKeySelective(Communitynotification record);

    int updateByPrimaryKey(Communitynotification record);
}