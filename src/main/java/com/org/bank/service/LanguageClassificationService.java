package com.org.bank.service;

import com.org.bank.common.DataUtil;
import com.org.bank.common.ExecuteResult;
import com.org.bank.common.Pager;
import com.org.bank.domain.LanguageClassificationDTO;

public interface LanguageClassificationService {
    ExecuteResult<Integer> deleteByPrimaryKey(LanguageClassificationDTO record);

    ExecuteResult<Integer> insert(LanguageClassificationDTO record);

    ExecuteResult<Integer> insertSelective(LanguageClassificationDTO record);

    ExecuteResult<LanguageClassificationDTO> selectByPrimaryKey(LanguageClassificationDTO record);

    ExecuteResult<DataUtil<LanguageClassificationDTO>> selectList(LanguageClassificationDTO record, Pager pager);

    ExecuteResult<Integer> updateByPrimaryKeySelective(LanguageClassificationDTO record);

    ExecuteResult<Integer> updateByPrimaryKey(LanguageClassificationDTO record);
}
