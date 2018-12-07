package com.org.bank.service;


import com.org.bank.common.DataUtil;
import com.org.bank.common.ExecuteResult;
import com.org.bank.common.Pager;
import com.org.bank.domain.TrueFalseQuestionDTO;

import java.util.List;

public interface TrueFalseQuestionService {
    ExecuteResult<Integer> deleteByPrimaryKey(TrueFalseQuestionDTO record);

    ExecuteResult<Integer> insert(TrueFalseQuestionDTO record);

    ExecuteResult<Integer> insertSelective(TrueFalseQuestionDTO record);

    ExecuteResult<TrueFalseQuestionDTO> selectByPrimaryKey(TrueFalseQuestionDTO record);

    ExecuteResult<DataUtil<TrueFalseQuestionDTO>> selectList(TrueFalseQuestionDTO record, Pager pager);

    ExecuteResult<DataUtil<TrueFalseQuestionDTO>> randomSelectTrueFalseQuestionList(Pager pager);

    ExecuteResult<DataUtil<TrueFalseQuestionDTO>> selectByPrimaryKeyList(List<Integer> keys);

    ExecuteResult<DataUtil<TrueFalseQuestionDTO>> checkExercise(List<TrueFalseQuestionDTO> record);

    ExecuteResult<Integer> updateByPrimaryKeySelective(TrueFalseQuestionDTO record);

    ExecuteResult<Integer> updateByPrimaryKey(TrueFalseQuestionDTO record);
}