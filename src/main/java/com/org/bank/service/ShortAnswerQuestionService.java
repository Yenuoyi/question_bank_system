package com.org.bank.service;


import com.org.bank.domain.ShortAnswerQuestionDTO;

public interface ShortAnswerQuestionService {
    int deleteByPrimaryKey(Integer id);

    int insert(ShortAnswerQuestionDTO record);

    int insertSelective(ShortAnswerQuestionDTO record);

    ShortAnswerQuestionDTO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ShortAnswerQuestionDTO record);

    int updateByPrimaryKey(ShortAnswerQuestionDTO record);
}