package com.casestudy.demo.repository.contract;

import com.casestudy.demo.dto.AttachFacilityDto;
import com.casestudy.demo.model.contract.AttachFacility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IAttachFacilityRepository extends JpaRepository<AttachFacility,Long> {
    @Query(value = "select con.id as contractId , a.name as attachFacilityName, a.status as status,a.unit as unit,cd.quantity as quantity from contract as con join contract_detail cd on con.id = cd.contract_id join attach_facility a on cd.attach_facility_id = a.id where cd.contract_id = :id", countQuery = "select con.id as contractId , a.name as attachFacilityName, a.status,a.unit,cd.quantity from contract as con join contract_detail cd on con.id = cd.contract_id join attach_facility a on cd.attach_facility_id = a.id where cd.contract_id = :id", nativeQuery = true)
    List<AttachFacilityDto> findAllByIdEqualContractId(@Param("id") Long id);

}
