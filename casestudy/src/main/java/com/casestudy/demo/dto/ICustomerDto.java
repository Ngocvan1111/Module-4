package com.casestudy.demo.dto;

import com.casestudy.demo.model.*;

import java.util.Date;
import java.util.List;

public interface ICustomerDto {

    public CustomerType getCustomerType() ;

    public String getName() ;

    public String getDateOfBirth();

    public Boolean getGender();

    public String getPhoneNumber();

    public String getEmail();



}
