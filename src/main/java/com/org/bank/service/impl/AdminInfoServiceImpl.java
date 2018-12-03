package com.org.bank.service.impl;

import com.org.bank.dao.AdminInfoDTOMapper;
import com.org.bank.domain.AdminInfoDTO;
import com.org.bank.service.AdminInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminInfoServiceImpl implements AdminInfoService {
    @Autowired
    private AdminInfoDTOMapper adminInfoDTOMapper;
    @Override
    public int deleteByPrimaryKey(Integer adminId) {
        return adminInfoDTOMapper.deleteByPrimaryKey(adminId);
    }

    @Override
    public int insert(AdminInfoDTO record) {
        return adminInfoDTOMapper.insert(record);
    }

    @Override
    public int insertSelective(AdminInfoDTO record) {
        return adminInfoDTOMapper.insertSelective(record);
    }

    @Override
    public AdminInfoDTO selectByPrimaryKey(Integer adminId) {
        return adminInfoDTOMapper.selectByPrimaryKey(adminId);
    }

    @Override
    public int updateByPrimaryKeySelective(AdminInfoDTO record) {
        return adminInfoDTOMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(AdminInfoDTO record) {
        return adminInfoDTOMapper.updateByPrimaryKey(record);
    }
}
