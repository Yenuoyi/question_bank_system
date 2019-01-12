package com.org.bank.controller.teacher;

import com.org.bank.common.DataUtil;
import com.org.bank.common.ExecuteResult;
import com.org.bank.common.WrapMapper;
import com.org.bank.common.Wrapper;
import com.org.bank.config.spring.security.UserSecurityContextHolder;
import com.org.bank.domain.TeacherInfoDTO;
import com.org.bank.service.TeacherInfoService;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 教师角色可访问的教师角色控制类
 */
@RestController
@RequestMapping("/teacher")
public class TeacherInfoController {
    private Logger logger = Logger.getLogger(this.getClass());
    @Resource
    private TeacherInfoService teacherInfoService;


    @RequestMapping("/selectByPrimaryKey")
    public Wrapper<?> selectByPrimaryKey(HttpServletRequest httpServletRequest){
        int userId = UserSecurityContextHolder.getUserId(httpServletRequest);
        TeacherInfoDTO record = new TeacherInfoDTO();
        record.setId(userId);
        ExecuteResult<TeacherInfoDTO> executeResult = teacherInfoService.selectByPrimaryKey(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }


    @RequestMapping("/updateByPrimaryKeySelective")
    public Wrapper<?> updateByPrimaryKeySelective(@RequestBody TeacherInfoDTO record,HttpServletRequest httpServletRequest){
        int userId = UserSecurityContextHolder.getUserId(httpServletRequest);
        record.setId(userId);
        ExecuteResult<Integer> executeResult = teacherInfoService.updateByPrimaryKeySelective(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping("/updateByPrimaryKey")
    public Wrapper<?> updateByPrimaryKey(@RequestBody TeacherInfoDTO record,HttpServletRequest httpServletRequest){
        int userId = UserSecurityContextHolder.getUserId(httpServletRequest);
        record.setId(userId);
        ExecuteResult<Integer> executeResult = teacherInfoService.updateByPrimaryKey(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping("/updatePasswordByPrimaryKey")
    public Wrapper<?> updatePasswordByPrimaryKey(@RequestBody TeacherInfoDTO record,HttpServletRequest httpServletRequest){
        int userId = UserSecurityContextHolder.getUserId(httpServletRequest);
        record.setId(userId);
        ExecuteResult<Integer> executeResult = teacherInfoService.updatePasswordByPrimaryKey(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }
}
