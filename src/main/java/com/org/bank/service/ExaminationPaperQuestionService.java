package com.org.bank.service;


import com.org.bank.domain.ExaminationPaperQuestionDTO;

public interface ExaminationPaperQuestionService {
    int deleteByPrimaryKey(Integer id);

    int insert(ExaminationPaperQuestionDTO record);

    int insertSelective(ExaminationPaperQuestionDTO record);

    ExaminationPaperQuestionDTO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ExaminationPaperQuestionDTO record);

    int updateByPrimaryKey(ExaminationPaperQuestionDTO record);
}