package com.org.bank.dao;

import com.org.bank.common.Pager;
import com.org.bank.domain.ExaminationPaperDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExaminationPaperDTOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ExaminationPaperDTO record);

    int insertSelective(ExaminationPaperDTO record);

    ExaminationPaperDTO selectByPrimaryKey(Integer id);

    List<ExaminationPaperDTO> selectList(@Param("record") ExaminationPaperDTO record, @Param("pager") Pager pager);

    Integer countTotal(ExaminationPaperDTO record);

    int updateByPrimaryKeySelective(ExaminationPaperDTO record);

    int updateByPrimaryKey(ExaminationPaperDTO record);
}