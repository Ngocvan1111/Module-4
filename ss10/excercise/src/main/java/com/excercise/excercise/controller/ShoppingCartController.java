package com.excercise.excercise.controller;

import com.excercise.excercise.dto.CartDto;
import com.excercise.excercise.model.Cart;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ShoppingCartController {

    @ModelAttribute("cart")
    public CartDto setupCart(){
        return new CartDto();
    }

    @GetMapping("/shopping-cart")
    public ModelAndView showCart (@SessionAttribute("cart") CartDto cart){
        ModelAndView modelAndView = new ModelAndView("/cart");
//        Cart cart1 = new Cart();
//        BeanUtils.copyProperties(cart,cart1);
        modelAndView.addObject("cart",cart);
        return modelAndView;
    }
    @GetMapping("/pay")
    public String pay(@SessionAttribute("cart") CartDto cart, RedirectAttributes redirectAttributes){
        cart.pay();
        redirectAttributes.addFlashAttribute("mess","Payment successful");
        return "redirect:/shop";
    }
}
