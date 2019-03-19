package com.org.bank.dao;

import com.org.bank.common.Pager;
import com.org.bank.domain.TrueFalseQuestionDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrueFalseQuestionDTOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TrueFalseQuestionDTO record);

    int insertSelective(TrueFalseQuestionDTO record);

    TrueFalseQuestionDTO selectByPrimaryKey(Integer id);

    List<TrueFalseQuestionDTO> selectList(@Param("record") TrueFalseQuestionDTO record, @Param("pager") Pager pager);

    List<TrueFalseQuestionDTO> randomSelectTrueFalseQuestionList(@Param("record") TrueFalseQuestionDTO record, @Param("pager") Pager pager);

    List<TrueFalseQuestionDTO> selectByPrimaryKeyList(@Param("keys") List<Integer> keys);

    Long countTotal(@Param("record") TrueFalseQuestionDTO record);

    int updateByPrimaryKeySelective(TrueFalseQuestionDTO record);

    int updateByPrimaryKey(TrueFalseQuestionDTO record);
}