package com.org.bank.controller.admin;

import com.org.bank.common.DataUtil;
import com.org.bank.common.ExecuteResult;
import com.org.bank.common.WrapMapper;
import com.org.bank.common.Wrapper;
import com.org.bank.config.spring.security.UserSecurityContextHolder;
import com.org.bank.domain.ExaminationPaperDTO;
import com.org.bank.domain.ExaminationPaperQuestionDTO;
import com.org.bank.service.ExaminationPaperQuestionService;
import com.org.bank.service.ExaminationPaperService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 试卷库控制器
 */
@RestController
@RequestMapping("/admin/examinationPaper")
@Api(description = "管理员角色拥有的试卷库控制器")
public class AdminExaminationPaperController {
    @Autowired
    private ExaminationPaperService examinationPaperService;
    @Resource
    private ExaminationPaperQuestionService examinationPaperQuestionService;
    @RequestMapping(value = "/deleteByPrimaryKey",method={RequestMethod.POST})
    public Wrapper<?> deleteByPrimaryKey(@RequestBody ExaminationPaperDTO record){
        ExecuteResult<Integer> executeResult = examinationPaperService.deleteByPrimaryKey(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping(value = "insert",method={RequestMethod.POST})
    public Wrapper<?> insert(@RequestBody ExaminationPaperDTO record){
        ExecuteResult<Integer> executeResult = examinationPaperService.insert(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    /**
     * 生成试卷控制器
     * @param record
     * @param httpServletRequest
     * @return
     */
    @RequestMapping(value = "insertSelective",method={RequestMethod.POST})
    public Wrapper<?> insertSelective(@RequestBody ExaminationPaperDTO record, HttpServletRequest httpServletRequest){
        record.setExaminerId(UserSecurityContextHolder.getUserId(httpServletRequest));
        record.setExaminerType(UserSecurityContextHolder.getUserRoleType());
        examinationPaperService.insertSelective(record);

        /* 开始插入试卷内容 */
        List<ExaminationPaperQuestionDTO> examinationPaperQuestionDTOList = record.getExaminationPaperQuestionDTOList();
        for(int i=0;i<examinationPaperQuestionDTOList.size();i++){
            examinationPaperQuestionDTOList.get(i).setOriginalExaminationPaperId(record.getId());
        }
        ExecuteResult<Integer> executeResult = examinationPaperQuestionService.insertList(examinationPaperQuestionDTOList);

        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping(value = "/selectByPrimaryKey",method={RequestMethod.POST})
    public Wrapper<?> selectByPrimaryKey(@RequestBody ExaminationPaperDTO record){
        ExecuteResult<ExaminationPaperDTO> executeResult = examinationPaperService.selectByPrimaryKey(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping(value = "/selectList",method={RequestMethod.POST})
    public Wrapper<?> selectList(@RequestBody ExaminationPaperDTO record){
        ExecuteResult<DataUtil<ExaminationPaperDTO>> executeResult = examinationPaperService.selectList(record,record.getPager());
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping(value = "/updateByPrimaryKeySelective",method={RequestMethod.POST})
    public Wrapper<?> updateByPrimaryKeySelective(@RequestBody ExaminationPaperDTO record){
        ExecuteResult<Integer> executeResult = examinationPaperService.updateByPrimaryKeySelective(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping(value = "/updateByPrimaryKey",method={RequestMethod.POST})
    public Wrapper<?> updateByPrimaryKey(@RequestBody ExaminationPaperDTO record){
        ExecuteResult<Integer> executeResult = examinationPaperService.updateByPrimaryKey(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }
}
