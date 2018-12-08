package com.org.bank.service;


import com.org.bank.common.DataUtil;
import com.org.bank.common.ExecuteResult;
import com.org.bank.common.Pager;
import com.org.bank.domain.AdminInfoDTO;
import com.org.bank.domain.ClassDTO;

public interface AdminInfoService {
    ExecuteResult<Integer> deleteByPrimaryKey(AdminInfoDTO record);

    ExecuteResult<Integer> insert(AdminInfoDTO record);

    ExecuteResult<Integer> insertSelective(AdminInfoDTO record);

    ExecuteResult<AdminInfoDTO> selectByPrimaryKey(AdminInfoDTO record);

    ExecuteResult<AdminInfoDTO> selectPasswordByPrimaryKey(AdminInfoDTO record);

    ExecuteResult<DataUtil<AdminInfoDTO>> selectList(AdminInfoDTO record, Pager pager);

    ExecuteResult<Integer> updateByPrimaryKeySelective(AdminInfoDTO record);

    ExecuteResult<Integer> updateByPrimaryKey(AdminInfoDTO record);

    ExecuteResult<Integer> updatePasswordByPrimaryKey(AdminInfoDTO record);
}