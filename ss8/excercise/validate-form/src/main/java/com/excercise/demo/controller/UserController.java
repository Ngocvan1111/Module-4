package com.excercise.demo.controller;

import com.excercise.demo.model.User;
import com.excercise.demo.service.IUserService;
import com.sun.tracing.dtrace.Attributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
  @Autowired
private IUserService iUserService;
  @GetMapping("/")
  public ModelAndView showList(){
      ModelAndView modelAndView = new ModelAndView("/list");
      modelAndView.addObject("userList", iUserService.findAll());
      return modelAndView;
  }

@GetMapping("/create-user")
public ModelAndView showform(){
ModelAndView modelAndView = new ModelAndView("/create");
modelAndView.addObject("user",new User());
return modelAndView;
}
    @PostMapping("/create-user")
public ModelAndView saveUser(@Validated @ModelAttribute("user") User user, BindingResult bindingResult){
      if(bindingResult.hasErrors()){
          ModelAndView modelAndView = new ModelAndView("/create");
          return modelAndView;
      }

ModelAndView modelAndView = new ModelAndView("redirect:/");
    iUserService.save(user);
        modelAndView.addObject("userList", iUserService.findAll());
modelAndView.addObject("massage","Create successfully");
return modelAndView;
    }


}
