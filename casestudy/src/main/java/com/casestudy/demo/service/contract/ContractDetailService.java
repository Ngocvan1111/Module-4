package com.casestudy.demo.service.contract;

import com.casestudy.demo.model.contract.ContractDetail;
import com.casestudy.demo.repository.contract.ContractDetailRepository;
import com.casestudy.demo.repository.contract.IContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractDetailService implements IContractDetailService {
    @Autowired
    private ContractDetailRepository contractDetailRepository;

    @Override
    public void save(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }
}
