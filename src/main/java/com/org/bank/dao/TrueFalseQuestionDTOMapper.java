package com.org.bank.dao;

import com.org.bank.domain.TrueFalseQuestionDTO;

public interface TrueFalseQuestionDTOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TrueFalseQuestionDTO record);

    int insertSelective(TrueFalseQuestionDTO record);

    TrueFalseQuestionDTO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TrueFalseQuestionDTO record);

    int updateByPrimaryKey(TrueFalseQuestionDTO record);
}