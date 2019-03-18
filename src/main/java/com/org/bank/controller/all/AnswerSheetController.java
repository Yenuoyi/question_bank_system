package com.org.bank.controller.all;

import com.org.bank.common.DataUtil;
import com.org.bank.common.ExecuteResult;
import com.org.bank.common.WrapMapper;
import com.org.bank.common.Wrapper;
import com.org.bank.config.spring.security.UserSecurityContextHolder;
import com.org.bank.domain.AnswerSheetAnswerDTO;
import com.org.bank.domain.AnswerSheetDTO;
import com.org.bank.service.AnswerSheetAnswerService;
import com.org.bank.service.AnswerSheetService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 所有角色拥有的答题卡内容控制器
 */
@RestController
@RequestMapping("/all/answerSheet")
@Api(description = "学生角色拥有的答题卡内容控制器")
public class AnswerSheetController {
    @Resource
    private AnswerSheetService answerSheetService;
    @Resource
    private AnswerSheetAnswerService answerSheetAnswerService;

    @RequestMapping(value = "/insert",method={RequestMethod.POST})
    public Wrapper<?> insert(@RequestBody AnswerSheetDTO record){
        ExecuteResult<Integer> executeResult = answerSheetService.insert(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping(value = "/insertSelective",method={RequestMethod.POST})
    public Wrapper<?> insertSelective(@RequestBody AnswerSheetDTO record, HttpServletRequest httpServletRequest){
        /* 设置答题卡生成入参,生成答题卡 */
        record.setAnswererType(UserSecurityContextHolder.getUserRoleType());
        record.setAnswerId(UserSecurityContextHolder.getUserId(httpServletRequest));
        record.setAnswererName(UserSecurityContextHolder.getUsername());
        ExecuteResult<Integer> integerExecuteResult = answerSheetService.insertSelective(record);
        List<AnswerSheetAnswerDTO> answerSheetAnswerDTOS = record.getAnswerSheetAnswerDTOS();
        /* 批量插入答题卡内容 */
        for(int i=0;i<answerSheetAnswerDTOS.size();i++){
            answerSheetAnswerDTOS.get(i).setAnswerSheetId(record.getId());
        }
        ExecuteResult<Integer> executeResult = answerSheetAnswerService.insertList(answerSheetAnswerDTOS);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping(value = "/selectByPrimaryKey",method={RequestMethod.POST})
    public Wrapper<?> selectByPrimaryKey(@RequestBody AnswerSheetDTO record){
        ExecuteResult<AnswerSheetDTO> executeResult = answerSheetService.selectByPrimaryKey(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping(value = "/selectList",method={RequestMethod.POST})
    public Wrapper<?> selectList(@RequestBody AnswerSheetDTO record){
        ExecuteResult<DataUtil<AnswerSheetDTO>> executeResult = answerSheetService.selectList(record,record.getPager());
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    /**
     * 关联查询试题表和答卷表
     * @param record
     * @return
     */
    @RequestMapping(value = "/selectSheetPaperList",method={RequestMethod.POST})
    public Wrapper<?> selectSheetPaperList(@RequestBody AnswerSheetDTO record,HttpServletRequest httpServletRequest){
        record.setAnswererType(UserSecurityContextHolder.getUserRoleType());
        record.setAnswerId(UserSecurityContextHolder.getUserId(httpServletRequest));
        ExecuteResult<DataUtil<AnswerSheetDTO>> executeResult = answerSheetService.selectSheetPaperList(record,record.getPager());
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }
}
