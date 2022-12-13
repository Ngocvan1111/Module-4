package com.casestudy.demo.repository.contract;

import com.casestudy.demo.dto.ContractDto;
import com.casestudy.demo.model.contract.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ContractRepository extends JpaRepository<ContractDto, Long > {
    @Query(value = "select ct.id, ct.start_date, ct.end_date, ct.deposit,nullif(ft.cost,0) + nullif(sum (cd.quantity)*af.cost,0) as totalAmount from contract as ct left join facility as ft on ct.facility_id = ft.id " +
            "left join contract_detail as cd on ct.id = cd.contract_id" +
            "left join attach_facility as af on cd.attach_facility_id = af.id", nativeQuery = true)
    List<ContractDto> findAll();


}