package com.example.excercise.controller;

import com.example.excercise.model.Book;
import com.example.excercise.model.Contract;
import com.example.excercise.service.BookService;
import com.example.excercise.service.IBookManagerService;
import com.example.excercise.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class BookController {
    @Autowired
    private IBookService iBookService;
    @Autowired
    private IBookManagerService iBookManagerService;
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
    public String borrow(@ModelAttribute("book") Book book, RedirectAttributes redirectAttributes, Model model){
        iBookService.save(book);


        int code = iBookService.randomCode();
        Contract contract = new Contract();
        contract.setCode(code);
        iBookManagerService.save(contract);
        redirectAttributes.addFlashAttribute("bookList", iBookService.findAll());
        redirectAttributes.addFlashAttribute("message",code);
        return "redirect:/list";
    }
    @GetMapping("/return")
    public ModelAndView showReturn(@ModelAttribute("contract") Contract contract){

        ModelAndView modelAndView = new ModelAndView("/return");
        modelAndView.addObject("contract", contract);
//        modelAndView.addObject("contract",iBookManagerService.findByCode())
        return modelAndView;
    }
    @PostMapping("/return")
    public String returnBook(@PathVariable("code") Integer code,RedirectAttributes redirectAttributes, Model model){
        if(iBookManagerService.findByCode(code) != null){
            redirectAttributes.addFlashAttribute("message",code);
            return "redirect:/list";

        }
        return null;
    }

}
