package com.casestudy.demo.dto;

import com.casestudy.demo.model.contract.Contract;
import com.casestudy.demo.model.facility.FacilityType;
import com.casestudy.demo.model.facility.RentType;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.List;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FacilityDto {
    private Long id;
    @NotEmpty(message = "Name is not empty")
    @NotBlank(message = "Name is not blank")
//    @Pattern(regexp = "^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$", message = "Name must match Format ")
    private String name;
    private int area;
    private Double cost;
    private int maxPeople;
    private RentType rentType;
    private FacilityType facilityType;
    private String standardRoom;
    private String descriptionOtherConvenience;
    private Double poolArea;
    private Integer numberOfFloors;
    private String facilityFree;
    private List<Contract> contracts;
}
