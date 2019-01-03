package com.org.bank.config.spring.security;

import com.org.bank.common.Role;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component("userSecurityContextHolder")
public class UserSecurityContextHolder {
    public static UserDetails getUserDetails(){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        return userDetails;
    }
    public static String getUsername(){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        String username = userDetails.getUsername().split("_")[1];
        return username;
    }
    public static String getUserRole(){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        String userRole = userDetails.getUsername().split("_")[0];
        return userRole;
    }

    public static int getUserRoleType(){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        String userRole = userDetails.getUsername().split("_")[0];
        if(userRole.equals(Role.ADMIN)){
            return 1;
        }
        if(userRole.equals(Role.TEACHER)){
            return 2;
        }
        if(userRole.equals(Role.STUDENT)){
            return 3;
        }
        return 3;
    }

    public static int getUserId(HttpServletRequest httpServletRequest){
        int id = Integer.parseInt(httpServletRequest.getSession().getAttribute("id").toString());
        return id;
    }
}
