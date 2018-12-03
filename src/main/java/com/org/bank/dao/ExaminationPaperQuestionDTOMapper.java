package com.org.bank.dao;

import com.org.bank.domain.ExaminationPaperQuestionDTO;

public interface ExaminationPaperQuestionDTOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ExaminationPaperQuestionDTO record);

    int insertSelective(ExaminationPaperQuestionDTO record);

    ExaminationPaperQuestionDTO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ExaminationPaperQuestionDTO record);

    int updateByPrimaryKey(ExaminationPaperQuestionDTO record);
}