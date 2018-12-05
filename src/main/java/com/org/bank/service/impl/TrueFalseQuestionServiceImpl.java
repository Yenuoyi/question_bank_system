package com.org.bank.service.impl;

import com.org.bank.common.DataUtil;
import com.org.bank.common.ExecuteResult;
import com.org.bank.common.Pager;
import com.org.bank.dao.TrueFalseQuestionDTOMapper;
import com.org.bank.domain.TrueFalseQuestionDTO;
import com.org.bank.service.TrueFalseQuestionService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Service("trueFalseQuestionService")
public class TrueFalseQuestionServiceImpl implements TrueFalseQuestionService {
    private Logger logger = Logger.getLogger(this.getClass());
    @Resource
    private TrueFalseQuestionDTOMapper trueFalseQuestionDTOMapper;
    @Override
    public ExecuteResult<Integer> deleteByPrimaryKey(TrueFalseQuestionDTO record) {
        ExecuteResult<Integer> executeResult = new ExecuteResult<Integer>();
        try {
            if(StringUtils.isEmpty(record.getId())){
                throw new RuntimeException("参数错误：ID非空");
            }
            Integer result = trueFalseQuestionDTOMapper.deleteByPrimaryKey(record.getId());
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
    public ExecuteResult<Integer> insert(TrueFalseQuestionDTO record) {
        ExecuteResult<Integer> executeResult = new ExecuteResult<Integer>();
        try {
            if(StringUtils.isEmpty(record)){
                throw new RuntimeException("参数错误：对象非空");
            }
            Integer result = trueFalseQuestionDTOMapper.insert(record);
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
    public ExecuteResult<Integer> insertSelective(TrueFalseQuestionDTO record) {
        ExecuteResult<Integer> executeResult = new ExecuteResult<Integer>();
        try {
            if(StringUtils.isEmpty(record)){
                throw new RuntimeException("参数错误：对象非空");
            }
            Integer result = trueFalseQuestionDTOMapper.insertSelective(record);
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
    public ExecuteResult<TrueFalseQuestionDTO> selectByPrimaryKey(TrueFalseQuestionDTO record) {
        ExecuteResult<TrueFalseQuestionDTO> executeResult = new ExecuteResult<TrueFalseQuestionDTO>();
        try {
            if(StringUtils.isEmpty(record)){
                throw new RuntimeException("参数错误：ID非空");
            }
            TrueFalseQuestionDTO result = trueFalseQuestionDTOMapper.selectByPrimaryKey(record.getId());
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
    public ExecuteResult<DataUtil<TrueFalseQuestionDTO>> selectList(TrueFalseQuestionDTO record, Pager pager) {
        ExecuteResult<DataUtil<TrueFalseQuestionDTO>> executeResult = new ExecuteResult<DataUtil<TrueFalseQuestionDTO>>();
        try {
            if(StringUtils.isEmpty(record)){
                throw new RuntimeException("参数错误：对象非空");
            }
            List<TrueFalseQuestionDTO> result = trueFalseQuestionDTOMapper.selectList(record,pager);
            Integer total = trueFalseQuestionDTOMapper.countTotal(record).intValue();
            DataUtil<TrueFalseQuestionDTO> dtoDataUtil = new DataUtil<TrueFalseQuestionDTO>();
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
    public ExecuteResult<Integer> updateByPrimaryKeySelective(TrueFalseQuestionDTO record) {
        ExecuteResult<Integer> executeResult = new ExecuteResult<Integer>();
        try {
            if(StringUtils.isEmpty(record)){
                throw new RuntimeException("参数错误：对象非空");
            }
            Integer result = trueFalseQuestionDTOMapper.updateByPrimaryKeySelective(record);
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
    public ExecuteResult<Integer> updateByPrimaryKey(TrueFalseQuestionDTO record) {
        ExecuteResult<Integer> executeResult = new ExecuteResult<Integer>();
        try {
            if(StringUtils.isEmpty(record)){
                throw new RuntimeException("参数错误：对象非空");
            }
            Integer result = trueFalseQuestionDTOMapper.updateByPrimaryKey(record);
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
