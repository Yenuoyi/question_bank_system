package com.org.bank.controller.all;

import com.org.bank.common.DataUtil;
import com.org.bank.common.ExecuteResult;
import com.org.bank.common.WrapMapper;
import com.org.bank.common.Wrapper;
import com.org.bank.config.spring.security.UserSecurityContextHolder;
import com.org.bank.domain.TeacherInfoDTO;
import com.org.bank.service.TeacherInfoService;
import io.swagger.annotations.Api;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 教师控制器
 */
@RestController
@RequestMapping("/all/teacher")
@Api(description = "学生角色拥有的教师控制器")
public class AllTeacherInfoController {
    private Logger logger = Logger.getLogger(this.getClass());
    @Resource
    private TeacherInfoService teacherInfoService;

    @RequestMapping(value = "/selectByPrimaryKey",method={RequestMethod.POST})
    public Wrapper<?> selectByPrimaryKey(@RequestBody TeacherInfoDTO record){
        ExecuteResult<TeacherInfoDTO> executeResult = teacherInfoService.selectByPrimaryKey(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping(value = "/selectList",method={RequestMethod.POST})
    public Wrapper<?> selectList(@RequestBody TeacherInfoDTO record){
        ExecuteResult<DataUtil<TeacherInfoDTO>> executeResult = teacherInfoService.selectList(record,record.getPager());
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }
}
