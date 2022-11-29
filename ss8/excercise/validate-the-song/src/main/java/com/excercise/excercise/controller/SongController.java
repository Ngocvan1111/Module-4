package com.excercise.excercise.controller;

import com.excercise.excercise.model.Song;
import com.excercise.excercise.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SongController {
    @Autowired
    private ISongService iSongService;
    @GetMapping("/")
    public ModelAndView showList(){
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("songList", iSongService.findAll());
        return modelAndView;
    }

    @GetMapping("/create-song")
    public ModelAndView showform(){
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("song",new Song());
        return modelAndView;
    }
    @PostMapping("/create-song")
    public ModelAndView saveUser(@Validated @ModelAttribute("Song") Song song, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            ModelAndView modelAndView = new ModelAndView("/create");
            return modelAndView;
        }

        ModelAndView modelAndView = new ModelAndView("redirect:/");
        iSongService.save(song);
        modelAndView.addObject("songList", iSongService.findAll());
        modelAndView.addObject("massage","Create successfully");
        return modelAndView;
    }
}
