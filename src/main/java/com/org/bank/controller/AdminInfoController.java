package com.org.bank.controller;

import com.org.bank.domain.AdminInfoDTO;
import com.org.bank.service.AdminInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/adminInfo")
public class AdminInfoController {
    @Autowired
    private AdminInfoService adminInfoService;
    @RequestMapping("/deleteByPrimaryKey")
    public String deleteByPrimaryKey(@RequestBody Integer adminId){
        adminInfoService.deleteByPrimaryKey(adminId);
        return null;
    }

    @RequestMapping("insert")
    public String insert(AdminInfoDTO record){
        adminInfoService.insert(record);
        return null;
    }

    @RequestMapping("insertSelective")
    public String insertSelective(AdminInfoDTO record){
        adminInfoService.insertSelective(record);
        return null;
    }

    @RequestMapping("/selectByPrimaryKey")
    public String selectByPrimaryKey(Integer adminId){
        adminInfoService.selectByPrimaryKey(adminId);
        return null;
    }

    public String updateByPrimaryKeySelective(AdminInfoDTO record){
        adminInfoService.updateByPrimaryKeySelective(record);
        return null;
    }

    public String updateByPrimaryKey(AdminInfoDTO record){
        adminInfoService.updateByPrimaryKey(record);
        return null;
    }
}
