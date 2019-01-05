package com.org.bank.service;


import com.org.bank.common.DataUtil;
import com.org.bank.common.ExecuteResult;
import com.org.bank.common.Pager;
import com.org.bank.domain.ExaminationPaperDTO;

public interface ExaminationPaperService {
    ExecuteResult<Integer> deleteByPrimaryKey(ExaminationPaperDTO record);

    ExecuteResult<ExaminationPaperDTO> insert(ExaminationPaperDTO record);

    ExecuteResult<ExaminationPaperDTO> insertSelective(ExaminationPaperDTO record);

    ExecuteResult<ExaminationPaperDTO> selectByPrimaryKey(ExaminationPaperDTO record);

    ExecuteResult<DataUtil<ExaminationPaperDTO>> selectList(ExaminationPaperDTO record, Pager pager);

    ExecuteResult<Integer> updateByPrimaryKeySelective(ExaminationPaperDTO record);

    ExecuteResult<Integer> updateByPrimaryKey(ExaminationPaperDTO record);
}