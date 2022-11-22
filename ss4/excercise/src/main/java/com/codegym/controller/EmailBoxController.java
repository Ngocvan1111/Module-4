package com.codegym.controller;

import com.codegym.model.EmailBox;
import com.codegym.service.IEmailBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
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

        return "/settings";
    }




    @PostMapping("settings")
    public String result(@ModelAttribute("emailBox") EmailBox emailBox, Model model){
        List<EmailBox> emailBoxList;
        emailBoxList = iEmailBoxService.findAllEmailBox();
        emailBoxList.add(emailBox);
        int size = emailBoxList.size();
        model.addAttribute("size", size);
        model.addAttribute("emailBoxList",emailBoxList);
        return "/result";

    }
    @GetMapping("edit/id")
    public String getEditForm(){
        return "/edit";
    }
    @GetMapping("delete/{id}")
    public String delete(@RequestParam("id") int id){
        iEmailBoxService.delete(id);
        return "/result";
    }

}
