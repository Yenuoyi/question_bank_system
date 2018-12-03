package com.org.bank.dao;

import com.org.bank.domain.FillVainQuestionDTO;

public interface FillVainQuestionDTOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FillVainQuestionDTO record);

    int insertSelective(FillVainQuestionDTO record);

    FillVainQuestionDTO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FillVainQuestionDTO record);

    int updateByPrimaryKey(FillVainQuestionDTO record);
}