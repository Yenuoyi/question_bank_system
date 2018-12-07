package com.org.bank.controller.admin;

import com.org.bank.common.DataUtil;
import com.org.bank.common.ExecuteResult;
import com.org.bank.common.WrapMapper;
import com.org.bank.common.Wrapper;
import com.org.bank.domain.ExaminationPaperQuestionDTO;
import com.org.bank.service.ExaminationPaperQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 试卷题目控制器
 */
@RestController
@RequestMapping("/admin/examinationPaperQuestion")
public class AdminExaminationPaperQuestionController {
    @Autowired
    private ExaminationPaperQuestionService examinationPaperQuestionService;
    @RequestMapping("/deleteByPrimaryKey")
    public Wrapper<?> deleteByPrimaryKey(@RequestBody ExaminationPaperQuestionDTO record){
        ExecuteResult<Integer> executeResult = examinationPaperQuestionService.deleteByPrimaryKey(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping("insert")
    public Wrapper<?> insert(@RequestBody ExaminationPaperQuestionDTO record){
        ExecuteResult<Integer> executeResult = examinationPaperQuestionService.insert(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping("insertSelective")
    public Wrapper<?> insertSelective(@RequestBody ExaminationPaperQuestionDTO record){
        ExecuteResult<Integer> executeResult = examinationPaperQuestionService.insertSelective(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping("/selectByPrimaryKey")
    public Wrapper<?> selectByPrimaryKey(@RequestBody ExaminationPaperQuestionDTO record){
        ExecuteResult<ExaminationPaperQuestionDTO> executeResult = examinationPaperQuestionService.selectByPrimaryKey(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping("/selectList")
    public Wrapper<?> selectList(@RequestBody ExaminationPaperQuestionDTO record){
        ExecuteResult<DataUtil<ExaminationPaperQuestionDTO>> executeResult = examinationPaperQuestionService.selectList(record,record.getPager());
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping("/updateByPrimaryKeySelective")
    public Wrapper<?> updateByPrimaryKeySelective(@RequestBody ExaminationPaperQuestionDTO record){
        ExecuteResult<Integer> executeResult = examinationPaperQuestionService.updateByPrimaryKeySelective(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping("/updateByPrimaryKey")
    public Wrapper<?> updateByPrimaryKey(@RequestBody ExaminationPaperQuestionDTO record){
        ExecuteResult<Integer> executeResult = examinationPaperQuestionService.updateByPrimaryKey(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }
}
