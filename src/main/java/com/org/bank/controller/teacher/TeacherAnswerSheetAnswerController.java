package com.org.bank.controller.teacher;

import com.org.bank.common.DataUtil;
import com.org.bank.common.ExecuteResult;
import com.org.bank.common.WrapMapper;
import com.org.bank.common.Wrapper;
import com.org.bank.config.spring.security.UserSecurityContextHolder;
import com.org.bank.domain.AnswerSheetAnswerDTO;
import com.org.bank.domain.AnswerSheetDTO;
import com.org.bank.service.AnswerSheetAnswerService;
import com.org.bank.service.AnswerSheetService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 教师角色拥有的答题卡内容控制器
 */
@RestController
@RequestMapping("/teacher/answerSheetAnswer")
public class TeacherAnswerSheetAnswerController {
    @Resource
    private AnswerSheetService answerSheetService;
    @Resource
    private AnswerSheetAnswerService answerSheetAnswerService;
    @RequestMapping("/deleteByPrimaryKey")
    public Wrapper<?> deleteByPrimaryKey(@RequestBody AnswerSheetAnswerDTO record){
        ExecuteResult<Integer> executeResult = answerSheetAnswerService.deleteByPrimaryKey(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping("/insert")
    public Wrapper<?> insert(@RequestBody AnswerSheetAnswerDTO record){
        ExecuteResult<Integer> executeResult = answerSheetAnswerService.insert(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    /**
     * @param answerSheetAnswerDTO
     * @param httpServletRequest
     * @return
     */
    @RequestMapping("/insertSelective")
    public Wrapper<?> insertSelective(@RequestBody AnswerSheetAnswerDTO answerSheetAnswerDTO, HttpServletRequest httpServletRequest){
        /* 批量插入答题卡内容 */
        ExecuteResult<Integer> executeResult = answerSheetAnswerService.insertSelective(answerSheetAnswerDTO);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping("/selectByPrimaryKey")
    public Wrapper<?> selectByPrimaryKey(@RequestBody AnswerSheetAnswerDTO record){
        ExecuteResult<AnswerSheetAnswerDTO> executeResult = answerSheetAnswerService.selectByPrimaryKey(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping("/selectList")
    public Wrapper<?> selectList(@RequestBody AnswerSheetAnswerDTO record){
        ExecuteResult<DataUtil<AnswerSheetAnswerDTO>> executeResult = answerSheetAnswerService.selectList(record,record.getPager());
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping("/updateByPrimaryKeySelective")
    public Wrapper<?> updateByPrimaryKeySelective(@RequestBody AnswerSheetAnswerDTO record){
        ExecuteResult<Integer> executeResult = answerSheetAnswerService.updateByPrimaryKeySelective(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping("/updateByPrimaryKey")
    public Wrapper<?> updateByPrimaryKey(@RequestBody AnswerSheetAnswerDTO record){
        ExecuteResult<Integer> executeResult = answerSheetAnswerService.updateByPrimaryKey(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    /**
     * 关联表查询试卷原题与答题卡
     * @param record
     * @return
     */
    @RequestMapping("/selectPaperSheetList")
    public Wrapper<?> selectPaperSheetList(@RequestBody AnswerSheetAnswerDTO record){
        ExecuteResult<DataUtil<AnswerSheetAnswerDTO>> executeResult = answerSheetAnswerService.selectPaperSheetList(record,record.getPager());
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }
}
