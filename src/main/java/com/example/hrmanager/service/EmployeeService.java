package com.example.hrmanager.service;

import com.example.hrmanager.dao.DepartmentDao;
import com.example.hrmanager.dto.GetEmployeeDto;
import com.example.hrmanager.model.Department;
import com.example.hrmanager.model.Employee;
import com.example.hrmanager.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService implements EmployeeServiceInterface {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao; // You need to create this DAO


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

    public List<GetEmployeeDto> getEmployeesWithDepartments() {
        List<Employee> employees = employeeDao.findAll();
        return employees.stream()
                .map(employee -> {
                    Department department = departmentDao.findById(employee.getDepartmentId() ).orElse(null);
                    return new GetEmployeeDto(
                            employee.getId(),
                            employee.getFirstName(),
                            employee.getLastName(),
                            employee.getEmploymentDate(),
                            employee.getSalary(),
                            department
                    );
                })
                .collect(Collectors.toList());
    }
}
