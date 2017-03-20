package com.eu.mapper;

import com.eu.pojo.Participateactivity;
import com.eu.pojo.ParticipateactivityExample;
import com.eu.pojo.ParticipateactivityKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ParticipateactivityMapper {
    int countByExample(ParticipateactivityExample example);

    int deleteByExample(ParticipateactivityExample example);

    int deleteByPrimaryKey(ParticipateactivityKey key);

    int insert(Participateactivity record);

    int insertSelective(Participateactivity record);

    List<Participateactivity> selectByExample(ParticipateactivityExample example);

    Participateactivity selectByPrimaryKey(ParticipateactivityKey key);

    int updateByExampleSelective(@Param("record") Participateactivity record, @Param("example") ParticipateactivityExample example);

    int updateByExample(@Param("record") Participateactivity record, @Param("example") ParticipateactivityExample example);

    int updateByPrimaryKeySelective(Participateactivity record);

    int updateByPrimaryKey(Participateactivity record);
}