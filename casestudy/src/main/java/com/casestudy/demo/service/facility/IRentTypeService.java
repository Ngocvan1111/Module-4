package com.casestudy.demo.service.facility;

import com.casestudy.demo.model.facility.FacilityType;
import com.casestudy.demo.model.facility.RentType;

import java.util.List;

public interface IRentTypeService {
    List<RentType> findAll();
}
