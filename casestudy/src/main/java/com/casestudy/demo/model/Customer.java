package com.casestudy.demo.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

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
    private int customerTypeId;
    private String name;
    private Date dateOfBirth;
    private Boolean gender;
    private String idCard;
    private String phoneNumber;
    private String email;
    private String address;
}
