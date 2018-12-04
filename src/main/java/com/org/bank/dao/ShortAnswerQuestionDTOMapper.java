package com.org.bank.dao;

import com.org.bank.common.Pager;
import com.org.bank.domain.ShortAnswerQuestionDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShortAnswerQuestionDTOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ShortAnswerQuestionDTO record);

    int insertSelective(ShortAnswerQuestionDTO record);

    ShortAnswerQuestionDTO selectByPrimaryKey(Integer id);

    List<ShortAnswerQuestionDTO> selectList(@Param("record") ShortAnswerQuestionDTO record, @Param("pager") Pager pager);

    Integer countTotal(ShortAnswerQuestionDTO record);

    int updateByPrimaryKeySelective(ShortAnswerQuestionDTO record);

    int updateByPrimaryKey(ShortAnswerQuestionDTO record);
}