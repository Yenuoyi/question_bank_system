package com.org.bank.service;


import com.org.bank.domain.GradSheetDTO;

public interface GradSheetService {
    int deleteByPrimaryKey(Integer id);

    int insert(GradSheetDTO record);

    int insertSelective(GradSheetDTO record);

    GradSheetDTO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GradSheetDTO record);

    int updateByPrimaryKey(GradSheetDTO record);
}