package com.org.bank.service;


import com.org.bank.common.DataUtil;
import com.org.bank.common.ExecuteResult;
import com.org.bank.common.Pager;
import com.org.bank.domain.ShortAnswerQuestionDTO;

public interface ShortAnswerQuestionService {
    ExecuteResult<Integer> deleteByPrimaryKey(ShortAnswerQuestionDTO record);

    ExecuteResult<Integer> insert(ShortAnswerQuestionDTO record);

    ExecuteResult<Integer> insertSelective(ShortAnswerQuestionDTO record);

    ExecuteResult<ShortAnswerQuestionDTO> selectByPrimaryKey(ShortAnswerQuestionDTO record);

    ExecuteResult<DataUtil<ShortAnswerQuestionService>> selectList(ShortAnswerQuestionDTO record, Pager pager);

    ExecuteResult<Integer> updateByPrimaryKeySelective(ShortAnswerQuestionDTO record);

    ExecuteResult<Integer> updateByPrimaryKey(ShortAnswerQuestionDTO record);
}