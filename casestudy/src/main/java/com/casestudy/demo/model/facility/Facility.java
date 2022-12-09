package com.casestudy.demo.model.facility;

import com.casestudy.demo.model.contract.Contract;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Facility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int area;
    private Double cost;
    private int maxPeople;
    @ManyToOne()
    @JoinColumn(name = "rent_type_id",referencedColumnName = "id")
    private RentType rentType;
    @ManyToOne()
    @JoinColumn(name = "facility_type_id",referencedColumnName = "id")
    private FacilityType facilityType;
    private String standardRoom;
    private String descriptionOtherConvenience;
    private Double poolArea;
    private Integer numberOfFloors;
    private String facilityFree;
    @OneToMany(mappedBy = "facility",cascade = CascadeType.ALL)
    private List<Contract>  contracts;

}
