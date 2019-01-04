package com.org.bank.service;


import com.org.bank.common.DataUtil;
import com.org.bank.common.ExecuteResult;
import com.org.bank.common.Pager;
import com.org.bank.domain.SingleChoiceQuestionDTO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface SingleChoiceQuestionService {
    ExecuteResult<Integer> deleteByPrimaryKey(SingleChoiceQuestionDTO record);

    ExecuteResult<Integer> insert(SingleChoiceQuestionDTO record);

    ExecuteResult<Integer> insertSelective(SingleChoiceQuestionDTO record);

    ExecuteResult<SingleChoiceQuestionDTO> selectByPrimaryKey(SingleChoiceQuestionDTO record);

    ExecuteResult<DataUtil<SingleChoiceQuestionDTO>> selectList(SingleChoiceQuestionDTO record, Pager pager);

    ExecuteResult<DataUtil<SingleChoiceQuestionDTO>> randomSelectSingleChoiceQuestionList(Pager pager);

    ExecuteResult<DataUtil<SingleChoiceQuestionDTO>> selectByPrimaryKeyList(List<Integer> keys);

    ExecuteResult<DataUtil<SingleChoiceQuestionDTO>> checkExercise(List<SingleChoiceQuestionDTO> record, HttpServletRequest httpServletRequest);

    ExecuteResult<Integer> updateByPrimaryKeySelective(SingleChoiceQuestionDTO record);

    ExecuteResult<Integer> updateByPrimaryKey(SingleChoiceQuestionDTO record);
}