package com.org.bank.service;

import com.org.bank.common.DataUtil;
import com.org.bank.common.ExecuteResult;
import com.org.bank.common.Pager;
import com.org.bank.domain.AnswerSheetDTO;

public interface AnswerSheetService {
    ExecuteResult<Integer> deleteByPrimaryKey(AnswerSheetDTO record);

    ExecuteResult<Integer> insert(AnswerSheetDTO record);

    ExecuteResult<Integer> insertSelective(AnswerSheetDTO record);

    ExecuteResult<AnswerSheetDTO> selectByPrimaryKey(AnswerSheetDTO record);

    ExecuteResult<DataUtil<AnswerSheetDTO>> selectList(AnswerSheetDTO record, Pager pager);

    ExecuteResult<Integer> updateByPrimaryKeySelective(AnswerSheetDTO record);

    ExecuteResult<Integer> updateByPrimaryKey(AnswerSheetDTO record);
}
