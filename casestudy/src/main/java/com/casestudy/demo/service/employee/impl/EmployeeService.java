package com.casestudy.demo.service.employee.impl;

import com.casestudy.demo.model.employee.Employee;
import com.casestudy.demo.repository.employee.IEmployeeRepository;
import com.casestudy.demo.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository iEmployeeRepository;
    @Override
    public List<Employee> findAll() {
        return iEmployeeRepository.findAll();
    }
}
