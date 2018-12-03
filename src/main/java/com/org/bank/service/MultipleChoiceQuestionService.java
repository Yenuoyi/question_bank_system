package com.org.bank.service;


import com.org.bank.domain.MultipleChoiceQuestionDTO;

public interface MultipleChoiceQuestionService {
    int deleteByPrimaryKey(Integer id);

    int insert(MultipleChoiceQuestionDTO record);

    int insertSelective(MultipleChoiceQuestionDTO record);

    MultipleChoiceQuestionDTO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MultipleChoiceQuestionDTO record);

    int updateByPrimaryKey(MultipleChoiceQuestionDTO record);
}