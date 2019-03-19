package com.org.bank.service.impl;

import com.org.bank.common.DataUtil;
import com.org.bank.common.ExecuteResult;
import com.org.bank.common.Pager;
import com.org.bank.dao.FillVainQuestionDTOMapper;
import com.org.bank.domain.FillVainQuestionDTO;
import com.org.bank.domain.FillVainQuestionDTO;
import com.org.bank.service.FillVainQuestionService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Service("fillVainQuestionService")
public class FillVainQuestionServiceImpl implements FillVainQuestionService {
    private Logger logger = Logger.getLogger(this.getClass());
    @Resource
    private FillVainQuestionDTOMapper fillVainQuestionDTOMapper;
    @Override
    public ExecuteResult<Integer> deleteByPrimaryKey(FillVainQuestionDTO record) {
        ExecuteResult<Integer> executeResult = new ExecuteResult<Integer>();
        try {
            if(StringUtils.isEmpty(record.getId())){
                throw new RuntimeException("参数错误：ID非空");
            }
            Integer result = fillVainQuestionDTOMapper.deleteByPrimaryKey(record.getId());
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
    public ExecuteResult<Integer> insert(FillVainQuestionDTO record) {
        ExecuteResult<Integer> executeResult = new ExecuteResult<Integer>();
        try {
            if(StringUtils.isEmpty(record)){
                throw new RuntimeException("参数错误：对象非空");
            }
            Integer result = fillVainQuestionDTOMapper.insert(record);
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
    public ExecuteResult<Integer> insertSelective(FillVainQuestionDTO record) {
        ExecuteResult<Integer> executeResult = new ExecuteResult<Integer>();
        try {
            if(StringUtils.isEmpty(record)){
                throw new RuntimeException("参数错误：对象非空");
            }
            Integer result = fillVainQuestionDTOMapper.insertSelective(record);
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
    public ExecuteResult<FillVainQuestionDTO> selectByPrimaryKey(FillVainQuestionDTO record) {
        ExecuteResult<FillVainQuestionDTO> executeResult = new ExecuteResult<FillVainQuestionDTO>();
        try {
            if(StringUtils.isEmpty(record)){
                throw new RuntimeException("参数错误：ID非空");
            }
            FillVainQuestionDTO result = fillVainQuestionDTOMapper.selectByPrimaryKey(record.getId());
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
    public ExecuteResult<DataUtil<FillVainQuestionDTO>> selectList(FillVainQuestionDTO record, Pager pager) {
        ExecuteResult<DataUtil<FillVainQuestionDTO>> executeResult = new ExecuteResult<DataUtil<FillVainQuestionDTO>>();
        try {
            if(StringUtils.isEmpty(record)){
                throw new RuntimeException("参数错误：对象非空");
            }
            List<FillVainQuestionDTO> result = fillVainQuestionDTOMapper.selectList(record,pager);
            Integer total = fillVainQuestionDTOMapper.countTotal(record).intValue();
            DataUtil<FillVainQuestionDTO> dtoDataUtil = new DataUtil<FillVainQuestionDTO>();
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
    public ExecuteResult<DataUtil<FillVainQuestionDTO>> randomSelectFillVainQuestionList(FillVainQuestionDTO record, Pager pager) {
        ExecuteResult<DataUtil<FillVainQuestionDTO>> executeResult = new ExecuteResult<DataUtil<FillVainQuestionDTO>>();
        try {
            if(StringUtils.isEmpty(pager)){
                throw new RuntimeException("参数错误：对象非空");
            }
            List<FillVainQuestionDTO> result = fillVainQuestionDTOMapper.randomSelectFillVainQuestionList(record,pager);
            DataUtil<FillVainQuestionDTO> dtoDataUtil = new DataUtil<FillVainQuestionDTO>();
            dtoDataUtil.setList(result);
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
    public ExecuteResult<DataUtil<FillVainQuestionDTO>> selectByPrimaryKeyList(List<Integer> keys) {
        ExecuteResult<DataUtil<FillVainQuestionDTO>> executeResult = new ExecuteResult<DataUtil<FillVainQuestionDTO>>();
        try {
            if(StringUtils.isEmpty(keys)){
                throw new RuntimeException("参数错误：对象非空");
            }
            List<FillVainQuestionDTO> result = fillVainQuestionDTOMapper.selectByPrimaryKeyList(keys);
            DataUtil<FillVainQuestionDTO> dtoDataUtil = new DataUtil<FillVainQuestionDTO>();
            dtoDataUtil.setList(result);
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
    public ExecuteResult<Integer> updateByPrimaryKeySelective(FillVainQuestionDTO record) {
        ExecuteResult<Integer> executeResult = new ExecuteResult<Integer>();
        try {
            if(StringUtils.isEmpty(record)){
                throw new RuntimeException("参数错误：对象非空");
            }
            Integer result = fillVainQuestionDTOMapper.updateByPrimaryKeySelective(record);
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
    public ExecuteResult<Integer> updateByPrimaryKey(FillVainQuestionDTO record) {
        ExecuteResult<Integer> executeResult = new ExecuteResult<Integer>();
        try {
            if(StringUtils.isEmpty(record)){
                throw new RuntimeException("参数错误：对象非空");
            }
            Integer result = fillVainQuestionDTOMapper.updateByPrimaryKey(record);
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
