package com.casestudy.demo.controller;

import com.casestudy.demo.dto.ContractDt;

import com.casestudy.demo.dto.ContractDto;
import com.casestudy.demo.dto.CustomerDto;
import com.casestudy.demo.model.contract.AttachFacility;
import com.casestudy.demo.model.contract.Contract;
import com.casestudy.demo.model.contract.ContractDetail;
import com.casestudy.demo.model.customer.Customer;
import com.casestudy.demo.service.contract.IAttachFacilityService;
import com.casestudy.demo.service.contract.IContractDetailService;
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
    @Autowired
    private IAttachFacilityService iAttachFacilityService;
    @Autowired
    private IContractDetailService iContractDetailService;
    @GetMapping("")
    public String getContractList(@PageableDefault(page = 0,size = 5)Pageable pageable, Model model){
        Page<ContractDt> contractDtoList = iContractService.findAll(pageable);
        model.addAttribute("contractDtoList",contractDtoList);
        model.addAttribute("contractDetail", ContractDetail.builder().build());
        model.addAttribute("attachFacilityList", iAttachFacilityService.findAll());
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
    @PostMapping("/create")
    public String saveContract( @ModelAttribute("contractDto") ContractDto contractDto, RedirectAttributes redirectAttributes, Model model){

        Contract contract = Contract.builder().build();
        BeanUtils.copyProperties(contractDto,contract);
        iContractService.save(contract);
        redirectAttributes.addFlashAttribute("message","new Customer created successfully");
        return "redirect:/contract";
    }
    @PostMapping("/contractDetail/create")
    public String saveContractDetail( @ModelAttribute("contractDetail") ContractDetail contractDetail, RedirectAttributes redirectAttributes, Model model){
        iContractDetailService.save(contractDetail);
        redirectAttributes.addFlashAttribute("message","new Customer created successfully");
        return "redirect:/contract";
    }





}
