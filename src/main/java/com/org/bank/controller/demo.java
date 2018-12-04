package com.org.bank.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class demo {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String demo(){
        return "1";
    }
}
