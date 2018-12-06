package com.org.bank.config.spring.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.annotation.Resource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {
    @Resource
    private AuthenticationSuccessHandler authenticationSuccessHandler;
    @Resource
    private UserDetailsService userDetailsService;
    @Resource
    private PasswordEncoder passwordEncoder;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginProcessingUrl("/api/login")                  //登录请求拦截的url,也就是form表单提交时指定的action
//                .loginProcessingUrl("/api/teacherLogin")
//                .loginProcessingUrl("/api/adminLogin")
                .successHandler(authenticationSuccessHandler)  //自定义成功处理器
                .and().authorizeRequests()                 //授权配置
                .antMatchers("/api/login.html").permitAll() //自定义登录页面不授权
                .antMatchers("/teacher/login.html").permitAll() //自定义登录页面不授权
                .antMatchers("/admin/login.html").permitAll() //自定义登录页面不授权
                .antMatchers("/teacher/**").hasRole("ADMIN")
                .antMatchers("/teacher/**").hasRole("TEACHER")
                .antMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest()     // 所有请求
                .authenticated(); // 所有请求都进行权限验证
        http.httpBasic() // 配置弹出框登录
                .and().authorizeRequests() // 请求权限设置
                .anyRequest()
                .authenticated();
        http.logout()
                .logoutUrl("/api/logout")
                .logoutSuccessUrl("/login.html")
                .invalidateHttpSession(true);
        http.authenticationProvider(authenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider
                = new DaoAuthenticationProvider(); // 创建DaoAuthenticationProvider实例
        authProvider.setUserDetailsService(userDetailsService); // 将自定义的认证逻辑添加到DaoAuthenticationProvider
        authProvider.setPasswordEncoder(passwordEncoder); // 设置自定义的密码加密
        return authProvider;
    }
}
