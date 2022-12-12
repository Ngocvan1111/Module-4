package com.casestudy.demo.service.facility;

import com.casestudy.demo.model.customer.Customer;
import com.casestudy.demo.model.customer.CustomerType;
import com.casestudy.demo.model.facility.Facility;
import com.casestudy.demo.model.facility.FacilityType;
import com.casestudy.demo.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IFacilityService extends IGeneralService<Facility> {
    Page<Facility> findByNameContainingAndAndFacilityType(String name, FacilityType facilityType, Pageable pageable);
    Page<Facility> findByNameContaining(String name, Pageable pageable);
}
