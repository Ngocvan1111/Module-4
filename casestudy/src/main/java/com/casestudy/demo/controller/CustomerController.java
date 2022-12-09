package com.casestudy.demo.controller;

import com.casestudy.demo.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;

    @GetMapping("")
    public String getCustomer(@PageableDefault(page = 0,size = 3) Pageable pageable, Model model){
        model.addAttribute("customerList",iCustomerService.finAllCustomer(pageable));
        return "customer/list";
    }
}
