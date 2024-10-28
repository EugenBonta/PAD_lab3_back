package com.example.hrmanager.service;

import com.example.hrmanager.classes.Employee;

import java.util.List;

public interface EmployeeServiceInterface {

    List<Employee> getAllEmployees();
    Employee getEmployeeById(String id);
    Employee addEmployee(Employee employee);
    Employee updateEmployee(Employee employee);
    void deleteEmployee(String id);

}
