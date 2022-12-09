package com.casestudy.demo.dto;

import com.casestudy.demo.model.customer.CustomerType;

public interface ICustomerDto {

    public CustomerType getCustomerType() ;

    public String getName() ;

    public String getDateOfBirth();

    public Boolean getGender();

    public String getPhoneNumber();

    public String getEmail();



}
