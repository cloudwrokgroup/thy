package com.demo.demo.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {
    @RequestMapping(value="/")
    public String indexRender(HttpServletRequest request,Model map){
        map.addAttribute("title","Thymeleaf Index");
        return "index";
    }
}
