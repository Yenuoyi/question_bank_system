package com.org.bank.config.spring.security;

import com.alibaba.fastjson.JSONObject;
import com.org.bank.common.ExecuteResult;
import com.org.bank.common.Role;
import com.org.bank.common.WrapMapper;
import com.org.bank.common.encrypt.Md5Util;
import com.org.bank.dao.AdminInfoDTOMapper;
import com.org.bank.dao.StudentInfoDTOMapper;
import com.org.bank.dao.TeacherInfoDTOMapper;
import com.org.bank.domain.AdminInfoDTO;
import com.org.bank.domain.StudentInfoDTO;
import com.org.bank.domain.TeacherInfoDTO;
import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * 功能：Spring Security成功登陆后页面处理器，
 * 结合Spring-security.xml文件下authentication-success-handler-ref="authenticationSuccessHandlerImpl"使用
 *
 * @Author Created by yebing
 * @Date 2018/8/12 21:15
 * @Version 1.0.0
 */
@Component("authenticationSuccessHandler")
public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {
    private Logger logger = Logger.getLogger(this.getClass());
    @Resource
    private AdminInfoDTOMapper adminInfoDTOMapper;
    @Resource
    private TeacherInfoDTOMapper teacherInfoDTOMapper;
    @Resource
    private StudentInfoDTOMapper studentInfoDTOMapper;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        logger.info("Setting session!");
        String username = UserSecurityContextHolder.getUsername();
        int userRoleType = UserSecurityContextHolder.getUserRoleType();
        Integer id = null;
        if(userRoleType == 1){
            AdminInfoDTO record = new AdminInfoDTO();
            record.setAdminEmail(username);
            List<AdminInfoDTO> adminInfoDTOS = adminInfoDTOMapper.selectList(record, null);
            id = adminInfoDTOS.get(0).getId();
        }
        if(userRoleType == 2){
            TeacherInfoDTO record = new TeacherInfoDTO();
            record.setTeacherEmail(username);
            List<TeacherInfoDTO> teacherInfoDTOS = teacherInfoDTOMapper.selectList(record, null);
            id = teacherInfoDTOS.get(0).getId();
        }
        if(userRoleType == 3){
            StudentInfoDTO record = new StudentInfoDTO();
            record.setStudentEmail(username);
            List<StudentInfoDTO> studentInfoDTOS = studentInfoDTOMapper.selectList(record, null);
            id = studentInfoDTOS.get(0).getId();
        }

        httpServletRequest.getSession().setAttribute("id",id);
        httpServletRequest.getSession().setAttribute("userRoleType",userRoleType);
        httpServletRequest.getUserPrincipal();
        httpServletResponse.setContentType("application/json;charset=utf-8");
        PrintWriter out = httpServletResponse.getWriter();
        String jsonString = JSONObject.toJSONString(WrapMapper.ok().result("登录成功！"));
        out.write(jsonString);
        out.flush();
        out.close();
//        httpServletResponse.sendRedirect("/hello");
    }
}
