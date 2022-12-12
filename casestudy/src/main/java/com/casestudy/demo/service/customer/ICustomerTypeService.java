package com.casestudy.demo.service.customer;

import com.casestudy.demo.model.customer.CustomerType;

import java.util.List;
import java.util.Optional;

public interface ICustomerTypeService  {
     List<CustomerType> findAll();
     CustomerType findById(int id);

}
