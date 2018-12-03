package com.org.bank.service;


import com.org.bank.domain.AdminInfoDTO;

public interface AdminInfoService {
    int deleteByPrimaryKey(Integer adminId);

    int insert(AdminInfoDTO record);

    int insertSelective(AdminInfoDTO record);

    AdminInfoDTO selectByPrimaryKey(Integer adminId);

    int updateByPrimaryKeySelective(AdminInfoDTO record);

    int updateByPrimaryKey(AdminInfoDTO record);
}