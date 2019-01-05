package com.org.bank.dao;

import com.org.bank.common.ExecuteResult;
import com.org.bank.common.Pager;
import com.org.bank.domain.ExaminationPaperQuestionDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExaminationPaperQuestionDTOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ExaminationPaperQuestionDTO record);

    int insertSelective(ExaminationPaperQuestionDTO record);

    ExaminationPaperQuestionDTO selectByPrimaryKey(Integer id);

    List<ExaminationPaperQuestionDTO> selectList(@Param("record") ExaminationPaperQuestionDTO record, @Param("pager") Pager pager);

    Long countTotal(@Param("record") ExaminationPaperQuestionDTO record);

    int updateByPrimaryKeySelective(ExaminationPaperQuestionDTO record);

    int updateByPrimaryKey(ExaminationPaperQuestionDTO record);

    int insertList(@Param("records") List<ExaminationPaperQuestionDTO> records);

}