package com.org.bank.service.impl;

import com.org.bank.common.DataUtil;
import com.org.bank.common.ExecuteResult;
import com.org.bank.common.Pager;
import com.org.bank.config.spring.security.UserSecurityContextHolder;
import com.org.bank.dao.SingleChoiceQuestionDTOMapper;
import com.org.bank.dao.WrongBookDTOMapper;
import com.org.bank.domain.SingleChoiceQuestionDTO;
import com.org.bank.domain.WrongBookDTO;
import com.org.bank.service.SingleChoiceQuestionService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("singleChoiceQuestionService")
public class SingleChoiceQuestionServiceImpl implements SingleChoiceQuestionService {
    private Logger logger = Logger.getLogger(this.getClass());
    @Resource
    private SingleChoiceQuestionDTOMapper singleChoiceQuestionDTOMapper;
    @Resource
    private WrongBookDTOMapper wrongBookDTOMapper;
    @Override
    public ExecuteResult<Integer> deleteByPrimaryKey(SingleChoiceQuestionDTO record) {
        ExecuteResult<Integer> executeResult = new ExecuteResult<Integer>();
        try {
            if(StringUtils.isEmpty(record.getId())){
                throw new RuntimeException("参数错误：ID非空");
            }
            Integer result = singleChoiceQuestionDTOMapper.deleteByPrimaryKey(record.getId());
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
    public ExecuteResult<Integer> insert(SingleChoiceQuestionDTO record) {
        ExecuteResult<Integer> executeResult = new ExecuteResult<Integer>();
        try {
            if(StringUtils.isEmpty(record)){
                throw new RuntimeException("参数错误：对象非空");
            }
            Integer result = singleChoiceQuestionDTOMapper.insert(record);
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
    public ExecuteResult<Integer> insertSelective(SingleChoiceQuestionDTO record) {
        ExecuteResult<Integer> executeResult = new ExecuteResult<Integer>();
        try {
            if(StringUtils.isEmpty(record)){
                throw new RuntimeException("参数错误：对象非空");
            }
            Integer result = singleChoiceQuestionDTOMapper.insertSelective(record);
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
    public ExecuteResult<SingleChoiceQuestionDTO> selectByPrimaryKey(SingleChoiceQuestionDTO record) {
        ExecuteResult<SingleChoiceQuestionDTO> executeResult = new ExecuteResult<SingleChoiceQuestionDTO>();
        try {
            if(StringUtils.isEmpty(record)){
                throw new RuntimeException("参数错误：ID非空");
            }
            SingleChoiceQuestionDTO result = singleChoiceQuestionDTOMapper.selectByPrimaryKey(record.getId());
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
    public ExecuteResult<DataUtil<SingleChoiceQuestionDTO>> selectList(SingleChoiceQuestionDTO record, Pager pager) {
        ExecuteResult<DataUtil<SingleChoiceQuestionDTO>> executeResult = new ExecuteResult<DataUtil<SingleChoiceQuestionDTO>>();
        try {
            if(StringUtils.isEmpty(record)){
                throw new RuntimeException("参数错误：对象非空");
            }
            List<SingleChoiceQuestionDTO> result = singleChoiceQuestionDTOMapper.selectList(record,pager);
            Integer total = singleChoiceQuestionDTOMapper.countTotal(record).intValue();
            DataUtil<SingleChoiceQuestionDTO> dtoDataUtil = new DataUtil<SingleChoiceQuestionDTO>();
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
    public ExecuteResult<DataUtil<SingleChoiceQuestionDTO>> randomSelectSingleChoiceQuestionList(Pager pager) {
        ExecuteResult<DataUtil<SingleChoiceQuestionDTO>> executeResult = new ExecuteResult<DataUtil<SingleChoiceQuestionDTO>>();
        try {
            if(StringUtils.isEmpty(pager)){
                throw new RuntimeException("参数错误：对象非空");
            }
            List<SingleChoiceQuestionDTO> result = singleChoiceQuestionDTOMapper.randomSelectSingleChoiceQuestionList(pager);
            DataUtil<SingleChoiceQuestionDTO> dtoDataUtil = new DataUtil<SingleChoiceQuestionDTO>();
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
    public ExecuteResult<DataUtil<SingleChoiceQuestionDTO>> selectByPrimaryKeyList(List<Integer> keys) {
        ExecuteResult<DataUtil<SingleChoiceQuestionDTO>> executeResult = new ExecuteResult<DataUtil<SingleChoiceQuestionDTO>>();
        try {
            if(StringUtils.isEmpty(keys)){
                throw new RuntimeException("参数错误：对象非空");
            }
            List<SingleChoiceQuestionDTO> result = singleChoiceQuestionDTOMapper.selectByPrimaryKeyList(keys);
            DataUtil<SingleChoiceQuestionDTO> dtoDataUtil = new DataUtil<SingleChoiceQuestionDTO>();
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
    public ExecuteResult<DataUtil<SingleChoiceQuestionDTO>> checkExercize(List<SingleChoiceQuestionDTO> record) {
        ExecuteResult<DataUtil<SingleChoiceQuestionDTO>> executeResult = new ExecuteResult<DataUtil<SingleChoiceQuestionDTO>>();
        int username = Integer.parseInt(UserSecurityContextHolder.getUsername());
        int roleType = UserSecurityContextHolder.getUserRoleType();
        try {
            if(StringUtils.isEmpty(record)){
                throw new RuntimeException("参数错误：对象非空");
            }
            Map<Integer,SingleChoiceQuestionDTO> map = new HashMap<>();
            List<Integer> keys = new ArrayList<>();
            int doubtListSize = record.size();
            for(int i=0;i<doubtListSize;i++){
                keys.add(record.get(i).getId());
                map.put(record.get(i).getId(),record.get(i));
            }
            List<SingleChoiceQuestionDTO> result = singleChoiceQuestionDTOMapper.selectByPrimaryKeyList(keys);
            List<WrongBookDTO> wrongBookDTOS = new ArrayList<>();
            int resultSize = result.size();
            for(int j=0;j < resultSize;j++){
                SingleChoiceQuestionDTO realSingleChoiceQuestion = result.get(j);
                SingleChoiceQuestionDTO testSingleChoiceQuestion = map.get(realSingleChoiceQuestion.getId());
                if(testSingleChoiceQuestion.getSingleChoiceAnswer().equals(realSingleChoiceQuestion.getSingleChoiceAnswer())){
                    testSingleChoiceQuestion.setTrueOrFalse(1);
                }else{
                    testSingleChoiceQuestion.setTrueOrFalse(0);
                    WrongBookDTO wrongBookDTO = new WrongBookDTO();
                    wrongBookDTO.setQuestion(realSingleChoiceQuestion.getSingleChoiceQuestion());
                    wrongBookDTO.setAnswer(realSingleChoiceQuestion.getSingleChoiceAnswer());
                    wrongBookDTO.setId(username);
                    wrongBookDTO.setUserType(roleType);
                    wrongBookDTO.setQuestionId(realSingleChoiceQuestion.getId());
                    wrongBookDTO.setQuestionType(3);
                    wrongBookDTOS.add(wrongBookDTO);
                }
            }
            if (wrongBookDTOS.size()!=0){
                wrongBookDTOMapper.insertList(wrongBookDTOS);
            }
            DataUtil<SingleChoiceQuestionDTO> dtoDataUtil = new DataUtil<SingleChoiceQuestionDTO>();
            dtoDataUtil.setList(record);
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
    public ExecuteResult<Integer> updateByPrimaryKeySelective(SingleChoiceQuestionDTO record) {
        ExecuteResult<Integer> executeResult = new ExecuteResult<Integer>();
        try {
            if(StringUtils.isEmpty(record)){
                throw new RuntimeException("参数错误：对象非空");
            }
            Integer result = singleChoiceQuestionDTOMapper.updateByPrimaryKeySelective(record);
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
    public ExecuteResult<Integer> updateByPrimaryKey(SingleChoiceQuestionDTO record) {
        ExecuteResult<Integer> executeResult = new ExecuteResult<Integer>();
        try {
            if(StringUtils.isEmpty(record)){
                throw new RuntimeException("参数错误：对象非空");
            }
            Integer result = singleChoiceQuestionDTOMapper.updateByPrimaryKey(record);
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
