package com.casestudy.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/home")
public class MainController {
    @GetMapping("")
    public String getHome(){
        return "/main";
    }

}
