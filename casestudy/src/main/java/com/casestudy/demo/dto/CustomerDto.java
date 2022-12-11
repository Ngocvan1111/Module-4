package com.casestudy.demo.dto;

import com.casestudy.demo.model.customer.CustomerType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;


public class CustomerDto {
    private Long id;
    private CustomerType customerType;
    @NotEmpty(message = "Name is not empty")
    @NotBlank(message = "Name is not blank")
    @Pattern(regexp = "^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$", message = "Name must match Format ")
    private String name;
    private String dateOfBirth;
    private Boolean gender;
    @Pattern(regexp = "^\\d{9}|\\d{11}$",message = "Id card must be match Format")
    private String idCard;
    @Pattern(regexp = "^(((\\\\+|)84)|0)(3|5|7|8|9)+([0-9]{8})$", message = "Phone number must be match Format")
    private String phoneNumber;
    @Pattern(regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
            + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$", message = "Email must be match Format (***@**.***)")
    private String email;
    @NotEmpty(message = "Name is not empty")
    @NotBlank(message = "Name is not blank")
    private String address;

    public CustomerDto() {
    }

    public CustomerDto(Long id, CustomerType customerType,  String name, String dateOfBirth, Boolean gender,  String idCard, String phoneNumber, String email, String address
        ) {
        this.id = id;
        this.customerType = customerType;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
