package com.org.bank.service;


import com.org.bank.common.DataUtil;
import com.org.bank.common.ExecuteResult;
import com.org.bank.common.Pager;
import com.org.bank.domain.MultipleChoiceQuestionDTO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface MultipleChoiceQuestionService {
    ExecuteResult<Integer> deleteByPrimaryKey(MultipleChoiceQuestionDTO record);

    ExecuteResult<Integer> insert(MultipleChoiceQuestionDTO record);

    ExecuteResult<Integer> insertSelective(MultipleChoiceQuestionDTO record);

    ExecuteResult<MultipleChoiceQuestionDTO> selectByPrimaryKey(MultipleChoiceQuestionDTO record);

    ExecuteResult<DataUtil<MultipleChoiceQuestionDTO>> selectList(MultipleChoiceQuestionDTO record, Pager pager);

    ExecuteResult<DataUtil<MultipleChoiceQuestionDTO>> randomSelectMultipleChoiceQuestionList(MultipleChoiceQuestionDTO record, Pager pager);

    ExecuteResult<DataUtil<MultipleChoiceQuestionDTO>> selectByPrimaryKeyList(List<Integer> keys);

    ExecuteResult<DataUtil<MultipleChoiceQuestionDTO>> checkExercise(List<MultipleChoiceQuestionDTO> record, HttpServletRequest httpServletRequest);

    ExecuteResult<Integer> updateByPrimaryKeySelective(MultipleChoiceQuestionDTO record);

    ExecuteResult<Integer> updateByPrimaryKey(MultipleChoiceQuestionDTO record);
}