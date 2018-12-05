package com.org.bank.dao;


import com.org.bank.common.Pager;
import com.org.bank.domain.MultipleChoiceQuestionDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MultipleChoiceQuestionDTOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MultipleChoiceQuestionDTO record);

    int insertSelective(MultipleChoiceQuestionDTO record);

    MultipleChoiceQuestionDTO selectByPrimaryKey(Integer id);

    List<MultipleChoiceQuestionDTO> selectList(@Param("record") MultipleChoiceQuestionDTO record, @Param("pager") Pager pager);

    Long countTotal(MultipleChoiceQuestionDTO record);

    int updateByPrimaryKeySelective(MultipleChoiceQuestionDTO record);

    int updateByPrimaryKey(MultipleChoiceQuestionDTO record);
}