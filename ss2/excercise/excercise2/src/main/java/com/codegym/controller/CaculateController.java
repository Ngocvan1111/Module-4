package com.codegym.controller;

import com.codegym.service.ICalculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CaculateController {
    @Autowired
    ICalculateService iCalculateService;

    @GetMapping("/")
    public String getIndex() {
        return "/index";
    }

    @PostMapping("calculate")
    public String calculate(@RequestParam("first_number") Integer first_number,
                            @RequestParam("second_number") Integer second_number,
                            @RequestParam("operation") String operation, Model model) {
        model.addAttribute("first_number", first_number);
        model.addAttribute("second_number", second_number);
        double result = iCalculateService.calculate(first_number, second_number, operation);
        model.addAttribute("result", result);
        return "/index";
    }


}
