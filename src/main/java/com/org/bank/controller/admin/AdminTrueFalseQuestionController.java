package com.org.bank.controller.admin;

import com.org.bank.common.DataUtil;
import com.org.bank.common.ExecuteResult;
import com.org.bank.common.WrapMapper;
import com.org.bank.common.Wrapper;
import com.org.bank.domain.TrueFalseQuestionDTO;
import com.org.bank.service.TrueFalseQuestionService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 判断题控制类
 */
@RestController
@RequestMapping("/admin/trueFalseQuestion")
@Api(description = "管理员角色拥有的判断题控制类")
public class AdminTrueFalseQuestionController {
    @Autowired
    private TrueFalseQuestionService trueFalseQuestionService;
    @RequestMapping(value = "/deleteByPrimaryKey",method={RequestMethod.POST})
    public Wrapper<?> deleteByPrimaryKey(@RequestBody TrueFalseQuestionDTO record){
        ExecuteResult<Integer> executeResult = trueFalseQuestionService.deleteByPrimaryKey(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping(value = "/insert",method={RequestMethod.POST})
    public Wrapper<?> insert(@RequestBody TrueFalseQuestionDTO record){
        ExecuteResult<Integer> executeResult = trueFalseQuestionService.insert(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping(value = "/insertSelective",method={RequestMethod.POST})
    public Wrapper<?> insertSelective(@RequestBody TrueFalseQuestionDTO record){
        ExecuteResult<Integer> executeResult = trueFalseQuestionService.insertSelective(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping(value = "/selectByPrimaryKey",method={RequestMethod.POST})
    public Wrapper<?> selectByPrimaryKey(@RequestBody TrueFalseQuestionDTO record){
        ExecuteResult<TrueFalseQuestionDTO> executeResult = trueFalseQuestionService.selectByPrimaryKey(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping(value = "/selectList",method={RequestMethod.POST})
    public Wrapper<?> selectList(@RequestBody TrueFalseQuestionDTO record){
        ExecuteResult<DataUtil<TrueFalseQuestionDTO>> executeResult = trueFalseQuestionService.selectList(record,record.getPager());
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping(value = "/updateByPrimaryKeySelective",method={RequestMethod.POST})
    public Wrapper<?> updateByPrimaryKeySelective(@RequestBody TrueFalseQuestionDTO record){
        ExecuteResult<Integer> executeResult = trueFalseQuestionService.updateByPrimaryKeySelective(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping(value = "/updateByPrimaryKey",method={RequestMethod.POST})
    public Wrapper<?> updateByPrimaryKey(@RequestBody TrueFalseQuestionDTO record){
        ExecuteResult<Integer> executeResult = trueFalseQuestionService.updateByPrimaryKey(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }
}
