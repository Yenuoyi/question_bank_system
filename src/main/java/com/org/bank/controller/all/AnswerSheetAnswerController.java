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
 * 所有角色拥有的答题卡控制器
 */
@RestController
@RequestMapping("/all/answerSheetAnswer")
@Api(description = "学生角色拥有的答题卡控制器")
public class AnswerSheetAnswerController {
    @Resource
    private AnswerSheetService answerSheetService;
    @Resource
    private AnswerSheetAnswerService answerSheetAnswerService;

    /**
     * @param answerSheetAnswerDTO
     * @param httpServletRequest
     * @return
     */
    @RequestMapping(value = "/insertSelective",method={RequestMethod.POST})
    public Wrapper<?> insertSelective(@RequestBody AnswerSheetAnswerDTO answerSheetAnswerDTO, HttpServletRequest httpServletRequest){
        /* 批量插入答题卡内容 */
        ExecuteResult<Integer> executeResult = answerSheetAnswerService.insertSelective(answerSheetAnswerDTO);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping(value = "/selectByPrimaryKey",method={RequestMethod.POST})
    public Wrapper<?> selectByPrimaryKey(@RequestBody AnswerSheetAnswerDTO record){
        ExecuteResult<AnswerSheetAnswerDTO> executeResult = answerSheetAnswerService.selectByPrimaryKey(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping(value = "/selectList",method={RequestMethod.POST})
    public Wrapper<?> selectList(@RequestBody AnswerSheetAnswerDTO record){
        ExecuteResult<DataUtil<AnswerSheetAnswerDTO>> executeResult = answerSheetAnswerService.selectList(record,record.getPager());
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
    @RequestMapping(value = "/selectPaperSheetList",method={RequestMethod.POST})
    public Wrapper<?> selectPaperSheetList(@RequestBody AnswerSheetAnswerDTO record){
        ExecuteResult<DataUtil<AnswerSheetAnswerDTO>> executeResult = answerSheetAnswerService.selectPaperSheetList(record,record.getPager());
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }
}
