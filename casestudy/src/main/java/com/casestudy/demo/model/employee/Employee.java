package com.casestudy.demo.model.employee;

import com.casestudy.demo.model.account.User;
import com.casestudy.demo.model.contract.Contract;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Date dayOfBirth;
    private String idCard;
    private Double salary;
    private String phoneNumber;
    private String email;
    private String address;
    @ManyToOne()
    @JoinColumn(name = "position_id",referencedColumnName = "id")
    private Position position;
    @ManyToOne()
    @JoinColumn(name = "education_degree_id",referencedColumnName = "id")
    private EducationDegree educationDegree;
    @ManyToOne()
    @JoinColumn(name = "division_id",referencedColumnName = "id")
    private Division division;

     @OneToOne(cascade = CascadeType.ALL)
     @JoinColumn(name = "username",referencedColumnName = "username")
     private User user;
     @OneToMany(mappedBy = "employee",cascade = CascadeType.ALL)
    private Set<Contract> contracts;

}
