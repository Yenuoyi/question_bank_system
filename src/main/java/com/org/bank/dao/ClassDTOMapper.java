package com.org.bank.dao;


import com.org.bank.domain.ClassDTO;

public interface ClassDTOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ClassDTO record);

    int insertSelective(ClassDTO record);

    ClassDTO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ClassDTO record);

    int updateByPrimaryKey(ClassDTO record);
}