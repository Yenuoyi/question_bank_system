package com.org.bank.service;


import com.org.bank.domain.SingleChoiceQuestionDTO;

public interface SingleChoiceQuestionService {
    int deleteByPrimaryKey(Integer id);

    int insert(SingleChoiceQuestionDTO record);

    int insertSelective(SingleChoiceQuestionDTO record);

    SingleChoiceQuestionDTO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SingleChoiceQuestionDTO record);

    int updateByPrimaryKey(SingleChoiceQuestionDTO record);
}