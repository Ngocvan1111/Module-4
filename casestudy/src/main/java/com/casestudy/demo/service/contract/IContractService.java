package com.casestudy.demo.service.contract;

import com.casestudy.demo.dto.ContractDt;


import com.casestudy.demo.dto.ContractDto;
import com.casestudy.demo.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface IContractService {
    public Page<ContractDt> findAll(Pageable pageable);
    void save(Contract contract);
}
