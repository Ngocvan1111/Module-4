package com.casestudy.demo.service.facility.impl;

import com.casestudy.demo.model.facility.Facility;
import com.casestudy.demo.model.facility.FacilityType;
import com.casestudy.demo.repository.facility.IFacilityRepository;
import com.casestudy.demo.service.facility.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class FacilityService implements IFacilityService {
    @Autowired
    private IFacilityRepository iFacilityRepository;
    @Override
    public Page<Facility> findByNameContainingAndAndFacilityType(String name, FacilityType facilityType, Pageable pageable) {
        return iFacilityRepository.findByNameContainingAndAndFacilityType(name,facilityType,pageable);
    }

    @Override
    public Page<Facility> findByNameContaining(String name, Pageable pageable) {
        return iFacilityRepository.findByNameContaining(name,pageable);
    }

    @Override
    public List<Facility> findAllWithNoPage() {
        return iFacilityRepository.findAll();
    }

    @Override
    public Page<Facility> findAll(Pageable pageable) {
        return iFacilityRepository.findAll(pageable);
    }

    @Override
    public Optional<Facility> findById(Long id) {
        return iFacilityRepository.findById(id);
    }

    @Override
    public void save(Facility facility) {
        iFacilityRepository.save(facility);

    }

    @Override
    public void remove(Long id) {
        iFacilityRepository.deleteById(id);

    }
}
