package com.example.demo.img.repository;

import com.example.demo.img.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByMobileNumber(String mobileNumber);
}

