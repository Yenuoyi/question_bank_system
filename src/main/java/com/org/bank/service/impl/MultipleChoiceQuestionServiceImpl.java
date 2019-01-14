package com.org.bank.service.impl;

import com.org.bank.common.DataUtil;
import com.org.bank.common.ExecuteResult;
import com.org.bank.common.Pager;
import com.org.bank.config.spring.security.UserSecurityContextHolder;
import com.org.bank.dao.MultipleChoiceQuestionDTOMapper;
import com.org.bank.dao.WrongBookDTOMapper;
import com.org.bank.domain.MultipleChoiceQuestionDTO;
import com.org.bank.domain.MultipleChoiceQuestionDTO;
import com.org.bank.domain.MultipleChoiceQuestionDTO;
import com.org.bank.domain.WrongBookDTO;
import com.org.bank.service.MultipleChoiceQuestionService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("multipleChoiceQuestionService")
public class MultipleChoiceQuestionServiceImpl implements MultipleChoiceQuestionService {
    private Logger logger = Logger.getLogger(this.getClass());
    @Resource
    private MultipleChoiceQuestionDTOMapper multipleChoiceQuestionDTOMapper;
    @Resource
    private WrongBookDTOMapper wrongBookDTOMapper;
    @Override
    public ExecuteResult<Integer> deleteByPrimaryKey(MultipleChoiceQuestionDTO record) {
        ExecuteResult<Integer> executeResult = new ExecuteResult<Integer>();
        try {
            if(StringUtils.isEmpty(record.getId())){
                throw new RuntimeException("参数错误：ID非空");
            }
            Integer result = multipleChoiceQuestionDTOMapper.deleteByPrimaryKey(record.getId());
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
    public ExecuteResult<Integer> insert(MultipleChoiceQuestionDTO record) {
        ExecuteResult<Integer> executeResult = new ExecuteResult<Integer>();
        try {
            if(StringUtils.isEmpty(record)){
                throw new RuntimeException("参数错误：对象非空");
            }
            Integer result = multipleChoiceQuestionDTOMapper.insert(record);
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
    public ExecuteResult<Integer> insertSelective(MultipleChoiceQuestionDTO record) {
        ExecuteResult<Integer> executeResult = new ExecuteResult<Integer>();
        try {
            if(StringUtils.isEmpty(record)){
                throw new RuntimeException("参数错误：对象非空");
            }
            Integer result = multipleChoiceQuestionDTOMapper.insertSelective(record);
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
    public ExecuteResult<MultipleChoiceQuestionDTO> selectByPrimaryKey(MultipleChoiceQuestionDTO record) {
        ExecuteResult<MultipleChoiceQuestionDTO> executeResult = new ExecuteResult<MultipleChoiceQuestionDTO>();
        try {
            if(StringUtils.isEmpty(record)){
                throw new RuntimeException("参数错误：ID非空");
            }
            MultipleChoiceQuestionDTO result = multipleChoiceQuestionDTOMapper.selectByPrimaryKey(record.getId());
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
    public ExecuteResult<DataUtil<MultipleChoiceQuestionDTO>> selectList(MultipleChoiceQuestionDTO record, Pager pager) {
        ExecuteResult<DataUtil<MultipleChoiceQuestionDTO>> executeResult = new ExecuteResult<DataUtil<MultipleChoiceQuestionDTO>>();
        try {
            if(StringUtils.isEmpty(record)){
                throw new RuntimeException("参数错误：对象非空");
            }
            List<MultipleChoiceQuestionDTO> result = multipleChoiceQuestionDTOMapper.selectList(record,pager);
            Integer total = multipleChoiceQuestionDTOMapper.countTotal(record).intValue();
            DataUtil<MultipleChoiceQuestionDTO> dtoDataUtil = new DataUtil<MultipleChoiceQuestionDTO>();
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
    public ExecuteResult<DataUtil<MultipleChoiceQuestionDTO>> randomSelectMultipleChoiceQuestionList(Pager pager) {
        ExecuteResult<DataUtil<MultipleChoiceQuestionDTO>> executeResult = new ExecuteResult<DataUtil<MultipleChoiceQuestionDTO>>();
        try {
            if(StringUtils.isEmpty(pager)){
                throw new RuntimeException("参数错误：对象非空");
            }
            List<MultipleChoiceQuestionDTO> result = multipleChoiceQuestionDTOMapper.randomSelectMultipleChoiceQuestionList(pager);
            DataUtil<MultipleChoiceQuestionDTO> dtoDataUtil = new DataUtil<MultipleChoiceQuestionDTO>();
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
    public ExecuteResult<DataUtil<MultipleChoiceQuestionDTO>> selectByPrimaryKeyList(List<Integer> keys) {
        ExecuteResult<DataUtil<MultipleChoiceQuestionDTO>> executeResult = new ExecuteResult<DataUtil<MultipleChoiceQuestionDTO>>();
        try {
            if(StringUtils.isEmpty(keys)){
                throw new RuntimeException("参数错误：对象非空");
            }
            List<MultipleChoiceQuestionDTO> result = multipleChoiceQuestionDTOMapper.selectByPrimaryKeyList(keys);
            DataUtil<MultipleChoiceQuestionDTO> dtoDataUtil = new DataUtil<MultipleChoiceQuestionDTO>();
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
    public ExecuteResult<DataUtil<MultipleChoiceQuestionDTO>> checkExercise(List<MultipleChoiceQuestionDTO> record, HttpServletRequest httpServletRequest) {
        ExecuteResult<DataUtil<MultipleChoiceQuestionDTO>> executeResult = new ExecuteResult<DataUtil<MultipleChoiceQuestionDTO>>();
        int userId = UserSecurityContextHolder.getUserId(httpServletRequest);
        int roleType = UserSecurityContextHolder.getUserRoleType();
        try {
            if(StringUtils.isEmpty(record)){
                throw new RuntimeException("参数错误：对象非空");
            }
            Map<Integer,MultipleChoiceQuestionDTO> map = new HashMap<>();
            List<Integer> keys = new ArrayList<>();
            int doubtListSize = record.size();
            for(int i=0;i<doubtListSize;i++){
                keys.add(record.get(i).getId());
                map.put(record.get(i).getId(),record.get(i));
            }
            List<MultipleChoiceQuestionDTO> result = multipleChoiceQuestionDTOMapper.selectByPrimaryKeyList(keys);
            int resultSize = result.size();
            List<WrongBookDTO> wrongBookDTOS = new ArrayList<>();
            for(int j=0;j < resultSize;j++){
                MultipleChoiceQuestionDTO realMultipleChoiceQuestion = result.get(j);
                MultipleChoiceQuestionDTO testMultipleChoiceQuestion = map.get(realMultipleChoiceQuestion.getId());
                /* 判断对错逻辑 */
                if(testMultipleChoiceQuestion.getMultipleChoiceAnswer() != null && testMultipleChoiceQuestion.getMultipleChoiceAnswer().equals(realMultipleChoiceQuestion.getMultipleChoiceAnswer())){
                    testMultipleChoiceQuestion.setTrueOrFalse(1);
                }else{
                    testMultipleChoiceQuestion.setTrueOrFalse(0);
                    WrongBookDTO wrongBookDTO = new WrongBookDTO();
                    wrongBookDTO.setQuestion(realMultipleChoiceQuestion.getMultipleChoiceQuestion());
                    wrongBookDTO.setQuestionOption(realMultipleChoiceQuestion.getMultipleChoiceOption());
                    wrongBookDTO.setAnswer(realMultipleChoiceQuestion.getMultipleChoiceAnswer());
                    if(testMultipleChoiceQuestion.getMultipleChoiceAnswer() == null){
                        wrongBookDTO.setReply("");
                    }else{
                        wrongBookDTO.setReply(testMultipleChoiceQuestion.getMultipleChoiceAnswer());
                    }
                    wrongBookDTO.setUserId(userId);
                    wrongBookDTO.setUserType(roleType);
                    wrongBookDTO.setQuestionId(realMultipleChoiceQuestion.getId());
                    wrongBookDTO.setQuestionType(2);
                    wrongBookDTOS.add(wrongBookDTO);
                }
            }
            if (wrongBookDTOS.size()!=0){
                wrongBookDTOMapper.insertList(wrongBookDTOS);
            }            DataUtil<MultipleChoiceQuestionDTO> dtoDataUtil = new DataUtil<MultipleChoiceQuestionDTO>();
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
    public ExecuteResult<Integer> updateByPrimaryKeySelective(MultipleChoiceQuestionDTO record) {
        ExecuteResult<Integer> executeResult = new ExecuteResult<Integer>();
        try {
            if(StringUtils.isEmpty(record)){
                throw new RuntimeException("参数错误：对象非空");
            }
            Integer result = multipleChoiceQuestionDTOMapper.updateByPrimaryKeySelective(record);
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
    public ExecuteResult<Integer> updateByPrimaryKey(MultipleChoiceQuestionDTO record) {
        ExecuteResult<Integer> executeResult = new ExecuteResult<Integer>();
        try {
            if(StringUtils.isEmpty(record)){
                throw new RuntimeException("参数错误：对象非空");
            }
            Integer result = multipleChoiceQuestionDTOMapper.updateByPrimaryKey(record);
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
