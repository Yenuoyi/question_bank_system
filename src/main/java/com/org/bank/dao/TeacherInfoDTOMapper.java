package com.org.bank.dao;

import com.org.bank.common.Pager;
import com.org.bank.domain.TeacherInfoDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherInfoDTOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TeacherInfoDTO record);

    int insertSelective(TeacherInfoDTO record);

    TeacherInfoDTO selectByPrimaryKey(Integer id);

    List<TeacherInfoDTO> selectList(@Param("record")TeacherInfoDTO teacherInfoDTO, @Param("pager")Pager pager);

    Integer countTotal(TeacherInfoDTO record);

    int updateByPrimaryKeySelective(TeacherInfoDTO record);

    int updateByPrimaryKey(TeacherInfoDTO record);
}