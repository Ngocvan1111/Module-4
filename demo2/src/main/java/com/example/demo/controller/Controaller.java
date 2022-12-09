package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/abd")
public class Controaller {
    @GetMapping("")
    public String abc (){
        return "/abc";
    }
}
