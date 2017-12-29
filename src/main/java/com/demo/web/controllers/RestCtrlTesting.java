package com.demo.web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestCtrlTesting {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "Welcome to restful World!!";
    }
}
