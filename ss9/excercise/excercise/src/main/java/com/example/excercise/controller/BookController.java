package com.example.excercise.controller;

import com.example.excercise.model.Book;
import com.example.excercise.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class BookController {
    @Autowired
    private IBookService iBookService;
    @GetMapping("/")
    public ModelAndView showList(){
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("bookList", iBookService.findAll());
        return modelAndView;
    }
    @GetMapping("/list")
    public ModelAndView showLists(){
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("bookList", iBookService.findAll());
        return modelAndView;
    }
    @GetMapping("/detail/{id}")
    public String showDetail(@PathVariable Integer id, Model model){
        Optional<Book> book = iBookService.findById(id);
        Book book1 = book.get();
        model.addAttribute("book",book);
        model.addAttribute("book1",book1);
        return "/detail";

    }
    @PostMapping("/borrow")
    public String borrow(@ModelAttribute("book") Book book, Model model){
        iBookService.save(book);
        model.addAttribute("bookList", iBookService.findAll());
        return "redirect:/list";
    }
}
