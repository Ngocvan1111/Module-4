package com.casestudy.demo.service.contract;

import com.casestudy.demo.dto.AttachFacilityDto;
import com.casestudy.demo.model.contract.AttachFacility;
import com.casestudy.demo.repository.contract.IAttachFacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AttachFacilityService implements IAttachFacilityService {
    @Autowired
    private IAttachFacilityRepository iAttachFacilityRepository;
    @Override
    public List<AttachFacilityDto> findAllByIdEqualContractId(Long id) {
        return iAttachFacilityRepository.findAllByIdEqualContractId(id);
    }

    @Override
    public List<AttachFacility> findAll() {
        return iAttachFacilityRepository.findAll();
    }
}
