package com.org.bank.service;


import com.org.bank.domain.TrueFalseQuestionDTO;

public interface TrueFalseQuestionService {
    int deleteByPrimaryKey(Integer id);

    int insert(TrueFalseQuestionDTO record);

    int insertSelective(TrueFalseQuestionDTO record);

    TrueFalseQuestionDTO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TrueFalseQuestionDTO record);

    int updateByPrimaryKey(TrueFalseQuestionDTO record);
}