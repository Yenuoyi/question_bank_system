package com.org.bank.dao;


import com.org.bank.domain.MultipleChoiceQuestionDTO;

public interface MultipleChoiceQuestionDTOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MultipleChoiceQuestionDTO record);

    int insertSelective(MultipleChoiceQuestionDTO record);

    MultipleChoiceQuestionDTO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MultipleChoiceQuestionDTO record);

    int updateByPrimaryKey(MultipleChoiceQuestionDTO record);
}