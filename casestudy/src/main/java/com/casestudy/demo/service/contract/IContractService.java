package com.casestudy.demo.service.contract;

import com.casestudy.demo.dto.ContractDt;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface IContractService {
    public Page<ContractDt> findAll(Pageable pageable);
}
