package com.org.bank.service.impl;

import com.org.bank.common.DataUtil;
import com.org.bank.common.ExecuteResult;
import com.org.bank.common.Pager;
import com.org.bank.dao.ExaminationPaperDTOMapper;
import com.org.bank.domain.ExaminationPaperDTO;
import com.org.bank.service.ExaminationPaperService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Service("examinationPaperService")
public class ExaminationPaperServiceImpl implements ExaminationPaperService {
    private Logger logger = Logger.getLogger(this.getClass());
    @Resource
    private ExaminationPaperDTOMapper examinationPaperDTOMapper;
    @Override
    public ExecuteResult<Integer> deleteByPrimaryKey(ExaminationPaperDTO record) {
        ExecuteResult<Integer> executeResult = new ExecuteResult<Integer>();
        try {
            if(StringUtils.isEmpty(record.getId())){
                throw new RuntimeException("参数错误：ID非空");
            }
            Integer result = examinationPaperDTOMapper.deleteByPrimaryKey(record.getId());
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
    public ExecuteResult<ExaminationPaperDTO> insert(ExaminationPaperDTO record) {
        ExecuteResult<ExaminationPaperDTO> executeResult = new ExecuteResult<ExaminationPaperDTO>();
        try {
            if(StringUtils.isEmpty(record)){
                throw new RuntimeException("参数错误：对象非空");
            }
            Integer result = examinationPaperDTOMapper.insert(record);
            executeResult.setResult(record);
            executeResult.setResultMessage("成功！");
        }catch (Exception e){
            executeResult.setResultMessage("异常错误！");
            executeResult.getErrorMessages().add(e.getMessage());
            logger.error(e.getMessage());
        }
        return executeResult;
    }

    @Override
    public ExecuteResult<ExaminationPaperDTO> insertSelective(ExaminationPaperDTO record) {
        ExecuteResult<ExaminationPaperDTO> executeResult = new ExecuteResult<ExaminationPaperDTO>();
        try {
            if(StringUtils.isEmpty(record)){
                throw new RuntimeException("参数错误：对象非空");
            }
            Integer result = examinationPaperDTOMapper.insertSelective(record);
            executeResult.setResult(record);
            executeResult.setResultMessage("成功！");
        }catch (Exception e){
            executeResult.setResultMessage("异常错误！");
            executeResult.getErrorMessages().add(e.getMessage());
            logger.error(e.getMessage());
        }
        return executeResult;
    }

    @Override
    public ExecuteResult<ExaminationPaperDTO> selectByPrimaryKey(ExaminationPaperDTO record) {
        ExecuteResult<ExaminationPaperDTO> executeResult = new ExecuteResult<ExaminationPaperDTO>();
        try {
            if(StringUtils.isEmpty(record)){
                throw new RuntimeException("参数错误：ID非空");
            }
            ExaminationPaperDTO result = examinationPaperDTOMapper.selectByPrimaryKey(record.getId());
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
    public ExecuteResult<DataUtil<ExaminationPaperDTO>> selectList(ExaminationPaperDTO record, Pager pager) {
        ExecuteResult<DataUtil<ExaminationPaperDTO>> executeResult = new ExecuteResult<DataUtil<ExaminationPaperDTO>>();
        try {
            if(StringUtils.isEmpty(record)){
                throw new RuntimeException("参数错误：对象非空");
            }
            List<ExaminationPaperDTO> result = examinationPaperDTOMapper.selectList(record,pager);
            Integer total = examinationPaperDTOMapper.countTotal(record).intValue();
            DataUtil<ExaminationPaperDTO> dtoDataUtil = new DataUtil<ExaminationPaperDTO>();
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
    public ExecuteResult<Integer> updateByPrimaryKeySelective(ExaminationPaperDTO record) {
        ExecuteResult<Integer> executeResult = new ExecuteResult<Integer>();
        try {
            if(StringUtils.isEmpty(record)){
                throw new RuntimeException("参数错误：对象非空");
            }
            Integer result = examinationPaperDTOMapper.updateByPrimaryKeySelective(record);
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
    public ExecuteResult<Integer> updateByPrimaryKey(ExaminationPaperDTO record) {
        ExecuteResult<Integer> executeResult = new ExecuteResult<Integer>();
        try {
            if(StringUtils.isEmpty(record)){
                throw new RuntimeException("参数错误：对象非空");
            }
            Integer result = examinationPaperDTOMapper.updateByPrimaryKey(record);
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
