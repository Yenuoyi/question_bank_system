package com.org.bank.service;


import com.org.bank.common.DataUtil;
import com.org.bank.common.ExecuteResult;
import com.org.bank.common.Pager;
import com.org.bank.domain.GradSheetDTO;

public interface GradSheetService {
    ExecuteResult<Integer> deleteByPrimaryKey(GradSheetDTO record);

    ExecuteResult<Integer> insert(GradSheetDTO record);

    ExecuteResult<Integer> insertSelective(GradSheetDTO record);

    ExecuteResult<GradSheetDTO> selectByPrimaryKey(GradSheetDTO record);

    ExecuteResult<DataUtil<GradSheetDTO>> selectList(GradSheetDTO record, Pager pager);

    ExecuteResult<Integer> updateByPrimaryKeySelective(GradSheetDTO record);

    ExecuteResult<Integer> updateByPrimaryKey(GradSheetDTO record);
}