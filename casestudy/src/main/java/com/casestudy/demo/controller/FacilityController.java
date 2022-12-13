package com.casestudy.demo.controller;

import com.casestudy.demo.dto.CustomerDto;
import com.casestudy.demo.dto.FacilityDto;
import com.casestudy.demo.model.customer.Customer;
import com.casestudy.demo.model.customer.CustomerType;
import com.casestudy.demo.model.facility.Facility;
import com.casestudy.demo.model.facility.FacilityType;
import com.casestudy.demo.service.facility.IFacilityService;
import com.casestudy.demo.service.facility.IFacilityTypeService;
import com.casestudy.demo.service.facility.IRentTypeService;
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
@RequestMapping("/facility")
public class FacilityController {
    @Autowired
    private IFacilityService iFacilityService;
    @Autowired
    private IFacilityTypeService iFacilityTypeService;
    @Autowired
    private IRentTypeService iRentTypeService;



    @GetMapping("")
private String crateFacility(@PageableDefault(page = 0, size = 3) Pageable pageable, FacilityDto editFacilityDto, @RequestParam(defaultValue = "") String name, @RequestParam(defaultValue = "-1") int facilityTypeId, Model model){
        if(facilityTypeId == -1){
            model.addAttribute("facilityList",iFacilityService.findByNameContaining(name,pageable));
        }
        else {
            FacilityType facilityType =  iFacilityTypeService.findById(facilityTypeId);
            model.addAttribute("facilityList",iFacilityService.findByNameContainingAndAndFacilityType(name,facilityType,pageable));
        }
        model.addAttribute("facilityTypeList",iFacilityTypeService.findAll());
        model.addAttribute("rentTypeList",iRentTypeService.findAll());
        model.addAttribute("name",name);
        model.addAttribute("facilityTypeId",facilityTypeId);
        model.addAttribute("editFacilityDto",editFacilityDto);

    return "facility/list";
    }
    @GetMapping("/create")
    public ModelAndView showCreateCustomerForm(){
        ModelAndView modelAndView = new ModelAndView("facility/create");
        modelAndView.addObject("facilityTypeList",iFacilityTypeService.findAll());
        modelAndView.addObject("facilityDto", FacilityDto.builder().build());
        modelAndView.addObject("rentTypeList",iRentTypeService.findAll());
        return modelAndView;
    }
    @PostMapping("/create")
    public String saveCustomer(@Validated @ModelAttribute("facilityDto") FacilityDto facilityDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model){

        if(bindingResult.hasErrors()){
            model.addAttribute("facilityTypeList",iFacilityTypeService.findAll());
            model.addAttribute("hasErrors",true);
            model.addAttribute("facilityDto",facilityDto);
            return "facility/create";
        }
        Facility facility = Facility.builder().build();
        BeanUtils.copyProperties(facilityDto,facility);
        iFacilityService.save(facility);
        redirectAttributes.addFlashAttribute("message","new Facility created successfully");
        return "redirect:/facility";
    }
    @PostMapping("delete")
    public String deleteCustomer(@RequestParam("deleteId") Long deleteId) {
        iFacilityService.remove(deleteId);
        return "redirect:/facility";
    }
    @PostMapping("edit")
    public String editCustomer(@Validated @ModelAttribute("editFacilityDto") FacilityDto editFacilityDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model,@PageableDefault(page = 0,size = 3) Pageable pageable){
        if(bindingResult.hasErrors()){
            model.addAttribute("facilityTypeList",iFacilityTypeService.findAll());
            model.addAttribute("rentTypeList",iRentTypeService.findAll());
            model.addAttribute("hasErrors",true);
            model.addAttribute("facilityTypeEdit",editFacilityDto.getFacilityType().getId());
            model.addAttribute("facilityList",iFacilityService.findAll(pageable));
            model.addAttribute("editFacilityDto",editFacilityDto);
            model.addAttribute("facilityTypeName",editFacilityDto.getFacilityType().getName());
            return "facility/list";

        }
        Facility facility = Facility.builder().build();
        BeanUtils.copyProperties(editFacilityDto,facility);
        iFacilityService.save(facility);
        redirectAttributes.addFlashAttribute("message","new Facility edited successfully");
        return "redirect:/facility";
    }

}
