package com.org.bank.service;

import com.org.bank.common.DataUtil;
import com.org.bank.common.ExecuteResult;
import com.org.bank.common.Pager;
import com.org.bank.domain.AnswerSheetAnswerDTO;

import java.util.List;

public interface AnswerSheetAnswerService {
    ExecuteResult<Integer> deleteByPrimaryKey(AnswerSheetAnswerDTO record);

    ExecuteResult<Integer> insert(AnswerSheetAnswerDTO record);

    ExecuteResult<Integer> insertSelective(AnswerSheetAnswerDTO record);

    ExecuteResult<AnswerSheetAnswerDTO> selectByPrimaryKey(AnswerSheetAnswerDTO record);

    ExecuteResult<DataUtil<AnswerSheetAnswerDTO>> selectList(AnswerSheetAnswerDTO record, Pager pager);

    ExecuteResult<Integer> updateByPrimaryKeySelective(AnswerSheetAnswerDTO record);

    ExecuteResult<Integer> updateByPrimaryKey(AnswerSheetAnswerDTO record);

    /**
     * 批量插入
     * @param records
     * @return
     */
    ExecuteResult<Integer> insertList(List<AnswerSheetAnswerDTO> records);
}
