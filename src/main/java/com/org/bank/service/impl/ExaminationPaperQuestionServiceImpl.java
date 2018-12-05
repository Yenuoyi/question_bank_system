package com.org.bank.service.impl;

import com.org.bank.common.DataUtil;
import com.org.bank.common.ExecuteResult;
import com.org.bank.common.Pager;
import com.org.bank.dao.ExaminationPaperQuestionDTOMapper;
import com.org.bank.domain.ExaminationPaperQuestionDTO;
import com.org.bank.service.ExaminationPaperQuestionService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import javax.annotation.Resource;
import java.util.List;

@Service("examinationPaperQuestionService")
public class ExaminationPaperQuestionServiceImpl implements ExaminationPaperQuestionService {
    private Logger logger = Logger.getLogger(this.getClass());
    @Resource
    private ExaminationPaperQuestionDTOMapper examinationPaperQuestionDTOMapper;
    @Override
    public ExecuteResult<Integer> deleteByPrimaryKey(ExaminationPaperQuestionDTO record) {
        ExecuteResult<Integer> executeResult = new ExecuteResult<Integer>();
        try {
            if(StringUtils.isEmpty(record.getId())){
                throw new RuntimeException("参数错误：ID非空");
            }
            Integer result = examinationPaperQuestionDTOMapper.deleteByPrimaryKey(record.getId());
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
    public ExecuteResult<Integer> insert(ExaminationPaperQuestionDTO record) {
        ExecuteResult<Integer> executeResult = new ExecuteResult<Integer>();
        try {
            if(StringUtils.isEmpty(record)){
                throw new RuntimeException("参数错误：对象非空");
            }
            Integer result = examinationPaperQuestionDTOMapper.insert(record);
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
    public ExecuteResult<Integer> insertSelective(ExaminationPaperQuestionDTO record) {
        ExecuteResult<Integer> executeResult = new ExecuteResult<Integer>();
        try {
            if(StringUtils.isEmpty(record)){
                throw new RuntimeException("参数错误：对象非空");
            }
            Integer result = examinationPaperQuestionDTOMapper.insertSelective(record);
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
    public ExecuteResult<ExaminationPaperQuestionDTO> selectByPrimaryKey(ExaminationPaperQuestionDTO record) {
        ExecuteResult<ExaminationPaperQuestionDTO> executeResult = new ExecuteResult<ExaminationPaperQuestionDTO>();
        try {
            if(StringUtils.isEmpty(record)){
                throw new RuntimeException("参数错误：ID非空");
            }
            ExaminationPaperQuestionDTO result = examinationPaperQuestionDTOMapper.selectByPrimaryKey(record.getId());
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
    public ExecuteResult<DataUtil<ExaminationPaperQuestionDTO>> selectList(ExaminationPaperQuestionDTO record, Pager pager) {
        ExecuteResult<DataUtil<ExaminationPaperQuestionDTO>> executeResult = new ExecuteResult<DataUtil<ExaminationPaperQuestionDTO>>();
        try {
            if(StringUtils.isEmpty(record)){
                throw new RuntimeException("参数错误：对象非空");
            }
            List<ExaminationPaperQuestionDTO> result = examinationPaperQuestionDTOMapper.selectList(record,pager);
            Integer total = examinationPaperQuestionDTOMapper.countTotal(record).intValue();
            DataUtil<ExaminationPaperQuestionDTO> dtoDataUtil = new DataUtil<ExaminationPaperQuestionDTO>();
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
    public ExecuteResult<Integer> updateByPrimaryKeySelective(ExaminationPaperQuestionDTO record) {
        ExecuteResult<Integer> executeResult = new ExecuteResult<Integer>();
        try {
            if(StringUtils.isEmpty(record)){
                throw new RuntimeException("参数错误：对象非空");
            }
            Integer result = examinationPaperQuestionDTOMapper.updateByPrimaryKeySelective(record);
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
    public ExecuteResult<Integer> updateByPrimaryKey(ExaminationPaperQuestionDTO record) {
        ExecuteResult<Integer> executeResult = new ExecuteResult<Integer>();
        try {
            if(StringUtils.isEmpty(record)){
                throw new RuntimeException("参数错误：对象非空");
            }
            Integer result = examinationPaperQuestionDTOMapper.updateByPrimaryKey(record);
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
