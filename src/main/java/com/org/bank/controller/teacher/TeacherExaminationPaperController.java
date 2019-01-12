package com.org.bank.controller.teacher;

import com.org.bank.common.DataUtil;
import com.org.bank.common.ExecuteResult;
import com.org.bank.common.WrapMapper;
import com.org.bank.common.Wrapper;
import com.org.bank.config.spring.security.UserSecurityContextHolder;
import com.org.bank.domain.ExaminationPaperDTO;
import com.org.bank.domain.ExaminationPaperQuestionDTO;
import com.org.bank.service.ExaminationPaperQuestionService;
import com.org.bank.service.ExaminationPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 教师角色可访问的试库控制类
 */
@RestController
@RequestMapping("/teacher/examinationPaper")
public class TeacherExaminationPaperController {
    @Autowired
    private ExaminationPaperService examinationPaperService;
    @Resource
    private ExaminationPaperQuestionService examinationPaperQuestionService;
    @RequestMapping("/deleteByPrimaryKey")
    public Wrapper<?> deleteByPrimaryKey(@RequestBody ExaminationPaperDTO record){
        /* 删除试卷头 */
        ExecuteResult<Integer> executeResult = examinationPaperService.deleteByPrimaryKey(record);
        /* 删除试卷内容 */
        ExaminationPaperQuestionDTO examinationPaperQuestionDTO = new ExaminationPaperQuestionDTO();
        examinationPaperQuestionDTO.setOriginalExaminationPaperId(record.getId());
        examinationPaperQuestionService.deleteByPaperId(examinationPaperQuestionDTO);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping("insert")
    public Wrapper<?> insert(@RequestBody ExaminationPaperDTO record, HttpServletRequest httpServletRequest){
        record.setExaminerId(UserSecurityContextHolder.getUserId(httpServletRequest));
        record.setExaminerType(UserSecurityContextHolder.getUserRoleType());
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
    @RequestMapping("insertSelective")
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

    @RequestMapping("/selectByPrimaryKey")
    public Wrapper<?> selectByPrimaryKey(@RequestBody ExaminationPaperDTO record){
        ExecuteResult<ExaminationPaperDTO> executeResult = examinationPaperService.selectByPrimaryKey(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping("/selectList")
    public Wrapper<?> selectList(@RequestBody ExaminationPaperDTO record,HttpServletRequest httpServletRequest){
        record.setExaminerId(UserSecurityContextHolder.getUserId(httpServletRequest));
        record.setExaminerType(UserSecurityContextHolder.getUserRoleType());
        ExecuteResult<DataUtil<ExaminationPaperDTO>> executeResult = examinationPaperService.selectList(record,record.getPager());
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping("/updateByPrimaryKeySelective")
    public Wrapper<?> updateByPrimaryKeySelective(@RequestBody ExaminationPaperDTO record){
        ExecuteResult<Integer> executeResult = examinationPaperService.updateByPrimaryKeySelective(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping("/updateByPrimaryKey")
    public Wrapper<?> updateByPrimaryKey(@RequestBody ExaminationPaperDTO record){
        ExecuteResult<Integer> executeResult = examinationPaperService.updateByPrimaryKey(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }
}
