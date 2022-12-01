package com.excercise.excercise.controller;

import com.excercise.excercise.dto.SongDto;
import com.excercise.excercise.model.Song;
import com.excercise.excercise.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

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
        modelAndView.addObject("songDto",new SongDto());
        return modelAndView;
    }
    @PostMapping("/create-song")
    public ModelAndView saveUser(@Validated @ModelAttribute("songDto") SongDto songDto, BindingResult bindingResult){
        new SongDto().validate(songDto,bindingResult);
        if(bindingResult.hasErrors()){
            ModelAndView modelAndView = new ModelAndView("/create");
            return modelAndView;
        }

        ModelAndView modelAndView = new ModelAndView("redirect:/");
        Song song = new Song();
        BeanUtils.copyProperties(songDto,song);
        iSongService.save(song);
        modelAndView.addObject("songList", iSongService.findAll());
        modelAndView.addObject("massage","Create successfully");
        return modelAndView;
    }
    @GetMapping("/edit-song/{id}")
    public ModelAndView showEditForm(@PathVariable Integer id) {
        Optional<Song> song = iSongService.findById(id);
        if (song.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/edit");
            SongDto songDto = new SongDto();
            BeanUtils.copyProperties(song.get(),songDto);
            modelAndView.addObject("songDto",songDto);
            return modelAndView;
        }else {
            return new ModelAndView("/error.404");
        }
    }

    @PostMapping("/edit-song")
    public ModelAndView updateSong(@Validated @ModelAttribute("songDto") SongDto songDto, BindingResult bindingResult) {
        new SongDto().validate(songDto,bindingResult);

        if(bindingResult.hasErrors()){
            ModelAndView modelAndView = new ModelAndView("/edit");
            return modelAndView;
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDto,song);
        iSongService.save(song);
        ModelAndView modelAndView = new ModelAndView("redirect:/");
        modelAndView.addObject("songList",iSongService.findAll());

        modelAndView.addObject("message", "Song updated successfully");
        return modelAndView;
    }

}
