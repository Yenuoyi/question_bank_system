package com.org.bank.dao;

import com.org.bank.domain.DoubtDTO;

public interface DoubtDTOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DoubtDTO record);

    int insertSelective(DoubtDTO record);

    DoubtDTO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DoubtDTO record);

    int updateByPrimaryKey(DoubtDTO record);
}