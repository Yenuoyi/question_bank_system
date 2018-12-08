package com.org.bank.service.impl;

import com.org.bank.common.DataUtil;
import com.org.bank.common.ExecuteResult;
import com.org.bank.common.Pager;
import com.org.bank.common.encrypt.Md5Util;
import com.org.bank.dao.AdminInfoDTOMapper;
import com.org.bank.domain.AdminInfoDTO;
import com.org.bank.domain.ClassDTO;
import com.org.bank.service.AdminInfoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Service("adminInfoService")
public class AdminInfoServiceImpl implements AdminInfoService {
    private Logger logger = Logger.getLogger(this.getClass());
    @Resource
    private AdminInfoDTOMapper adminInfoDTOMapper;
    @Override
    public ExecuteResult<Integer> deleteByPrimaryKey(AdminInfoDTO record) {
        ExecuteResult<Integer> executeResult = new ExecuteResult<Integer>();
        try {
            if(StringUtils.isEmpty(record.getId())){
                throw new RuntimeException("参数错误：ID非空");
            }
            Integer result = adminInfoDTOMapper.deleteByPrimaryKey(record.getId());
            executeResult.setResult(result);
            executeResult.setResultMessage("成功！");
        }catch (Exception e){
            executeResult.setResultMessage("异常错误！");
            executeResult.getErrorMessages().add(e.getMessage());
            logger.error(e.getMessage());
        }
        return executeResult;
    }

    @Override
    public ExecuteResult<Integer> insert(AdminInfoDTO record) {
        ExecuteResult<Integer> executeResult = new ExecuteResult<Integer>();
        try {
            if(StringUtils.isEmpty(record)){
                throw new RuntimeException("参数错误：对象非空");
            }
            record.setAdminPassword(Md5Util.encode(record.getAdminPassword()));
            Integer result = adminInfoDTOMapper.insert(record);
            executeResult.setResult(result);
            executeResult.setResultMessage("成功！");
        }catch (Exception e){
            executeResult.setResultMessage("异常错误！");
            executeResult.getErrorMessages().add(e.getMessage());
            logger.error(e.getMessage());
        }
        return executeResult;
    }

    @Override
    public ExecuteResult<Integer> insertSelective(AdminInfoDTO record) {
        ExecuteResult<Integer> executeResult = new ExecuteResult<Integer>();
        try {
            if(StringUtils.isEmpty(record)){
                throw new RuntimeException("参数错误：对象非空");
            }
            record.setAdminPassword(Md5Util.encode(record.getAdminPassword()));
            Integer result = adminInfoDTOMapper.insertSelective(record);
            executeResult.setResult(result);
            executeResult.setResultMessage("成功！");
        }catch (Exception e){
            executeResult.setResultMessage("异常错误！");
            executeResult.getErrorMessages().add(e.getMessage());
            logger.error(e.getMessage());
        }
        return executeResult;    }

    @Override
    public ExecuteResult<AdminInfoDTO> selectByPrimaryKey(AdminInfoDTO record) {
        ExecuteResult<AdminInfoDTO> executeResult = new ExecuteResult<AdminInfoDTO>();
        try {
            if(StringUtils.isEmpty(record.getId())){
                throw new RuntimeException("参数错误：ID非空");
            }
            AdminInfoDTO result = adminInfoDTOMapper.selectByPrimaryKey(record.getId());
            executeResult.setResult(result);
            executeResult.setResultMessage("成功！");
        }catch (Exception e){
            executeResult.setResultMessage("异常错误！");
            executeResult.getErrorMessages().add(e.getMessage());
            logger.error(e.getMessage());
        }
        return executeResult;
    }

    @Override
    public ExecuteResult<AdminInfoDTO> selectPasswordByPrimaryKey(AdminInfoDTO record) {
        ExecuteResult<AdminInfoDTO> executeResult = new ExecuteResult<AdminInfoDTO>();
        try {
            if(StringUtils.isEmpty(record.getId())){
                throw new RuntimeException("参数错误：ID非空");
            }
            AdminInfoDTO result = adminInfoDTOMapper.selectPasswordByPrimaryKey(record.getId());
            executeResult.setResult(result);
            executeResult.setResultMessage("成功！");
        }catch (Exception e){
            executeResult.setResultMessage("异常错误！");
            executeResult.getErrorMessages().add(e.getMessage());
            logger.error(e.getMessage());
        }
        return executeResult;
    }

    @Override
    public ExecuteResult<DataUtil<AdminInfoDTO>> selectList(AdminInfoDTO record, Pager pager) {
        ExecuteResult<DataUtil<AdminInfoDTO>> executeResult = new ExecuteResult<DataUtil<AdminInfoDTO>>();
        try {
            if(StringUtils.isEmpty(record)){
                throw new RuntimeException("参数错误：对象非空");
            }
            List<AdminInfoDTO> result = adminInfoDTOMapper.selectList(record,pager);
            Integer total = adminInfoDTOMapper.countTotal(record).intValue();
            DataUtil<AdminInfoDTO> dtoDataUtil = new DataUtil<AdminInfoDTO>();
            dtoDataUtil.setList(result);
            dtoDataUtil.getPager().setTotalCount(total);
            executeResult.setResult(dtoDataUtil);
            executeResult.setResultMessage("成功！");
        }catch (Exception e){
            executeResult.setResultMessage("异常错误！");
            executeResult.getErrorMessages().add(e.getMessage());
            logger.error(e.getMessage());
        }
        return executeResult;
    }

    @Override
    public ExecuteResult<Integer> updateByPrimaryKeySelective(AdminInfoDTO record) {
        ExecuteResult<Integer> executeResult = new ExecuteResult<Integer>();
        try {
            if(StringUtils.isEmpty(record.getId())){
                throw new RuntimeException("参数错误：ID非空");
            }
            Integer result = adminInfoDTOMapper.updateByPrimaryKeySelective(record);
            executeResult.setResult(result);
            executeResult.setResultMessage("成功！");
        }catch (Exception e){
            executeResult.setResultMessage("异常错误！");
            executeResult.getErrorMessages().add(e.getMessage());
            logger.error(e.getMessage());
        }
        return executeResult;
    }

    @Override
    public ExecuteResult<Integer> updateByPrimaryKey(AdminInfoDTO record) {
        ExecuteResult<Integer> executeResult = new ExecuteResult<Integer>();
        try {
            if(StringUtils.isEmpty(record.getId())){
                throw new RuntimeException("参数错误：ID非空");
            }
            Integer result = adminInfoDTOMapper.updateByPrimaryKey(record);
            executeResult.setResult(result);
            executeResult.setResultMessage("成功！");
        }catch (Exception e){
            executeResult.setResultMessage("异常错误！");
            executeResult.getErrorMessages().add(e.getMessage());
            logger.error(e.getMessage());
        }
        return executeResult;
    }

    @Override
    public ExecuteResult<Integer> updatePasswordByPrimaryKey(AdminInfoDTO record) {
        ExecuteResult<Integer> executeResult = new ExecuteResult<Integer>();
        try {
            if(StringUtils.isEmpty(record.getId())){
                throw new RuntimeException("参数错误：ID非空");
            }
            AdminInfoDTO adminInfoDTO = adminInfoDTOMapper.selectPasswordByPrimaryKey(record.getId());
            String oldPassword = Md5Util.encode(record.getAdminPassword());
            if(adminInfoDTO.getAdminPassword().equals(oldPassword)){
                record.setNewAdminPassword(Md5Util.encode(record.getNewAdminPassword()));
                Integer result = adminInfoDTOMapper.updatePasswordByPrimaryKey(record);
                executeResult.setResult(result);
                executeResult.setResultMessage("成功！");
            }else{
                executeResult.setResult(0);
                executeResult.setResultMessage("旧密码错误！");
            }

        }catch (Exception e){
            executeResult.setResultMessage("异常错误！");
            executeResult.getErrorMessages().add(e.getMessage());
            logger.error(e.getMessage());
        }
        return executeResult;
    }
}
