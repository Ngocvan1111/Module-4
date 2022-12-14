package com.casestudy.demo.controller;

import com.casestudy.demo.dto.ContractDt;

import com.casestudy.demo.dto.ContractDto;
import com.casestudy.demo.dto.CustomerDto;
import com.casestudy.demo.model.contract.Contract;
import com.casestudy.demo.model.customer.Customer;
import com.casestudy.demo.service.contract.IContractService;
import com.casestudy.demo.service.customer.ICustomerService;
import com.casestudy.demo.service.employee.IEmployeeService;
import com.casestudy.demo.service.facility.IFacilityService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private IContractService iContractService;
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private IEmployeeService iEmployeeService;
    @Autowired
    private IFacilityService iFacilityService;
    @GetMapping("")
    public String getContractList(@PageableDefault(page = 0,size = 5)Pageable pageable, Model model){
        Page<ContractDt> contractDtoList = iContractService.findAll(pageable);
        model.addAttribute("contractDtoList",contractDtoList);
        return "contract/list";
    }
    @GetMapping("/create")
    public ModelAndView showCreateContractForm(){
        ModelAndView modelAndView = new ModelAndView("contract/create");
        modelAndView.addObject("contractDto", ContractDto.builder().build());
        modelAndView.addObject("customerList",iCustomerService.findAllWithNoPage());
        modelAndView.addObject("employeeList",iEmployeeService.findAll());
        modelAndView.addObject("facilityList",iFacilityService.findAllWithNoPage());
        return modelAndView;
    }
//    @PostMapping("/create")
//    public String saveCustomer(@Validated @ModelAttribute("customerDto") CustomerDto customerDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model){
//
//        if(bindingResult.hasErrors()){
//            model.addAttribute("customerTypeList",iCustomerTypeService.findAll());
//            model.addAttribute("hasErrors",true);
//            model.addAttribute("customerDto",customerDto);
//            return "customer/create";
//        }
//        Customer customer = new Customer();
//        BeanUtils.copyProperties(customerDto,customer);
//        iCustomerService.save(customer);
//        redirectAttributes.addFlashAttribute("message","new Customer created successfully");
//        return "redirect:/customer";
//    }





}
