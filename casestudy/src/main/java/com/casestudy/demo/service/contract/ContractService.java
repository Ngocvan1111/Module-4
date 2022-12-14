package com.casestudy.demo.service.contract;

import com.casestudy.demo.dto.ContractDt;

import com.casestudy.demo.model.contract.AttachFacility;
import com.casestudy.demo.model.contract.Contract;
import com.casestudy.demo.repository.contract.IContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ContractService implements IContractService {
    @Autowired
    private IContractRepository iContractRepository;
    @Override
    public Page<ContractDt> findAll(Pageable pageable) {
        return iContractRepository.findContract(pageable);
    }


}
