package com.org.bank.dao;

import com.org.bank.domain.ShortAnswerQuestionDTO;

public interface ShortAnswerQuestionDTOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ShortAnswerQuestionDTO record);

    int insertSelective(ShortAnswerQuestionDTO record);

    ShortAnswerQuestionDTO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ShortAnswerQuestionDTO record);

    int updateByPrimaryKey(ShortAnswerQuestionDTO record);
}