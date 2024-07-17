package com.example.demo.img.service;

import com.example.demo.img.entity.Employee;
import com.example.demo.img.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee getEmployeeByMobileNumber(String mobileNumber) {

        return employeeRepository.findByMobileNumber(mobileNumber);
    }

}

