package com.casestudy.demo.service;

import com.casestudy.demo.model.customer.Customer;
import com.casestudy.demo.model.customer.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService extends IGeneralService<Customer> {
    Page<Customer> findByNameContainingAndEmailContainingAndCustomerType(String name, String email, CustomerType customerType, Pageable pageable);
    Page<Customer> findByNameContainingAndEmailContaining(String name, String email, Pageable pageable);

}
