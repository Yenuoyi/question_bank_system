package com.org.bank.service.impl;

import com.org.bank.common.DataUtil;
import com.org.bank.common.ExecuteResult;
import com.org.bank.common.Pager;
import com.org.bank.dao.ShortAnswerQuestionDTOMapper;
import com.org.bank.domain.ShortAnswerQuestionDTO;
import com.org.bank.service.ShortAnswerQuestionService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import javax.annotation.Resource;
import java.util.List;

@Service("shortAnswerQuestionService")
public class ShortAnswerQuestionServiceImpl implements ShortAnswerQuestionService {
    private Logger logger = Logger.getLogger(this.getClass());
    @Resource
    private ShortAnswerQuestionDTOMapper shortAnswerQuestionDTOMapper;
    @Override
    public ExecuteResult<Integer> deleteByPrimaryKey(ShortAnswerQuestionDTO record) {
        ExecuteResult<Integer> executeResult = new ExecuteResult<Integer>();
        try {
            if(StringUtils.isEmpty(record.getId())){
                throw new RuntimeException("参数错误：ID非空");
            }
            Integer result = shortAnswerQuestionDTOMapper.deleteByPrimaryKey(record.getId());
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
    public ExecuteResult<Integer> insert(ShortAnswerQuestionDTO record) {
        ExecuteResult<Integer> executeResult = new ExecuteResult<Integer>();
        try {
            if(StringUtils.isEmpty(record)){
                throw new RuntimeException("参数错误：对象非空");
            }
            Integer result = shortAnswerQuestionDTOMapper.insert(record);
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
    public ExecuteResult<Integer> insertSelective(ShortAnswerQuestionDTO record) {
        ExecuteResult<Integer> executeResult = new ExecuteResult<Integer>();
        try {
            if(StringUtils.isEmpty(record)){
                throw new RuntimeException("参数错误：对象非空");
            }
            Integer result = shortAnswerQuestionDTOMapper.insertSelective(record);
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
    public ExecuteResult<ShortAnswerQuestionDTO> selectByPrimaryKey(ShortAnswerQuestionDTO record) {
        ExecuteResult<ShortAnswerQuestionDTO> executeResult = new ExecuteResult<ShortAnswerQuestionDTO>();
        try {
            if(StringUtils.isEmpty(record)){
                throw new RuntimeException("参数错误：ID非空");
            }
            ShortAnswerQuestionDTO result = shortAnswerQuestionDTOMapper.selectByPrimaryKey(record.getId());
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
    public ExecuteResult<DataUtil<ShortAnswerQuestionDTO>> selectList(ShortAnswerQuestionDTO record, Pager pager) {
        ExecuteResult<DataUtil<ShortAnswerQuestionDTO>> executeResult = new ExecuteResult<DataUtil<ShortAnswerQuestionDTO>>();
        try {
            if(StringUtils.isEmpty(record)){
                throw new RuntimeException("参数错误：对象非空");
            }
            List<ShortAnswerQuestionDTO> result = shortAnswerQuestionDTOMapper.selectList(record,pager);
            Integer total = shortAnswerQuestionDTOMapper.countTotal(record).intValue();
            DataUtil<ShortAnswerQuestionDTO> dtoDataUtil = new DataUtil<ShortAnswerQuestionDTO>();
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
    public ExecuteResult<Integer> updateByPrimaryKeySelective(ShortAnswerQuestionDTO record) {
        ExecuteResult<Integer> executeResult = new ExecuteResult<Integer>();
        try {
            if(StringUtils.isEmpty(record)){
                throw new RuntimeException("参数错误：对象非空");
            }
            Integer result = shortAnswerQuestionDTOMapper.updateByPrimaryKeySelective(record);
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
    public ExecuteResult<Integer> updateByPrimaryKey(ShortAnswerQuestionDTO record) {
        ExecuteResult<Integer> executeResult = new ExecuteResult<Integer>();
        try {
            if(StringUtils.isEmpty(record)){
                throw new RuntimeException("参数错误：对象非空");
            }
            Integer result = shortAnswerQuestionDTOMapper.updateByPrimaryKey(record);
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
