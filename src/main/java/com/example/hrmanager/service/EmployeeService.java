package com.example.hrmanager.service;

import com.example.hrmanager.classes.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements EmployeeServiceInterface {

    @Override
    public List<Employee> getAllEmployees() {
        return null;
    }

    @Override
    public Employee getEmployeeById(String id) {
        return null;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return employee;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employee;
    }

    @Override
    public void deleteEmployee(String id) {

    }
}
