package com.casestudy.demo.service;

import com.casestudy.demo.dto.CustomerDto;
import com.casestudy.demo.dto.ICustomerDto;
import com.casestudy.demo.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    Page<Customer> finAllCustomer(Pageable pageable);
}
