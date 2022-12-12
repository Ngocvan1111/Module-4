package com.casestudy.demo.repository.facility;

import com.casestudy.demo.model.facility.Facility;
import com.casestudy.demo.model.facility.FacilityType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFacilityRepository extends JpaRepository<Facility,Long> {
    Page<Facility> findByNameContainingAndAndFacilityType(String name, FacilityType facilityTy, Pageable pageable);
    Page<Facility> findByNameContaining(String name, Pageable pageable);
}
