package com.casestudy.demo.dto;


import java.util.Date;



public interface ContractDt {


    public Long getId() ;

    public Date getStartDate() ;

    public Date getEndDate() ;
    public Double getDeposit();

    public String getCustomer() ;

    public String getFacility();

    public Double getTotalAmount();

    public String getEmployee();
}
