package com.example.controller;

import com.example.service.IConvertService;
import com.example.service.impl.ConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvertMoney {
    @Autowired
     private IConvertService convertService ;
    @GetMapping("/")
    public String convertt(){


        return "/client-view";
    }
    @GetMapping("/convertt")
    public String convert(@RequestParam double input, Model model){


        double number = convertService.vndToUsd(input);
        model.addAttribute("rs",number);


        return "/client-view";
    }
}
