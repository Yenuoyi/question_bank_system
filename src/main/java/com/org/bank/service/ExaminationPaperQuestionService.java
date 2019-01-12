package com.org.bank.service;


import com.org.bank.common.DataUtil;
import com.org.bank.common.ExecuteResult;
import com.org.bank.common.Pager;
import com.org.bank.domain.ExaminationPaperQuestionDTO;

import java.util.List;

public interface ExaminationPaperQuestionService {
    ExecuteResult<Integer> deleteByPrimaryKey(ExaminationPaperQuestionDTO record);

    ExecuteResult<Integer> deleteByPaperId(ExaminationPaperQuestionDTO record);

    ExecuteResult<Integer> insert(ExaminationPaperQuestionDTO record);

    ExecuteResult<Integer> insertSelective(ExaminationPaperQuestionDTO record);

    ExecuteResult<ExaminationPaperQuestionDTO> selectByPrimaryKey(ExaminationPaperQuestionDTO record);

    ExecuteResult<DataUtil<ExaminationPaperQuestionDTO>> selectList(ExaminationPaperQuestionDTO record, Pager pager);

    ExecuteResult<Integer> updateByPrimaryKeySelective(ExaminationPaperQuestionDTO record);

    ExecuteResult<Integer> updateByPrimaryKey(ExaminationPaperQuestionDTO record);

    ExecuteResult<Integer> insertList(List<ExaminationPaperQuestionDTO> records);

}