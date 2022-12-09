package com.casestudy.demo.service;

import com.casestudy.demo.dto.CustomerDto;
import com.casestudy.demo.dto.ICustomerDto;
import com.casestudy.demo.model.Customer;
import com.casestudy.demo.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public Page<Customer> finAllCustomer(Pageable pageable) {
        return iCustomerRepository.findAll(pageable);
    }
}
