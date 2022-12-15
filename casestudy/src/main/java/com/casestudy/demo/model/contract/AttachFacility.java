package com.casestudy.demo.model.contract;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AttachFacility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double cost;
    private String unit;
    private String status;
    @OneToMany(mappedBy = "attachFacility",cascade = CascadeType.ALL)
    private List<ContractDetail> contractDetails;
}
