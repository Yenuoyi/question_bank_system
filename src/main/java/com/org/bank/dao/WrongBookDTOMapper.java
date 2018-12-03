package com.org.bank.dao;

import com.org.bank.domain.WrongBookDTO;

public interface WrongBookDTOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WrongBookDTO record);

    int insertSelective(WrongBookDTO record);

    WrongBookDTO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WrongBookDTO record);

    int updateByPrimaryKey(WrongBookDTO record);
}