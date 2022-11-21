package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CondimentsController {
    @GetMapping("/")
    public String getHome(){
        return "/index";
    }
    @PostMapping("/save")
    public String save(@RequestParam("spice") String[] spice, Model model){
        model.addAttribute("spice",spice);
        return "/result";
    }
}
