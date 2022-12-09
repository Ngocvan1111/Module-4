package com.casestudy.demo.model.employee;

import com.casestudy.demo.model.employee.Employee;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(mappedBy = "position",cascade = CascadeType.ALL)
    private Set<Employee> employees;
}
