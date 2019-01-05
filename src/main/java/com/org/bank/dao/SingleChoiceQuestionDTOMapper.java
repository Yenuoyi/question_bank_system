package com.org.bank.dao;

import com.org.bank.common.Pager;
import com.org.bank.domain.SingleChoiceQuestionDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SingleChoiceQuestionDTOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert( SingleChoiceQuestionDTO record);

    int insertSelective(SingleChoiceQuestionDTO record);

    SingleChoiceQuestionDTO selectByPrimaryKey(Integer id);

    List<SingleChoiceQuestionDTO> selectList(@Param("record") SingleChoiceQuestionDTO record, @Param("pager") Pager pager);

    List<SingleChoiceQuestionDTO> randomSelectSingleChoiceQuestionList(@Param("pager") Pager pager);

    List<SingleChoiceQuestionDTO> selectByPrimaryKeyList(@Param("keys") List<Integer> keys);

    Long countTotal(@Param("record") SingleChoiceQuestionDTO record);

    int updateByPrimaryKeySelective(SingleChoiceQuestionDTO record);

    int updateByPrimaryKey( SingleChoiceQuestionDTO record);
}