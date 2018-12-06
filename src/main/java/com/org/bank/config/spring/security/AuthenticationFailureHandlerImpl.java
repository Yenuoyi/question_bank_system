package com.org.bank.config.spring.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component("authenticationFailureHandler")
public class AuthenticationFailureHandlerImpl implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.setContentType("application/json;charset=utf-8");
        System.out.println("登录失败！");
        PrintWriter out = httpServletResponse.getWriter();
        out.write("{\"status\":\"error\",\"msg\":\"登录失败\"}");
        out.flush();
        out.close();
    }
}
