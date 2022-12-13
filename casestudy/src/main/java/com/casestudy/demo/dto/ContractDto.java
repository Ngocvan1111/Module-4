package com.casestudy.demo.dto;

import com.casestudy.demo.model.customer.Customer;
import com.casestudy.demo.model.employee.Employee;
import com.casestudy.demo.model.facility.Facility;
import lombok.*;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ContractDto {
    private Long id;
    private Date startDate;
    private Date endDate;
    private Double deposit;
    private Employee employee;
    private Customer customer;
    private Facility facility;
    private Double totalAmount;
}
