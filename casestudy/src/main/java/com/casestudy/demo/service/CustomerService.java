package com.casestudy.demo.service;

import com.casestudy.demo.model.customer.Customer;
import com.casestudy.demo.model.customer.CustomerType;
import com.casestudy.demo.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return iCustomerRepository.findAll(pageable);

    }

    @Override
    public Optional<Customer> findById(Long id) {
        return iCustomerRepository.findById(id);
    }


    @Override
    public void save(Customer customer) {
        iCustomerRepository.save(customer);

    }

    @Override
    public void remove(Long id) {
        iCustomerRepository.deleteById(id);

    }

    @Override
    public Page<Customer> findByNameContainingAndEmailContainingAndCustomerType(String name, String email, CustomerType customerType, Pageable pageable) {
        return iCustomerRepository.findByNameContainingAndEmailContainingAndCustomerType(name,email,customerType,pageable);
    }

    @Override
    public Page<Customer> findByNameContainingAndEmailContaining(String name, String email, Pageable pageable) {
        return iCustomerRepository.findByNameContainingAndEmailContaining(name,email,pageable);
    }
}
