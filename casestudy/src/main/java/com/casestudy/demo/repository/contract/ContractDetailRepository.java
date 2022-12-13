package com.casestudy.demo.repository.contract;

import com.casestudy.demo.model.contract.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractDetailRepository extends JpaRepository<ContractDetail,Long> {
}
