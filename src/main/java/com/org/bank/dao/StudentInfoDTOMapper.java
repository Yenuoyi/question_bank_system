package com.org.bank.dao;

import com.org.bank.domain.StudentInfoDTO;

public interface StudentInfoDTOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StudentInfoDTO record);

    int insertSelective(StudentInfoDTO record);

    StudentInfoDTO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StudentInfoDTO record);

    int updateByPrimaryKey(StudentInfoDTO record);
}