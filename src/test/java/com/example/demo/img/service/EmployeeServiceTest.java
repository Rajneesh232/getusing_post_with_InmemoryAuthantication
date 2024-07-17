package com.example.demo.img.service;

import com.example.demo.img.entity.Employee;
import com.example.demo.img.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

    public class EmployeeServiceTest {

        @Mock
        private EmployeeRepository employeeRepository;

        @InjectMocks
        private EmployeeService employeeService;

        @BeforeEach
        public void setup() {
            MockitoAnnotations.openMocks(this);
        }

        @Test
        public void testGetEmployeeByMobileNumber() {
            // Arrange
            Employee mockEmployee = new Employee();
            mockEmployee.setId(1L);
            mockEmployee.setName("Rajneesh");
            mockEmployee.setMobileNumber("9453720963");

            when(employeeRepository.findByMobileNumber(anyString())).thenReturn(mockEmployee);

            // Act
            Employee result = employeeService.getEmployeeByMobileNumber("9453720963");

            // Assert
            assertThat(result).isNotNull();
            assertThat(result.getId()).isEqualTo(1L);
            assertThat(result.getName()).isEqualTo("Rajneesh");
            assertThat(result.getMobileNumber()).isEqualTo("9453720963");
        }

        @Test
        public void testGetEmployeeByMobileNumber_NotFound() {
            // Arrange
            when(employeeRepository.findByMobileNumber(anyString())).thenReturn(null);

            // Act
            Employee result = employeeService.getEmployeeByMobileNumber("9453720963");

            // Assert
            assertThat(result).isNull();
        }
    }



//////////////////////////////////////////////////////???????????????
//package com.example.demo.img.service;
//
//import com.example.demo.img.entity.Employee;
//import com.example.demo.img.repository.EmployeeRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.mockito.ArgumentMatchers.anyString;
//import static org.mockito.Mockito.when;
//
//public class EmployeeServiceTest {
//
//    @Mock
//    private EmployeeRepository employeeRepository;
//
//    @InjectMocks
//    private EmployeeService employeeService;
//
//    @BeforeEach
//    public void setup() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    public void testGetEmployeeByMobileNumber() {
//        // Arrange
//        Employee mockEmployee = new Employee();
//        mockEmployee.setId(2L);
//        mockEmployee.setName("Santosh");
//        mockEmployee.setMobileNumber("8105362359");
//
//        when(employeeRepository.findByMobileNumber(anyString())).thenReturn(mockEmployee);
//
//        // Act
//        Employee result = employeeService.getEmployeeByMobileNumber("8105362359");
//
//        // Assert
//        assertThat(result).isNotNull();
//        assertThat(result.getId()).isEqualTo(2L);
//        assertThat(result.getName()).isEqualTo("Santosh");
//        assertThat(result.getMobileNumber()).isEqualTo("8105362359");
//    }
//
//    @Test
//    public void testGetEmployeeByMobileNumber_NotFound() {
//        // Arrange
//        when(employeeRepository.findByMobileNumber(anyString())).thenReturn(null);
//
//        // Act
//        Employee result = employeeService.getEmployeeByMobileNumber("8105362359");
//
//        // Assert
//        assertThat(result).isNull();
//    }
//}
