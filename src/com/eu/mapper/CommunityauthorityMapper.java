package com.eu.mapper;

import com.eu.pojo.Communityauthority;
import com.eu.pojo.CommunityauthorityExample;
import com.eu.pojo.CommunityauthorityKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommunityauthorityMapper {
    int countByExample(CommunityauthorityExample example);

    int deleteByExample(CommunityauthorityExample example);

    int deleteByPrimaryKey(CommunityauthorityKey key);

    int insert(Communityauthority record);

    int insertSelective(Communityauthority record);

    List<Communityauthority> selectByExample(CommunityauthorityExample example);

    Communityauthority selectByPrimaryKey(CommunityauthorityKey key);

    int updateByExampleSelective(@Param("record") Communityauthority record, @Param("example") CommunityauthorityExample example);

    int updateByExample(@Param("record") Communityauthority record, @Param("example") CommunityauthorityExample example);

    int updateByPrimaryKeySelective(Communityauthority record);

    int updateByPrimaryKey(Communityauthority record);
}