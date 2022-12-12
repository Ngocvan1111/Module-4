package com.casestudy.demo.service.customer;

import com.casestudy.demo.model.customer.CustomerType;
import com.casestudy.demo.repository.customer.ICustomerTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeService implements ICustomerTypeService {
    @Autowired
    private ICustomerTypeRepository iCustomerTypeRepository;
    @Override
    public List<CustomerType> findAll() {
        return iCustomerTypeRepository.findAll();
    }

    @Override
    public CustomerType findById(int id) {
        return iCustomerTypeRepository.findById(id).isPresent()?iCustomerTypeRepository.findById(id).get():null;
    }
}
