package com.casestudy.demo.service;

import com.casestudy.demo.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {
    Page<Customer> finAllCustomer(Pageable pageable);
}
