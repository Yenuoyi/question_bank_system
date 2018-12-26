package com.org.bank.dao;

import com.org.bank.common.Pager;
import com.org.bank.domain.AnswerSheetAnswerDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AnswerSheetAnswerDTOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AnswerSheetAnswerDTO record);

    int insertSelective(AnswerSheetAnswerDTO record);

    AnswerSheetAnswerDTO selectByPrimaryKey(Integer id);

    List<AnswerSheetAnswerDTO> selectList(@Param("record") AnswerSheetAnswerDTO record, @Param("pager") Pager pager);

    Long countTotal(AnswerSheetAnswerDTO record);

    int updateByPrimaryKeySelective(AnswerSheetAnswerDTO record);

    int updateByPrimaryKey(AnswerSheetAnswerDTO record);
}