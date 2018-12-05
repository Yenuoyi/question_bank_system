package com.org.bank.service;


import com.org.bank.common.DataUtil;
import com.org.bank.common.ExecuteResult;
import com.org.bank.common.Pager;
import com.org.bank.domain.DoubtDTO;

public interface DoubtService {
    ExecuteResult<Integer> deleteByPrimaryKey(DoubtDTO record);

    ExecuteResult<Integer> insert(DoubtDTO record);

    ExecuteResult<Integer> insertSelective(DoubtDTO record);

    ExecuteResult<DoubtDTO> selectByPrimaryKey(DoubtDTO record);

    ExecuteResult<DataUtil<DoubtDTO>> selectList(DoubtDTO record, Pager pager);

    ExecuteResult<Integer> updateByPrimaryKeySelective(DoubtDTO record);

    ExecuteResult<Integer> updateByPrimaryKey(DoubtDTO record);
}