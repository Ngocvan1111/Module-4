package com.casestudy.demo.service.contract;

import com.casestudy.demo.dto.AttachFacilityDto;
import com.casestudy.demo.model.contract.AttachFacility;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IAttachFacilityService {
    List<AttachFacilityDto> findAllByIdEqualContractId(Long id);
}
