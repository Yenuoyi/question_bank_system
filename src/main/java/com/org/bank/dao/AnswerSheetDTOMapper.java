package com.org.bank.dao;

import com.org.bank.common.Pager;
import com.org.bank.domain.AnswerSheetDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerSheetDTOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AnswerSheetDTO record);

    int insertSelective(AnswerSheetDTO record);

    AnswerSheetDTO selectByPrimaryKey(Integer id);

    List<AnswerSheetDTO> selectList(@Param("record") AnswerSheetDTO record, @Param("pager")Pager pager);

    Long countTotal(@Param("record") AnswerSheetDTO record);

    int updateByPrimaryKeySelective(AnswerSheetDTO record);

    int updateByPrimaryKey(AnswerSheetDTO record);

    List<AnswerSheetDTO> selectSheetPaperList(@Param("record") AnswerSheetDTO record, @Param("pager")Pager pager);

    Long countSheetPaperTotal(@Param("record") AnswerSheetDTO record);
}