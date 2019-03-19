package com.org.bank.service;


import com.org.bank.common.DataUtil;
import com.org.bank.common.ExecuteResult;
import com.org.bank.common.Pager;
import com.org.bank.domain.FillVainQuestionDTO;

import java.util.List;

public interface FillVainQuestionService {
    ExecuteResult<Integer> deleteByPrimaryKey(FillVainQuestionDTO record);

    ExecuteResult<Integer> insert(FillVainQuestionDTO record);

    ExecuteResult<Integer> insertSelective(FillVainQuestionDTO record);

    ExecuteResult<FillVainQuestionDTO> selectByPrimaryKey(FillVainQuestionDTO record);

    ExecuteResult<DataUtil<FillVainQuestionDTO>> selectList(FillVainQuestionDTO record, Pager pager);

    ExecuteResult<DataUtil<FillVainQuestionDTO>> randomSelectFillVainQuestionList(FillVainQuestionDTO record, Pager pager);

    ExecuteResult<DataUtil<FillVainQuestionDTO>> selectByPrimaryKeyList(List<Integer> keys);

    ExecuteResult<Integer> updateByPrimaryKeySelective(FillVainQuestionDTO record);

    ExecuteResult<Integer> updateByPrimaryKey(FillVainQuestionDTO record);
}