package com.org.bank.dao;

import com.org.bank.domain.ExaminationPaperDTO;

public interface ExaminationPaperDTOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ExaminationPaperDTO record);

    int insertSelective(ExaminationPaperDTO record);

    ExaminationPaperDTO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ExaminationPaperDTO record);

    int updateByPrimaryKey(ExaminationPaperDTO record);
}