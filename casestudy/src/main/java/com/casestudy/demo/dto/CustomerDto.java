package com.casestudy.demo.dto;

import com.casestudy.demo.model.CustomerType;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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
}
