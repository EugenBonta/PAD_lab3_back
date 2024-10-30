package com.example.hrmanager.service;

import com.example.hrmanager.dto.CreateEmployeeDto;
import com.example.hrmanager.dto.GetEmployeeDto;
import com.example.hrmanager.model.Employee;

import java.util.List;

public interface EmployeeServiceInterface {

    List<Employee> getAllEmployees();
    GetEmployeeDto getEmployeeById(Integer id);
    Employee addEmployee(CreateEmployeeDto employee);
    Employee updateEmployee(Employee employee);
    boolean deleteEmployee(Integer id);

}
