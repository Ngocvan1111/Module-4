package com.casestudy.demo.repository;

import com.casestudy.demo.model.customer.Customer;
import com.casestudy.demo.model.customer.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {

    @Query(value = "select  c.name, c.gender, c.customer_type_id, c.date_of_birth, c.phone_number, c.email from customer as c ",
            nativeQuery = true,
            countQuery = "select  c.name, c.gender, c.customer_type_id, c.date_of_birth, c.phone_number, c.email from customer as c")
    Page<Customer> finAllCustomer(Pageable pageable);
    Page<Customer> findByNameContainingAndEmailContainingAndCustomerType(String name, String email, CustomerType customerType, Pageable pageable);
    Page<Customer> findByNameContainingAndEmailContaining(String name, String email, Pageable pageable);

}
