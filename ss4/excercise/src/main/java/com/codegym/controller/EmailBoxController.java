package com.codegym.controller;

import com.codegym.model.EmailBox;
import com.codegym.service.IEmailBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("email/")
public class EmailBoxController {

    @Autowired
    IEmailBoxService iEmailBoxService;


    @GetMapping("/")
    public String getSetting(Model model){
//        List<EmailBox> emailBoxList = iEmailBoxService.findAllEmailBox();
        List<String> languages = iEmailBoxService.findAllLanguages();
        List<Integer> pageSizes = iEmailBoxService.findAllPageSize();
//        model.addAttribute("emailBoxList",emailBoxList);
        model.addAttribute("languages",languages);
        model.addAttribute("pageSizes",pageSizes);
        model.addAttribute("emailBox",new EmailBox());

        return "email/settings";
    }




    @PostMapping("/settings")
    public String result(@ModelAttribute("emailBox") EmailBox emailBox, Model model){
        List<EmailBox> emailBoxList;
        emailBoxList = iEmailBoxService.findAllEmailBox();
        emailBoxList.add(emailBox);
        int size = emailBoxList.size();
        model.addAttribute("size", size);
        model.addAttribute("emailBoxList",emailBoxList);
        return "email/result";

    }
    @GetMapping("edit/id")
    public String getEditForm(){
        return "email/edit";
    }
    @GetMapping("delete/{id}")
    public String delete(@PathVariable(value = "id") Integer id,Model model){
//        List<EmailBox> emailBoxList;
//        emailBoxList = iEmailBoxService.findAllEmailBox();
//        model.addAttribute("emailBoxList",emailBoxList);
        iEmailBoxService.delete(id);
        return "redirect:/email";
    }}
