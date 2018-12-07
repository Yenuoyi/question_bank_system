package com.org.bank.controller;

import com.org.bank.config.spring.security.UserSecurityContextHolder;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class demo {
    private Logger logger = Logger.getLogger(this.getClass());
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String demo(){
        UserSecurityContextHolder.getUsername();
        logger.info("username:"+UserSecurityContextHolder.getUsername());
        return "1";
    }
}
