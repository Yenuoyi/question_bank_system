package com.org.bank.service;


import com.org.bank.domain.WrongBookDTO;

public interface WrongBookService {
    int deleteByPrimaryKey(Integer id);

    int insert(WrongBookDTO record);

    int insertSelective(WrongBookDTO record);

    WrongBookDTO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WrongBookDTO record);

    int updateByPrimaryKey(WrongBookDTO record);
}