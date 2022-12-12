package com.casestudy.demo.service.facility;

import com.casestudy.demo.model.facility.FacilityType;

import java.util.List;

public interface IFacilityTypeService {
    List<FacilityType> findAll();
     FacilityType findById(int id);
}
