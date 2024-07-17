package com.example.demo.img.controller;


import com.example.demo.img.entity.Employee;
import com.example.demo.img.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/by-mobile-number")
    public ResponseEntity<Employee> getEmployeeByMobileNumber(@RequestParam("mobileNumber") String mobileNumber) {
        Employee employee = employeeService.getEmployeeByMobileNumber(mobileNumber);
        if (employee != null) {
            return ResponseEntity.ok(employee);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

