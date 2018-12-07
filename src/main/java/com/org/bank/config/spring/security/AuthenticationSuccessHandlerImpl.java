package com.org.bank.config.spring.security;

import com.alibaba.fastjson.JSONObject;
import com.org.bank.common.ExecuteResult;
import com.org.bank.common.WrapMapper;
import com.org.bank.common.encrypt.Md5Util;
import com.org.bank.domain.StudentInfoDTO;
import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

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
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        logger.info("Setting session!");
        httpServletResponse.setContentType("application/json;charset=utf-8");
        PrintWriter out = httpServletResponse.getWriter();
        String jsonString = JSONObject.toJSONString(WrapMapper.ok().result("登录成功！"));
        out.write(jsonString);
        out.flush();
        out.close();
//        httpServletResponse.sendRedirect("/hello");
    }
}
