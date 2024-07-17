package com.example.demo.img.controller;

import com.example.demo.img.entity.Employee;
import com.example.demo.img.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

    public class EmployeeControllerTest {

        private MockMvc mockMvc;

        @Mock
        private EmployeeService employeeService;

        @InjectMocks
        private EmployeeController employeeController;

        @BeforeEach
        public void setup() {
            MockitoAnnotations.openMocks(this);
            mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
        }

        @Test
        public void testGetEmployeeByMobileNumber() throws Exception {
            Employee mockEmployee = new Employee();
            mockEmployee.setId(1L);
            mockEmployee.setName("Rajneesh");
            mockEmployee.setMobileNumber("9453720963");

            when(employeeService.getEmployeeByMobileNumber(anyString())).thenReturn(mockEmployee);

            mockMvc.perform(post("http://localhost:8080/api/employees/by-mobile-number")
                            .param("mobileNumber", "9453720963")
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.id").value(1L))
                    .andExpect(jsonPath("$.name").value("Rajneesh"))
                    .andExpect(jsonPath("$.mobileNumber").value("9453720963"));
        }

        @Test
        public void testGetEmployeeByMobileNumber_NotFound() throws Exception {
            when(employeeService.getEmployeeByMobileNumber(anyString())).thenReturn(null);

            mockMvc.perform(post("http://localhost:8080/api/employees/by-mobile-number")
                            .param("mobileNumber", "9453720963")
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isNotFound());
        }
    }

