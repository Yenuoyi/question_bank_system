package com.org.bank.controller;

import com.org.bank.common.ExecuteResult;
import com.org.bank.common.Role;
import com.org.bank.common.WrapMapper;
import com.org.bank.common.Wrapper;
import com.org.bank.common.encrypt.Md5Util;
import com.org.bank.domain.AdminInfoDTO;
import com.org.bank.domain.LoginDTO;
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
import javax.servlet.http.HttpServletRequest;

@RestController
public class LoginLogoutController {
    @Autowired
    private AdminInfoService adminInfoService;
    @Resource
    private TeacherInfoService teacherInfoService;
    @Resource
    private StudentInfoService studentInfoService;
    @RequestMapping("/login")
    public Wrapper<?> login(@RequestBody LoginDTO record){
        Wrapper wrapper = null;
        switch (record.getRole()){
            case Role.ADMIN :
                AdminInfoDTO adminInfoDTO = new AdminInfoDTO();
                adminInfoDTO.setId(Integer.parseInt(record.getUsername()));
                wrapper = this.adminCheck(record,adminInfoDTO);
                break;
            case Role.TEACHER:
                TeacherInfoDTO teacherInfoDTO = new TeacherInfoDTO();
                teacherInfoDTO.setId(Integer.parseInt(record.getUsername()));
                wrapper = this.teacherCheck(record,teacherInfoDTO);
                break;
            case Role.STUDENT:
                StudentInfoDTO studentInfoDTO = new StudentInfoDTO();
                studentInfoDTO.setId(Integer.parseInt(record.getUsername()));
                wrapper = this.studentCheck(record,studentInfoDTO);
                break;
        }
        return wrapper;
    }

    private Wrapper adminCheck(LoginDTO record, AdminInfoDTO adminInfoDTO){
        ExecuteResult<AdminInfoDTO> executeResult = adminInfoService.selectByPrimaryKey(adminInfoDTO);
        if(!executeResult.isSuccess()){
            return WrapMapper.error().result(executeResult);
        }
        if(executeResult.getResult()==null){
            return WrapMapper.error().result("查无此账号！");
        }
        AdminInfoDTO result = executeResult.getResult();
        String encodePassword = Md5Util.encode(record.getPassword());
        if(!encodePassword.equals(result.getAdminPassword())){
            return WrapMapper.error().result("密码错误！");
        }
        return WrapMapper.ok().result(executeResult);
    }

    private Wrapper teacherCheck(LoginDTO record, TeacherInfoDTO teacherInfoDTO){
        ExecuteResult<TeacherInfoDTO> executeResult = teacherInfoService.selectByPrimaryKey(teacherInfoDTO);
        if(!executeResult.isSuccess()){
            return WrapMapper.error().result(executeResult);
        }
        if(executeResult.getResult()==null){
            return WrapMapper.error().result("查无此账号！");
        }
        TeacherInfoDTO result = executeResult.getResult();
        String encodePassword = Md5Util.encode(record.getPassword());
        if(!encodePassword.equals(result.getTeacherPassword())){
            return WrapMapper.error().result("密码错误！");
        }
        return WrapMapper.ok().result(executeResult);
    }

    private Wrapper studentCheck(LoginDTO record, StudentInfoDTO studentInfoDTO){
        ExecuteResult<StudentInfoDTO> executeResult = studentInfoService.selectByPrimaryKey(studentInfoDTO);
        if(!executeResult.isSuccess()){
            return WrapMapper.error().result(executeResult);
        }
        if(executeResult.getResult()==null){
            return WrapMapper.error().result("查无此账号！");
        }
        StudentInfoDTO result = executeResult.getResult();
        String encodePassword = Md5Util.encode(record.getPassword());
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
