package com.example.hrmanager.controller;

import com.example.hrmanager.dto.CreateEmployeeDto;
import com.example.hrmanager.dto.GetEmployeeDto;
import com.example.hrmanager.model.Department;
import com.example.hrmanager.model.Employee;
import com.example.hrmanager.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    @Autowired
    private ObjectMapper objectMapper;

    private Employee testEmployee;
    private GetEmployeeDto testEmployeeDto;
    private CreateEmployeeDto createEmployeeDto;

    @BeforeEach
    void setUp() {
        Department testDepartment = new Department(3, "Engineering");
        testEmployee = new Employee(100, "John", "Doe", "2023-01-01", 3, 50000);
        testEmployeeDto = new GetEmployeeDto(100, "John", "Doe", "2023-01-01", 50000, testDepartment);
        createEmployeeDto = new CreateEmployeeDto("John", "Doe", "2023-01-01", 50000, 3);
    }

    @Test
    void getAll() throws Exception {
        Mockito.when(employeeService.getEmployeesWithDepartments())
                .thenReturn(List.of(testEmployeeDto));

        mockMvc.perform(get("/api/employee/all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(testEmployeeDto.getId())))
                .andExpect(jsonPath("$[0].firstName", is(testEmployeeDto.getFirstName())))
                .andExpect(jsonPath("$[0].lastName", is(testEmployeeDto.getLastName())))
                .andExpect(jsonPath("$[0].department.name", is(testEmployeeDto.getDepartment().getName())))
                .andExpect(jsonPath("$[0].salary", is(testEmployeeDto.getSalary())));
    }


    @Test
    void getById() throws Exception {
        Mockito.when(employeeService.getEmployeeById(eq(1))).thenReturn(testEmployeeDto);

        mockMvc.perform(get("/api/employee/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(testEmployeeDto.getId())))
                .andExpect(jsonPath("$.firstName", is(testEmployeeDto.getFirstName())))
                .andExpect(jsonPath("$.lastName", is(testEmployeeDto.getLastName())))
                .andExpect(jsonPath("$.department.name", is(testEmployeeDto.getDepartment().getName())))
                .andExpect(jsonPath("$.salary", is(testEmployeeDto.getSalary())));
    }

    @Test
    void create() throws Exception {
        Mockito.when(employeeService.addEmployee(any(CreateEmployeeDto.class))).thenReturn(testEmployee);

        mockMvc.perform(post("/api/employee")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createEmployeeDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(testEmployee.getId())))
                .andExpect(jsonPath("$.firstName", is(testEmployee.getFirstName())))
                .andExpect(jsonPath("$.lastName", is(testEmployee.getLastName())))
                .andExpect(jsonPath("$.employmentDate", is(testEmployee.getEmploymentDate())))
                .andExpect(jsonPath("$.departmentId", is(testEmployee.getDepartmentId())))
                .andExpect(jsonPath("$.salary", is(testEmployee.getSalary())));
    }

    @Test
    void update() throws Exception {
        Mockito.when(employeeService.updateEmployee(any(Employee.class))).thenReturn(testEmployee);

        mockMvc.perform(put("/api/employee")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(testEmployee)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(testEmployee.getId())))
                .andExpect(jsonPath("$.firstName", is(testEmployee.getFirstName())))
                .andExpect(jsonPath("$.lastName", is(testEmployee.getLastName())))
                .andExpect(jsonPath("$.employmentDate", is(testEmployee.getEmploymentDate())))
                .andExpect(jsonPath("$.departmentId", is(testEmployee.getDepartmentId())))
                .andExpect(jsonPath("$.salary", is(testEmployee.getSalary())));
    }

    @Test
    void delete() throws Exception {
        // Mock the method to return true when called with id 100
        when(employeeService.deleteEmployee(100)).thenReturn(true);

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/employee/100"))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));

        verify(employeeService, times(1)).deleteEmployee(100);
    }


    @Test
    void getTest() throws Exception {
        mockMvc.perform(get("/api/test"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hallo World!"));
    }
}
