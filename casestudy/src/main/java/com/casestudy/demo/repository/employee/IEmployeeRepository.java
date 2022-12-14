package com.casestudy.demo.repository.employee;

import com.casestudy.demo.model.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<Employee,Long> {
}
