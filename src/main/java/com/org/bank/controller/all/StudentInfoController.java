package com.org.bank.controller.all;

import com.org.bank.common.DataUtil;
import com.org.bank.common.ExecuteResult;
import com.org.bank.common.WrapMapper;
import com.org.bank.common.Wrapper;
import com.org.bank.config.spring.security.UserSecurityContextHolder;
import com.org.bank.domain.StudentInfoDTO;
import com.org.bank.service.StudentInfoService;
import io.swagger.annotations.Api;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 所有人可访问的学生控制类
 */
@RestController
@RequestMapping("/all/student")
@Api(description = "学生角色拥有的学生控制类")
public class StudentInfoController {
    private Logger logger = Logger.getLogger(this.getClass());
    @Resource
    private StudentInfoService studentInfoService;

    @RequestMapping(value = "insert",method={RequestMethod.POST})
    public Wrapper<?> insert(@RequestBody StudentInfoDTO record){
        StudentInfoDTO studentInfoDTO = new StudentInfoDTO();
        studentInfoDTO.setStudentEmail(record.getStudentEmail());
        ExecuteResult<DataUtil<StudentInfoDTO>> dataUtilExecuteResult = studentInfoService.selectList(studentInfoDTO, null);
        if(dataUtilExecuteResult.getResult().getList() != null && dataUtilExecuteResult.getResult().getList().size() > 0){
            return WrapMapper.error().result("请勿重复注册！");
        }
        /* 设置默认状态1启用*/
        record.setStatus(1);
        ExecuteResult<Integer> executeResult = studentInfoService.insert(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping(value = "insertSelective",method={RequestMethod.POST})
    public Wrapper<?> insertSelective(@RequestBody StudentInfoDTO record){
        StudentInfoDTO studentInfoDTO = new StudentInfoDTO();
        studentInfoDTO.setStudentEmail(record.getStudentEmail());

        ExecuteResult<DataUtil<StudentInfoDTO>> dataUtilExecuteResult = studentInfoService.selectList(studentInfoDTO, null);
        if(dataUtilExecuteResult.getResult().getList() != null && dataUtilExecuteResult.getResult().getList().size() > 0){
            return WrapMapper.error().result("请勿重复注册！");
        }
        /* 设置默认状态1启用*/
        record.setStatus(1);
        ExecuteResult<Integer> executeResult = studentInfoService.insertSelective(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping(value = "/selectByPrimaryKey",method={RequestMethod.POST})
    public Wrapper<?> selectByPrimaryKey(HttpServletRequest httpServletRequest){
        int userId = UserSecurityContextHolder.getUserId(httpServletRequest);
        StudentInfoDTO record = new StudentInfoDTO();
        record.setId(userId);
        ExecuteResult<StudentInfoDTO> executeResult = studentInfoService.selectByPrimaryKey(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }


    @RequestMapping(value = "/updateByPrimaryKeySelective",method={RequestMethod.POST})
    public Wrapper<?> updateByPrimaryKeySelective(@RequestBody StudentInfoDTO record, HttpServletRequest httpServletRequest){
        int userId = UserSecurityContextHolder.getUserId(httpServletRequest);
        record.setId(userId);
        ExecuteResult<Integer> executeResult = studentInfoService.updateByPrimaryKeySelective(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping(value = "/updateByPrimaryKey",method={RequestMethod.POST})
    public Wrapper<?> updateByPrimaryKey(@RequestBody StudentInfoDTO record,HttpServletRequest httpServletRequest){
        int userId = UserSecurityContextHolder.getUserId(httpServletRequest);
        record.setId(userId);
        ExecuteResult<Integer> executeResult = studentInfoService.updateByPrimaryKey(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }

    @RequestMapping(value = "/updatePasswordByPrimaryKey",method={RequestMethod.POST})
    public Wrapper<?> updatePasswordByPrimaryKey(@RequestBody StudentInfoDTO record,HttpServletRequest httpServletRequest){
        int userId = UserSecurityContextHolder.getUserId(httpServletRequest);
        record.setId(userId);
        ExecuteResult<Integer> executeResult = studentInfoService.updatePasswordByPrimaryKey(record);
        if(executeResult.isSuccess()){
            return WrapMapper.ok().result(executeResult);
        }
        return WrapMapper.error().result(executeResult);
    }
}
