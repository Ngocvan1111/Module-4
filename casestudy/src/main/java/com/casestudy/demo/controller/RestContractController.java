package com.casestudy.demo.controller;

import com.casestudy.demo.dto.AttachFacilityDto;
import com.casestudy.demo.model.contract.AttachFacility;
import com.casestudy.demo.model.contract.ContractDetail;
import com.casestudy.demo.service.contract.IAttachFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/contract")
public class RestContractController {

    @Autowired
    private IAttachFacilityService iAttachFacilityService;

    @GetMapping("attach-facility-list/{id}")
    public ResponseEntity<List<AttachFacilityDto>> getList(@PathVariable Long id) {
        List<AttachFacilityDto> attachFacilityList = iAttachFacilityService.findAllByIdEqualContractId(id);
        if (attachFacilityList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(attachFacilityList, HttpStatus.OK);
    }
//    @PostMapping(path = "")
//    public ResponseEntity create(@RequestBody ContractDetail contractDetail){
//
//    }


}
