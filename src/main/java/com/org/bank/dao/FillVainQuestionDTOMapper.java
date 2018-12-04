package com.org.bank.dao;

import com.org.bank.common.Pager;
import com.org.bank.domain.FillVainQuestionDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FillVainQuestionDTOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FillVainQuestionDTO record);

    int insertSelective(FillVainQuestionDTO record);

    FillVainQuestionDTO selectByPrimaryKey(Integer id);

    List<FillVainQuestionDTO> selectList(@Param("record") FillVainQuestionDTO record, @Param("pager") Pager pager);

    Integer countTotal(FillVainQuestionDTO record);

    int updateByPrimaryKeySelective(FillVainQuestionDTO record);

    int updateByPrimaryKey(FillVainQuestionDTO record);
}