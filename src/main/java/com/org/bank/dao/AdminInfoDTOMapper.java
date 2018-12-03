package com.org.bank.dao;

import com.org.bank.domain.AdminInfoDTO;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminInfoDTOMapper {
    int deleteByPrimaryKey(Integer adminId);

    int insert(AdminInfoDTO record);

    int insertSelective(AdminInfoDTO record);

    AdminInfoDTO selectByPrimaryKey(Integer adminId);

    int updateByPrimaryKeySelective(AdminInfoDTO record);

    int updateByPrimaryKey(AdminInfoDTO record);
}