package com.org.bank.controller.admin;

import com.alibaba.fastjson.JSONObject;
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
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 管理员角色拥有的答卷控制器
 */
@RestController
@RequestMapping("/admin/answerSheetAnswer")
@Api(description = "管理员角色拥有的答卷控制器")
public class AdminAnswerSheetAnswerController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private AnswerSheetService answerSheetService;
    @Resource
    private AnswerSheetAnswerService answerSheetAnswerService;
    @RequestMapping(value = "/deleteByPrimaryKey",method={RequestMethod.POST})
    @ApiOperation(value = "根据答题卡id删除答题卡", httpMethod = "POST", response = Wrapper.class, notes = "根据答题卡id删除答题卡")
    public Wrapper<?> deleteByPrimaryKey(@RequestBody AnswerSheetAnswerDTO record){
        ExecuteResult<Integer> executeResult = answerSheetAnswerService.deleteByPrimaryKey(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping(value = "/insert",method={RequestMethod.POST})
    public Wrapper<?> insert(@RequestBody AnswerSheetAnswerDTO record){
        ExecuteResult<Integer> executeResult = answerSheetAnswerService.insert(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    /**
     * 答题调用此接口
     * @param records
     * @param httpServletRequest
     * @return
     */
    @RequestMapping(value = "/insertSelective",method={RequestMethod.POST})
    public Wrapper<?> insertSelective(@RequestBody List<AnswerSheetAnswerDTO> records, HttpServletRequest httpServletRequest){
        /* 设置答题卡生成入参,生成答题卡 */
        AnswerSheetDTO answerSheetDTO = new AnswerSheetDTO();
        answerSheetDTO.setAnswererType(UserSecurityContextHolder.getUserRoleType());
        answerSheetDTO.setAnswerId(UserSecurityContextHolder.getUserId(httpServletRequest));
        ExecuteResult<Integer> integerExecuteResult = answerSheetService.insertSelective(answerSheetDTO);
        /* 批量插入答题卡内容 */
        ExecuteResult<Integer> executeResult = answerSheetAnswerService.insertList(records);
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


    @RequestMapping(value = "/updateByPrimaryKeySelective",method={RequestMethod.POST})
    public Wrapper<?> updateByPrimaryKeySelective(@RequestBody AnswerSheetAnswerDTO record){
        ExecuteResult<Integer> executeResult = answerSheetAnswerService.updateByPrimaryKeySelective(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping(value = "/updateByPrimaryKey",method={RequestMethod.POST})
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
    @RequestMapping(value = "/selectPaperSheetList",method={RequestMethod.POST})
    public Wrapper<?> selectPaperSheetList(@RequestBody AnswerSheetAnswerDTO record){
        logger.info("入参：{}", JSONObject.toJSON(record));
        ExecuteResult<DataUtil<AnswerSheetAnswerDTO>> executeResult = answerSheetAnswerService.selectPaperSheetList(record,record.getPager());
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }
}
