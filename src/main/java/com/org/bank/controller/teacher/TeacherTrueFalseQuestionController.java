package com.org.bank.controller.teacher;

import com.org.bank.common.DataUtil;
import com.org.bank.common.ExecuteResult;
import com.org.bank.common.WrapMapper;
import com.org.bank.common.Wrapper;
import com.org.bank.domain.TrueFalseQuestionDTO;
import com.org.bank.service.TrueFalseQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 教师角色可访问的判断题控制类
 */
@RestController
@RequestMapping("/teacher/trueFalseQuestion")
public class TeacherTrueFalseQuestionController {
    @Autowired
    private TrueFalseQuestionService trueFalseQuestionService;
    @RequestMapping("/deleteByPrimaryKey")
    public Wrapper<?> deleteByPrimaryKey(@RequestBody TrueFalseQuestionDTO record){
        ExecuteResult<Integer> executeResult = trueFalseQuestionService.deleteByPrimaryKey(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping("insert")
    public Wrapper<?> insert(@RequestBody TrueFalseQuestionDTO record){
        ExecuteResult<Integer> executeResult = trueFalseQuestionService.insert(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping("insertSelective")
    public Wrapper<?> insertSelective(@RequestBody TrueFalseQuestionDTO record){
        ExecuteResult<Integer> executeResult = trueFalseQuestionService.insertSelective(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping("/selectByPrimaryKey")
    public Wrapper<?> selectByPrimaryKey(@RequestBody TrueFalseQuestionDTO record){
        ExecuteResult<TrueFalseQuestionDTO> executeResult = trueFalseQuestionService.selectByPrimaryKey(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping("/selectList")
    public Wrapper<?> selectList(@RequestBody TrueFalseQuestionDTO record){
        ExecuteResult<DataUtil<TrueFalseQuestionDTO>> executeResult = trueFalseQuestionService.selectList(record,record.getPager());
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping("/updateByPrimaryKeySelective")
    public Wrapper<?> updateByPrimaryKeySelective(@RequestBody TrueFalseQuestionDTO record){
        ExecuteResult<Integer> executeResult = trueFalseQuestionService.updateByPrimaryKeySelective(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping("/updateByPrimaryKey")
    public Wrapper<?> updateByPrimaryKey(@RequestBody TrueFalseQuestionDTO record){
        ExecuteResult<Integer> executeResult = trueFalseQuestionService.updateByPrimaryKey(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }
}
