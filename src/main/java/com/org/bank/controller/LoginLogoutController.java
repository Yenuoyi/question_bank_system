package com.org.bank.controller;

import com.org.bank.common.ExecuteResult;
import com.org.bank.common.WrapMapper;
import com.org.bank.common.Wrapper;
import com.org.bank.common.encrypt.Md5Util;
import com.org.bank.domain.AdminInfoDTO;
import com.org.bank.domain.StudentInfoDTO;
import com.org.bank.domain.TeacherInfoDTO;
import com.org.bank.service.AdminInfoService;
import com.org.bank.service.StudentInfoService;
import com.org.bank.service.TeacherInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
public class LoginLogoutController {
    @Autowired
    private AdminInfoService adminInfoService;
    @Resource
    private TeacherInfoService teacherInfoService;
    @Resource
    private StudentInfoService studentInfoService;
    @RequestMapping("/adminLogin")
    public Wrapper<?> adminLogin(@RequestBody AdminInfoDTO record){
        ExecuteResult<AdminInfoDTO> executeResult = adminInfoService.selectByPrimaryKey(record);
        AdminInfoDTO result = executeResult.getResult();
        if(!executeResult.isSuccess()){
            return WrapMapper.error().result(executeResult);
        }
        if(executeResult.getResult()==null){
            return WrapMapper.error().result("查无此账号！");
        }
        String encodePassword = Md5Util.encode(record.getAdminPassword());
        if(!encodePassword.equals(result.getAdminPassword())){
            return WrapMapper.error().result("密码错误！");
        }
        return WrapMapper.ok().result(executeResult);
    }
    @RequestMapping("/teacherLogin")
    public Wrapper<?> teacherLogin(@RequestBody TeacherInfoDTO record){
        ExecuteResult<TeacherInfoDTO> executeResult = teacherInfoService.selectByPrimaryKey(record);
        TeacherInfoDTO result = executeResult.getResult();
        if(!executeResult.isSuccess()){
            return WrapMapper.error().result(executeResult);
        }
        if(executeResult.getResult()==null){
            return WrapMapper.error().result("查无此账号！");
        }
        String encodePassword = Md5Util.encode(record.getTeacherPassword());
        if(!encodePassword.equals(result.getTeacherPassword())){
            return WrapMapper.error().result("密码错误！");
        }
        return WrapMapper.ok().result(executeResult);
    }
    @RequestMapping("/login")
    public Wrapper<?> login(@RequestBody StudentInfoDTO record){
        ExecuteResult<StudentInfoDTO> executeResult = studentInfoService.selectByPrimaryKey(record);
        StudentInfoDTO result = executeResult.getResult();
        if(!executeResult.isSuccess()){
            return WrapMapper.error().result(executeResult);
        }
        if(executeResult.getResult()==null){
            return WrapMapper.error().result("查无此账号！");
        }
        String encodePassword = Md5Util.encode(record.getStudentPassword());
        if(!encodePassword.equals(result.getStudentPassword())){
            return WrapMapper.error().result("密码错误！");
        }
        return WrapMapper.ok().result(executeResult);
    }

    @RequestMapping("/logout")
    public Wrapper<?> logout(HttpServletRequest request){
        ExecuteResult<Integer> executeResult = new ExecuteResult<>();
        request.removeAttribute("");
        return WrapMapper.ok().result(executeResult);
    }
}
