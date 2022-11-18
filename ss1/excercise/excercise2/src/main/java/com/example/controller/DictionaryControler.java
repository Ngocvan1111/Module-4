package com.example.controller;

import com.example.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class DictionaryControler {
    @Autowired
    IDictionaryService iDictionaryService;
    @GetMapping("/")
    public String hone(){
        return "/home";
    }
    @GetMapping("/translate")
    public String translate(@RequestParam String inputWord, Model model){
        Map<String, String> listWord = iDictionaryService.list();
        boolean flag = true;
        for (int i=0;i<listWord.size();i++){
            if(listWord.containsKey(inputWord)){
                model.addAttribute("result",listWord.get(inputWord));
                flag = false;
            }
        }
        if(flag){
            model.addAttribute("result","Không có từ cần dịch");
        }
        return "/home";


    }
}
