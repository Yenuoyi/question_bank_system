package com.org.bank.service;


import com.org.bank.common.DataUtil;
import com.org.bank.common.ExecuteResult;
import com.org.bank.common.Pager;
import com.org.bank.domain.ShortAnswerQuestionDTO;

import java.util.List;

public interface ShortAnswerQuestionService {
    ExecuteResult<Integer> deleteByPrimaryKey(ShortAnswerQuestionDTO record);

    ExecuteResult<Integer> insert(ShortAnswerQuestionDTO record);

    ExecuteResult<Integer> insertSelective(ShortAnswerQuestionDTO record);

    ExecuteResult<ShortAnswerQuestionDTO> selectByPrimaryKey(ShortAnswerQuestionDTO record);

    ExecuteResult<DataUtil<ShortAnswerQuestionDTO>> selectList(ShortAnswerQuestionDTO record, Pager pager);

    ExecuteResult<DataUtil<ShortAnswerQuestionDTO>> randomSelectShortAnswerQuestionList(Pager pager);

    ExecuteResult<DataUtil<ShortAnswerQuestionDTO>> selectByPrimaryKeyList(List<Integer> keys);

    ExecuteResult<Integer> updateByPrimaryKeySelective(ShortAnswerQuestionDTO record);

    ExecuteResult<Integer> updateByPrimaryKey(ShortAnswerQuestionDTO record);
}