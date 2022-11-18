package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Greetingcontroller {
    @GetMapping("/")
    public String greeting(@RequestParam(required = false) String name, Model model){
        model.addAttribute("name","Lại Văn Ngọc");
        return "index";
    }
}
