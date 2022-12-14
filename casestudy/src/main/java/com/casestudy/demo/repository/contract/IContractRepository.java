package com.casestudy.demo.repository.contract;

import com.casestudy.demo.dto.ContractDt;

import com.casestudy.demo.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface IContractRepository extends JpaRepository<Contract, Long > {
    @Query(value = "SELECT c.id as id, c.start_date as startDate, c.end_date as endDate, c.deposit, cus.name as customer,f.name as facility, (sum(ifnull(cd.quantity, 0) * ifnull(af.cost, 0)) + f.cost) AS totalAmount,employee.name as employee FROM contract c left join employee on c.employee_id = employee.id LEFT JOIN contract_detail cd ON c.id = cd.contract_id LEFT JOIN attach_facility af ON cd.attach_facility_id = af.id LEFT JOIN facility f ON c.facility_id = f.id join customer as cus on c.customer_id = cus.id GROUP BY c.id ORDER BY c.id"
            , countQuery = "SELECT c.id as id, c.start_date as startDate, c.end_date as endDate, c.deposit, cus.name as customer,f.name as facility, (sum(ifnull(cd.quantity, 0) * ifnull(af.cost, 0)) + f.cost) AS totalAmount,employee.name as employee FROM contract c left join employee on c.employee_id = employee.id LEFT JOIN contract_detail cd ON c.id = cd.contract_id LEFT JOIN attach_facility af ON cd.attach_facility_id = af.id LEFT JOIN facility f ON c.facility_id = f.id join customer as cus on c.customer_id = cus.id GROUP BY c.id ORDER BY c.id ", nativeQuery = true)
    Page<ContractDt> findContract(Pageable pageable);
}