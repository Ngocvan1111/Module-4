package com.casestudy.demo.model.contract;


import com.casestudy.demo.model.customer.Customer;
import com.casestudy.demo.model.employee.Employee;
import com.casestudy.demo.model.facility.Facility;
import lombok.*;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date startDate;
    private Date endDate;
    private Double deposit;
    @ManyToOne()
    @JoinColumn(name = "employee_id",referencedColumnName = "id")
    private Employee employee;
    @ManyToOne()
    @JoinColumn(name = "customer_id",referencedColumnName = "id")
    private Customer customer;
    @ManyToOne()
    @JoinColumn(name = "facility_id",referencedColumnName = "id")
    private Facility facility;
    @OneToMany(mappedBy = "contract",cascade = CascadeType.ALL)
    private List<ContractDetail> contractDetails;



}
