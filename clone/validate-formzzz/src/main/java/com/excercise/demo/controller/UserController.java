package com.excercise.demo.controller;

import com.excercise.demo.model.User;
import com.excercise.demo.model.UserDto;
import com.excercise.demo.service.IUserService;
import com.sun.tracing.dtrace.Attributes;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//@Controller
//public class UserController {
//  @Autowired
//private IUserService iUserService;
//  @GetMapping("/")
//  public ModelAndView showList(){
//      ModelAndView modelAndView = new ModelAndView("/list");
//      modelAndView.addObject("userList", iUserService.findAll());
//      return modelAndView;
//  }

//@GetMapping("/create-user")
//public ModelAndView showform(){
//ModelAndView modelAndView = new ModelAndView("/create");
//modelAndView.addObject("userDto",new UserDto());
//return modelAndView;
//}
//    @PostMapping("/create-user")
//public ModelAndView saveUser(@Validated @ModelAttribute("userDto") UserDto userDto, BindingResult bindingResult){
//      if(bindingResult.hasErrors()){
//          ModelAndView modelAndView = new ModelAndView("/create");
//          return modelAndView;
//      }
//
//ModelAndView modelAndView = new ModelAndView("redirect:/");
//      User user = new User();
//        BeanUtils.copyProperties(userDto,user);
//    iUserService.save(user);
//        modelAndView.addObject("userList", iUserService.findAll());
//modelAndView.addObject("massage","Create successfully");
//return modelAndView;
//    }
@Controller
@RequestMapping("")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/validList")
    public String display(@Validated @ModelAttribute("userDto") UserDto userDto, BindingResult bindingResult, Model model){
        model.addAttribute("userDto", userDto);
        model.addAttribute("userDtoList",userService.findAll());
        return "/list";
    }
    @GetMapping("/")
    public String display( Model model, UserDto userDto){
        model.addAttribute("userDto", userDto);
        model.addAttribute("userDtoList",userService.findAll());
        return "/list";
    }

    @PostMapping("save")
    public String validateUser(@Validated @ModelAttribute("userDto") UserDto userDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model){
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("hasErrors", true);
            redirectAttributes.addFlashAttribute("userDto", userDto);
            return "redirect:/validList";
        }
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        userService.save(user);
        return "redirect:/";
    }
}






