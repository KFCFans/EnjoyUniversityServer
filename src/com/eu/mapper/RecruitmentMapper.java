package com.eu.mapper;

import com.eu.pojo.Recruitment;
import com.eu.pojo.RecruitmentExample;
import com.eu.pojo.RecruitmentKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RecruitmentMapper {
    int countByExample(RecruitmentExample example);

    int deleteByExample(RecruitmentExample example);

    int deleteByPrimaryKey(RecruitmentKey key);

    int insert(Recruitment record);

    int insertSelective(Recruitment record);

    List<Recruitment> selectByExample(RecruitmentExample example);

    Recruitment selectByPrimaryKey(RecruitmentKey key);

    int updateByExampleSelective(@Param("record") Recruitment record, @Param("example") RecruitmentExample example);

    int updateByExample(@Param("record") Recruitment record, @Param("example") RecruitmentExample example);

    int updateByPrimaryKeySelective(Recruitment record);

    int updateByPrimaryKey(Recruitment record);
}