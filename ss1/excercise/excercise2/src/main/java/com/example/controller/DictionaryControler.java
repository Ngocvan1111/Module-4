package com.example.controller;

import com.example.repository.IDictionaryRepository;
import com.example.repository.impl.DictionaryRepository;
import com.example.service.IDictionaryService;
import com.example.service.impl.DictionaryService;
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
    IDictionaryService iDictionaryService = new DictionaryService();

    @GetMapping("/")
    public String hone(){
        return "/home";
    }
    @GetMapping("/translate")
    public String translate(@RequestParam String inputWord, Model model){

       String  result = iDictionaryService.translate(inputWord);


            model.addAttribute("result",result);

        return "/home";


    }
}
