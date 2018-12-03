package com.org.bank.dao;

import com.org.bank.domain.GradSheetDTO;

public interface GradSheetDTOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GradSheetDTO record);

    int insertSelective(GradSheetDTO record);

    GradSheetDTO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GradSheetDTO record);

    int updateByPrimaryKey(GradSheetDTO record);
}