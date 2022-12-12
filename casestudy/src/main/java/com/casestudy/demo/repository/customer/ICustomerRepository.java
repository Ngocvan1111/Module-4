package com.casestudy.demo.repository.customer;

import com.casestudy.demo.model.customer.Customer;
import com.casestudy.demo.model.customer.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {

    Page<Customer> findByNameContainingAndEmailContainingAndCustomerType(String name, String email, CustomerType customerType, Pageable pageable);
    Page<Customer> findByNameContainingAndEmailContaining(String name, String email, Pageable pageable);

}
