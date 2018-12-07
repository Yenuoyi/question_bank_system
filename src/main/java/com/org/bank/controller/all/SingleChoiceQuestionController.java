package com.org.bank.controller.all;

import com.org.bank.common.DataUtil;
import com.org.bank.common.ExecuteResult;
import com.org.bank.common.WrapMapper;
import com.org.bank.common.Wrapper;
import com.org.bank.domain.SingleChoiceQuestionDTO;
import com.org.bank.service.SingleChoiceQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 所有人可访问的单选题控制类
 */
@RestController
@RequestMapping("/all/singleChoiceQuestion")
public class SingleChoiceQuestionController {
    @Autowired
    private SingleChoiceQuestionService singleChoiceQuestionService;
    @RequestMapping("/selectByPrimaryKey")
    public Wrapper<?> selectByPrimaryKey(@RequestBody SingleChoiceQuestionDTO record){
        ExecuteResult<SingleChoiceQuestionDTO> executeResult = singleChoiceQuestionService.selectByPrimaryKey(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping("/selectList")
    public Wrapper<?> selectList(@RequestBody SingleChoiceQuestionDTO record){
        ExecuteResult<DataUtil<SingleChoiceQuestionDTO>> executeResult = singleChoiceQuestionService.selectList(record,record.getPager());
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }
}
