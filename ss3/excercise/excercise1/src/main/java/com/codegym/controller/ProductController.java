package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/product")

public class ProductController {
    @Autowired
    IProductService iProductService;

    @GetMapping("")
    public String getIndex(Model model){
        List<Product> productList = iProductService.findAll();
        model.addAttribute("productList",productList);
        return "product/index";
    }
    @GetMapping("/create")
    public String create(@ModelAttribute("product") Product product, Model model){
        model.addAttribute("product", product);
        return "product/create";
    }
    @PostMapping("/save")
    public String save(Product product){
        List<Product> productList = iProductService.findAll();
        int id = productList.size()+1;
        product.setId(id);
        iProductService.save(product);
        return "redirect:/product";
    }
    @GetMapping("/{id}/view")
    public String view(@PathVariable int id,Model model){
        model.addAttribute("product",iProductService.findById(id-1));
        return "product/view";
    }
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("product", iProductService.findById(id-1));
        return "product/edit";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute("product") Product product) {
        iProductService.update(product.getId()-1, product);
        return "redirect:/product";
    }
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("product", iProductService.findById(id-1));
        return "product/delete";
    }
    @PostMapping("/delete")
    public String delete(Product product, RedirectAttributes redirect) {
        iProductService.remove(product.getId()-1);
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/product";
    }
    @PostMapping("/search")
    public String search(@RequestParam("name") String name, Model model){
        List<Product> productList = iProductService.findAll();
        List<Product> listOut = new ArrayList<>();
        for(int i = 0;i<productList.size();i++){
            if(productList.get(i).getName().contains(name)){
                listOut.add(productList.get(i));
            }
        }
         productList = listOut;
        model.addAttribute("productList",productList);
        return "product/index";
    }

}
