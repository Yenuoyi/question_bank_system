package com.org.bank.controller.all;

import com.org.bank.common.DataUtil;
import com.org.bank.common.ExecuteResult;
import com.org.bank.common.WrapMapper;
import com.org.bank.common.Wrapper;
import com.org.bank.domain.MultipleChoiceQuestionDTO;
import com.org.bank.service.MultipleChoiceQuestionService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 所有人可访问的多选题控制类
 */
@RestController
@RequestMapping("/all/multipleChoiceQuestion")
@Api(description = "学生角色拥有的多选题控制类")
public class MultipleChoiceQuestionController {
    @Autowired
    private MultipleChoiceQuestionService multipleChoiceQuestionService;

    @RequestMapping(value = "/selectByPrimaryKey",method={RequestMethod.POST})
    public Wrapper<?> selectByPrimaryKey(@RequestBody MultipleChoiceQuestionDTO record){
        ExecuteResult<MultipleChoiceQuestionDTO> executeResult = multipleChoiceQuestionService.selectByPrimaryKey(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping(value = "/selectList",method={RequestMethod.POST})
    public Wrapper<?> selectList(@RequestBody MultipleChoiceQuestionDTO record){
        record.setLanguageClassificationStatus(1);
        ExecuteResult<DataUtil<MultipleChoiceQuestionDTO>> executeResult = multipleChoiceQuestionService.selectList(record,record.getPager());
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

}
