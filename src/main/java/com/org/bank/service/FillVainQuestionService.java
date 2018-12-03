package com.org.bank.service;


import com.org.bank.domain.FillVainQuestionDTO;

public interface FillVainQuestionService {
    int deleteByPrimaryKey(Integer id);

    int insert(FillVainQuestionDTO record);

    int insertSelective(FillVainQuestionDTO record);

    FillVainQuestionDTO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FillVainQuestionDTO record);

    int updateByPrimaryKey(FillVainQuestionDTO record);
}