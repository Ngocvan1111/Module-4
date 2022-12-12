package com.casestudy.demo.controller;

import com.casestudy.demo.dto.CustomerDto;
import com.casestudy.demo.model.customer.Customer;
import com.casestudy.demo.model.customer.CustomerType;
import com.casestudy.demo.service.customer.ICustomerService;
import com.casestudy.demo.service.customer.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private ICustomerTypeService iCustomerTypeService;
    @GetMapping("")
    public String getCustomer(@PageableDefault(page = 0,size = 3) Pageable pageable, CustomerDto editCustomerDto ,@RequestParam(defaultValue = "") String name,@RequestParam(defaultValue = "") String email, @RequestParam(defaultValue = "-1") int customerType, Model model){
        if(customerType == -1){
            model.addAttribute("customerList",iCustomerService.findByNameContainingAndEmailContaining(name,email,pageable));
        }
        else {
            CustomerType customerType1 =  iCustomerTypeService.findById(customerType);
            model.addAttribute("customerList",iCustomerService.findByNameContainingAndEmailContainingAndCustomerType(name,email,customerType1,pageable));
        }
        model.addAttribute("customerTypeList",iCustomerTypeService.findAll());
        model.addAttribute("editCustomerDto",editCustomerDto);
        return "customer/list";
    }
    @GetMapping("/create")
    public ModelAndView showCreateCustomerForm(){
        ModelAndView modelAndView = new ModelAndView("customer/create");
        modelAndView.addObject("customerTypeList",iCustomerTypeService.findAll());
        modelAndView.addObject("customerDto",CustomerDto.builder().build());
        return modelAndView;
    }
    @PostMapping("/create")
    public String saveCustomer(@Validated @ModelAttribute("customerDto") CustomerDto customerDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model){

        if(bindingResult.hasErrors()){
           model.addAttribute("customerTypeList",iCustomerTypeService.findAll());
            model.addAttribute("hasErrors",true);
           model.addAttribute("customerDto",customerDto);
            return "customer/create";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto,customer);
        iCustomerService.save(customer);
        redirectAttributes.addFlashAttribute("message","new Customer created successfully");
        return "redirect:/customer";
    }
    @PostMapping("delete")
    public String deleteCustomer(@RequestParam("deleteId") Long deleteId) {
        iCustomerService.remove(deleteId);
        return "redirect:/customer";
    }
    @PostMapping("edit")
    public String editCustomer(@Validated @ModelAttribute("editCustomerDto") CustomerDto editCustomerDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model,@PageableDefault(page = 0,size = 3) Pageable pageable){
        if(bindingResult.hasErrors()){
            model.addAttribute("customerTypeList",iCustomerTypeService.findAll());
            model.addAttribute("hasErrors",true);
//            model.addAttribute("customerDto",new CustomerDto());
            model.addAttribute("customerList",iCustomerService.findAll(pageable));
            model.addAttribute("editCustomerDto",editCustomerDto);
            return "customer/list";

        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(editCustomerDto,customer);
        iCustomerService.save(customer);
        redirectAttributes.addFlashAttribute("message","new Customer edited successfully");
        return "redirect:/customer";
    }
}
