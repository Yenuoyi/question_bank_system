package com.org.bank.service.impl;

import com.org.bank.common.DataUtil;
import com.org.bank.common.ExecuteResult;
import com.org.bank.common.Pager;
import com.org.bank.common.encrypt.Md5Util;
import com.org.bank.dao.TeacherInfoDTOMapper;
import com.org.bank.domain.TeacherInfoDTO;
import com.org.bank.service.TeacherInfoService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import javax.annotation.Resource;
import java.util.List;

@Service("teacherInfoService")
public class TeacherInfoServiceImpl implements TeacherInfoService {
    private Logger logger = Logger.getLogger(this.getClass());
    @Resource
    private TeacherInfoDTOMapper teacherInfoDTOMapper;
    @Override
    public ExecuteResult<Integer> deleteByPrimaryKey(TeacherInfoDTO record) {
        ExecuteResult<Integer> executeResult = new ExecuteResult<Integer>();
        try {
            if(StringUtils.isEmpty(record.getId())){
                throw new RuntimeException("参数错误：ID非空");
            }
            Integer result = teacherInfoDTOMapper.deleteByPrimaryKey(record.getId());
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
    public ExecuteResult<Integer> insert(TeacherInfoDTO record) {
        ExecuteResult<Integer> executeResult = new ExecuteResult<Integer>();
        try {
            if(StringUtils.isEmpty(record)){
                throw new RuntimeException("参数错误：对象非空");
            }
            record.setTeacherPassword(Md5Util.encode(record.getTeacherPassword()));
            Integer result = teacherInfoDTOMapper.insert(record);
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
    public ExecuteResult<Integer> insertSelective(TeacherInfoDTO record) {
        ExecuteResult<Integer> executeResult = new ExecuteResult<Integer>();
        try {
            if(StringUtils.isEmpty(record)){
                throw new RuntimeException("参数错误：对象非空");
            }
            Integer result = teacherInfoDTOMapper.insertSelective(record);
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
    public ExecuteResult<TeacherInfoDTO> selectByPrimaryKey(TeacherInfoDTO record) {
        ExecuteResult<TeacherInfoDTO> executeResult = new ExecuteResult<TeacherInfoDTO>();
        try {
            if(StringUtils.isEmpty(record)){
                throw new RuntimeException("参数错误：ID非空");
            }
            TeacherInfoDTO result = teacherInfoDTOMapper.selectByPrimaryKey(record.getId());
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
    public ExecuteResult<TeacherInfoDTO> selectPasswordByPrimaryKey(TeacherInfoDTO record) {
        ExecuteResult<TeacherInfoDTO> executeResult = new ExecuteResult<TeacherInfoDTO>();
        try {
            if(StringUtils.isEmpty(record)){
                throw new RuntimeException("参数错误：ID非空");
            }
            TeacherInfoDTO result = teacherInfoDTOMapper.selectPasswordByPrimaryKey(record.getId());
            executeResult.setResult(result);
            executeResult.setResultMessage("成功！");
        }catch (Exception e){
            executeResult.setResultMessage("异常错误！");
            executeResult.getErrorMessages().add(e.getMessage());
            logger.error(e.getMessage());
        }
        return executeResult;    }

    @Override
    public ExecuteResult<DataUtil<TeacherInfoDTO>> selectList(TeacherInfoDTO record, Pager pager) {
        ExecuteResult<DataUtil<TeacherInfoDTO>> executeResult = new ExecuteResult<DataUtil<TeacherInfoDTO>>();
        try {
            if(StringUtils.isEmpty(record)){
                throw new RuntimeException("参数错误：对象非空");
            }
            List<TeacherInfoDTO> result = teacherInfoDTOMapper.selectList(record,pager);
            Integer total = teacherInfoDTOMapper.countTotal(record).intValue();
            DataUtil<TeacherInfoDTO> dtoDataUtil = new DataUtil<TeacherInfoDTO>();
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
    public ExecuteResult<Integer> updateByPrimaryKeySelective(TeacherInfoDTO record) {
        ExecuteResult<Integer> executeResult = new ExecuteResult<Integer>();
        try {
            if(StringUtils.isEmpty(record)){
                throw new RuntimeException("参数错误：对象非空");
            }
            Integer result = teacherInfoDTOMapper.updateByPrimaryKeySelective(record);
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
    public ExecuteResult<Integer> updateByPrimaryKey(TeacherInfoDTO record) {
        ExecuteResult<Integer> executeResult = new ExecuteResult<Integer>();
        try {
            if(StringUtils.isEmpty(record)){
                throw new RuntimeException("参数错误：对象非空");
            }
            Integer result = teacherInfoDTOMapper.updateByPrimaryKey(record);
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
    public ExecuteResult<Integer> updatePasswordByPrimaryKey(TeacherInfoDTO record) {
        ExecuteResult<Integer> executeResult = new ExecuteResult<Integer>();
        try {
            if(StringUtils.isEmpty(record)){
                throw new RuntimeException("参数错误：对象非空");
            }
            TeacherInfoDTO teacherInfoDTO = teacherInfoDTOMapper.selectPasswordByPrimaryKey(record.getId());
            String oldPassword = Md5Util.encode(record.getTeacherPassword());
            if(teacherInfoDTO.getTeacherPassword().equals(oldPassword)){
                record.setNewTeacherPassword(Md5Util.encode(record.getNewTeacherPassword()));
                Integer result = teacherInfoDTOMapper.updatePasswordByPrimaryKey(record);
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
