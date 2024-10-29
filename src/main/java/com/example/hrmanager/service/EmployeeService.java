package com.example.hrmanager.service;

import com.example.hrmanager.model.Employee;
import com.example.hrmanager.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements EmployeeServiceInterface {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDao.findAll();
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
