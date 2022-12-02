package com.excercise.excercise.controller;

import com.excercise.excercise.model.Cart;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ShoppingCartController {

    @ModelAttribute("cart")
    public Cart setupCart(){
        return new Cart();
    }

    @GetMapping("/shopping-cart")
    public ModelAndView showCart (@SessionAttribute("cart") Cart cart){
        ModelAndView modelAndView = new ModelAndView("/cart");
        modelAndView.addObject("cart",cart);
        return modelAndView;
    }
    @GetMapping("/pay")
    public String pay(@SessionAttribute("cart")Cart cart, RedirectAttributes redirectAttributes){
        cart.pay();
        redirectAttributes.addFlashAttribute("mess","Payment successful");
        return "redirect:/shop";
    }
}
