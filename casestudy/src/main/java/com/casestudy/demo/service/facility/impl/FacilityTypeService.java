package com.casestudy.demo.service.facility.impl;

import com.casestudy.demo.model.facility.FacilityType;
import com.casestudy.demo.repository.facility.IFacilityTypeRepository;
import com.casestudy.demo.service.facility.IFacilityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacilityTypeService implements IFacilityTypeService {
    @Autowired
    private IFacilityTypeRepository iFacilityTypeRepository;
    @Override
    public List<FacilityType> findAll() {
        return iFacilityTypeRepository.findAll();
    }

    @Override
    public FacilityType findById(int id) {
        return iFacilityTypeRepository.findById(id).isPresent()?iFacilityTypeRepository.findById(id).get():null;
    }
}
