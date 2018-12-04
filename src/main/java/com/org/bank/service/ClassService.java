package com.org.bank.service;


import com.org.bank.common.DataUtil;
import com.org.bank.common.ExecuteResult;
import com.org.bank.common.Pager;
import com.org.bank.domain.ClassDTO;

public interface ClassService {
    ExecuteResult<Integer> deleteByPrimaryKey(ClassDTO record);

    ExecuteResult<Integer> insert(ClassDTO record);

    ExecuteResult<Integer> insertSelective(ClassDTO record);

    ExecuteResult<ClassDTO> selectByPrimaryKey(ClassDTO record);

    ExecuteResult<DataUtil<ClassDTO>> selectList(ClassDTO record, Pager pager);

    ExecuteResult<Integer> updateByPrimaryKeySelective(ClassDTO record);

    ExecuteResult<Integer> updateByPrimaryKey(ClassDTO record);
}