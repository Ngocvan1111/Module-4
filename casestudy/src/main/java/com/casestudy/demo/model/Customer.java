package com.casestudy.demo.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne()
    @JoinColumn(name = "customer_type_id",referencedColumnName = "id")
    private CustomerType customerType;
    private String name;
    @Column(columnDefinition = "date")
    private String dateOfBirth;
    private Boolean gender;
    private String idCard;
    private String phoneNumber;
    private String email;
    private String address;
    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    private List<Contract> contracts;



}
