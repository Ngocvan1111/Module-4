package com.casestudy.demo.service.facility.impl;

import com.casestudy.demo.model.facility.RentType;
import com.casestudy.demo.repository.facility.IRentTypeRepository;
import com.casestudy.demo.service.facility.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentTypeService implements IRentTypeService {
    @Autowired
    private IRentTypeRepository iRentTypeRepository;
    @Override
    public List<RentType> findAll() {
        return iRentTypeRepository.findAll();
    }
}
