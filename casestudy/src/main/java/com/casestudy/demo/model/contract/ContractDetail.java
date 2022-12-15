package com.casestudy.demo.model.contract;

import com.casestudy.demo.model.contract.AttachFacility;
import com.casestudy.demo.model.contract.Contract;
import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "contract_id",referencedColumnName = "id")
    private Contract contract;
    @ManyToOne()
    private AttachFacility attachFacility;
    private int quantity;
}
