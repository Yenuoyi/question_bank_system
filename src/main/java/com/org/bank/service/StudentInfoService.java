package com.org.bank.service;

import com.org.bank.common.DataUtil;
import com.org.bank.common.ExecuteResult;
import com.org.bank.common.Pager;
import com.org.bank.domain.StudentInfoDTO;

public interface StudentInfoService {
    ExecuteResult<Integer> deleteByPrimaryKey(StudentInfoDTO record);

    ExecuteResult<Integer> insert(StudentInfoDTO record);

    ExecuteResult<Integer> insertSelective(StudentInfoDTO record);

    ExecuteResult<StudentInfoDTO> selectByPrimaryKey(StudentInfoDTO record);

    ExecuteResult<DataUtil<StudentInfoDTO>> selectList(StudentInfoDTO record, Pager pager);

    ExecuteResult<Integer> updateByPrimaryKeySelective(StudentInfoDTO record);

    ExecuteResult<Integer> updateByPrimaryKey(StudentInfoDTO record);
}