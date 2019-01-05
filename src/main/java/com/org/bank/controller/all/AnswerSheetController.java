package com.org.bank.controller.all;

import com.org.bank.common.DataUtil;
import com.org.bank.common.ExecuteResult;
import com.org.bank.common.WrapMapper;
import com.org.bank.common.Wrapper;
import com.org.bank.domain.AnswerSheetDTO;
import com.org.bank.service.AnswerSheetService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 所有角色拥有的答题卡内容控制器
 */
@RestController
@RequestMapping("/all/answerSheet")
public class AnswerSheetController {
    @Resource
    private AnswerSheetService answerSheetService;

    @RequestMapping("/insert")
    public Wrapper<?> insert(@RequestBody AnswerSheetDTO record){
        ExecuteResult<Integer> executeResult = answerSheetService.insert(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping("/insertSelective")
    public Wrapper<?> insertSelective(@RequestBody AnswerSheetDTO record){
        ExecuteResult<Integer> executeResult = answerSheetService.insertSelective(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping("/selectByPrimaryKey")
    public Wrapper<?> selectByPrimaryKey(@RequestBody AnswerSheetDTO record){
        ExecuteResult<AnswerSheetDTO> executeResult = answerSheetService.selectByPrimaryKey(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping("/selectList")
    public Wrapper<?> selectList(@RequestBody AnswerSheetDTO record){
        ExecuteResult<DataUtil<AnswerSheetDTO>> executeResult = answerSheetService.selectList(record,record.getPager());
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }
}
