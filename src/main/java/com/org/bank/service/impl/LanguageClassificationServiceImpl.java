package com.org.bank.service.impl;

import com.org.bank.common.DataUtil;
import com.org.bank.common.ExecuteResult;
import com.org.bank.common.Pager;
import com.org.bank.common.encrypt.Md5Util;
import com.org.bank.dao.LanguageClassificationDTOMapper;
import com.org.bank.domain.LanguageClassificationDTO;
import com.org.bank.service.LanguageClassificationService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service("languageClassificationService")
public class LanguageClassificationServiceImpl implements LanguageClassificationService {
    private Logger logger = Logger.getLogger(this.getClass());
    @Autowired
    private LanguageClassificationDTOMapper languageClassificationDTOMapper;
    @Override
    public ExecuteResult<Integer> deleteByPrimaryKey(LanguageClassificationDTO record) {
        ExecuteResult<Integer> executeResult = new ExecuteResult<Integer>();
        try {
            if(StringUtils.isEmpty(record.getLanguageClassificationId())){
                throw new RuntimeException("参数错误：ID非空");
            }
            Integer result = languageClassificationDTOMapper.deleteByPrimaryKey(record.getLanguageClassificationId());
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
    public ExecuteResult<Integer> insert(LanguageClassificationDTO record) {
        ExecuteResult<Integer> executeResult = new ExecuteResult<Integer>();
        try {
            if(StringUtils.isEmpty(record)){
                throw new RuntimeException("参数错误：对象非空");
            }
            record.setLanguageClassificationName(record.getLanguageClassificationName());
            Integer result = languageClassificationDTOMapper.insert(record);
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
    public ExecuteResult<Integer> insertSelective(LanguageClassificationDTO record) {
        ExecuteResult<Integer> executeResult = new ExecuteResult<Integer>();
        try {
            if(StringUtils.isEmpty(record)){
                throw new RuntimeException("参数错误：对象非空");
            }
            record.setLanguageClassificationName(record.getLanguageClassificationName());
            Integer result = languageClassificationDTOMapper.insertSelective(record);
            executeResult.setResult(result);
            executeResult.setResultMessage("成功！");
        }catch (Exception e){
            executeResult.setResultMessage("异常错误！");
            executeResult.getErrorMessages().add(e.getMessage());
            logger.error(e.getMessage());
        }
        return executeResult;    }

    @Override
    public ExecuteResult<LanguageClassificationDTO> selectByPrimaryKey(LanguageClassificationDTO record) {
        ExecuteResult<LanguageClassificationDTO> executeResult = new ExecuteResult<LanguageClassificationDTO>();
        try {
            if(StringUtils.isEmpty(record.getLanguageClassificationId())){
                throw new RuntimeException("参数错误：ID非空");
            }
            LanguageClassificationDTO result = languageClassificationDTOMapper.selectByPrimaryKey(record.getLanguageClassificationId());
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
    public ExecuteResult<DataUtil<LanguageClassificationDTO>> selectList(LanguageClassificationDTO record, Pager pager) {
        ExecuteResult<DataUtil<LanguageClassificationDTO>> executeResult = new ExecuteResult<DataUtil<LanguageClassificationDTO>>();
        try {
            if(StringUtils.isEmpty(record)){
                throw new RuntimeException("参数错误：对象非空");
            }
            List<LanguageClassificationDTO> result = languageClassificationDTOMapper.selectList(record,pager);
            Integer total = languageClassificationDTOMapper.countTotal(record).intValue();
            DataUtil<LanguageClassificationDTO> dtoDataUtil = new DataUtil<LanguageClassificationDTO>();
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
    public ExecuteResult<Integer> updateByPrimaryKeySelective(LanguageClassificationDTO record) {
        ExecuteResult<Integer> executeResult = new ExecuteResult<Integer>();
        try {
            if(StringUtils.isEmpty(record.getLanguageClassificationId())){
                throw new RuntimeException("参数错误：ID非空");
            }
            Integer result = languageClassificationDTOMapper.updateByPrimaryKeySelective(record);
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
    public ExecuteResult<Integer> updateByPrimaryKey(LanguageClassificationDTO record) {
        ExecuteResult<Integer> executeResult = new ExecuteResult<Integer>();
        try {
            if(StringUtils.isEmpty(record.getLanguageClassificationId())){
                throw new RuntimeException("参数错误：ID非空");
            }
            Integer result = languageClassificationDTOMapper.updateByPrimaryKey(record);
            executeResult.setResult(result);
            executeResult.setResultMessage("成功！");
        }catch (Exception e){
            executeResult.setResultMessage("异常错误！");
            executeResult.getErrorMessages().add(e.getMessage());
            logger.error(e.getMessage());
        }
        return executeResult;
    }
}
