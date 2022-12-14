package com.excercise.excercise.controller;

import com.excercise.excercise.dto.CartDto;
import com.excercise.excercise.dto.ProductDto;
import com.excercise.excercise.model.Cart;
import com.excercise.excercise.model.Product;
import com.excercise.excercise.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public CartDto setupCart() {
        return new CartDto();
    }

    @GetMapping("/shop")
    public ModelAndView showShop() {
        ModelAndView modelAndView = new ModelAndView("/shop");
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id, @ModelAttribute("cart") CartDto cart, @RequestParam("action") String action, RedirectAttributes redirectAttributes) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error.404";
        }
        if (action.equals("show")) {
            Cart cart1 = new Cart();
            BeanUtils.copyProperties(cart,cart1);
            cart1.addProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        Cart cart1 = new Cart();
        BeanUtils.copyProperties(cart,cart1);
        cart1.addProduct(productOptional.get());
        redirectAttributes.addFlashAttribute("massage",cart1.countProductQuantity());

        return "redirect:/shop";
    }
    @GetMapping("/details/{id}")
    public String details(@PathVariable Long id, Model model){
        Optional<Product> product = productService.findById(id);
        Product product1 = product.get();
        model.addAttribute("product",product1);
        return "/details";
    }
}