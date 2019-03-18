package com.org.bank.controller.all;

import com.org.bank.common.DataUtil;
import com.org.bank.common.ExecuteResult;
import com.org.bank.common.WrapMapper;
import com.org.bank.common.Wrapper;
import com.org.bank.domain.ExaminationPaperQuestionDTO;
import com.org.bank.service.ExaminationPaperQuestionService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 所有人可访问的试卷问题控制类
 */
@RestController
@RequestMapping("/all/examinationPaperQuestion")
@Api(description = "学生角色拥有的试卷问题控制类")
public class ExaminationPaperQuestionController {
    @Autowired
    private ExaminationPaperQuestionService examinationPaperQuestionService;

    @RequestMapping(value = "/selectByPrimaryKey",method={RequestMethod.POST})
    public Wrapper<?> selectByPrimaryKey(@RequestBody ExaminationPaperQuestionDTO record){
        ExecuteResult<ExaminationPaperQuestionDTO> executeResult = examinationPaperQuestionService.selectByPrimaryKey(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping(value = "/selectList",method={RequestMethod.POST})
    public Wrapper<?> selectList(@RequestBody ExaminationPaperQuestionDTO record){
        ExecuteResult<DataUtil<ExaminationPaperQuestionDTO>> executeResult = examinationPaperQuestionService.selectList(record,record.getPager());
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

}
