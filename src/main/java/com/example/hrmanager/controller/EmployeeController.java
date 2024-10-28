package com.example.hrmanager.controller;


import com.example.hrmanager.classes.Employee;
import com.example.hrmanager.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("api/employee/all")
    public List<Employee> getAll() {
        return employeeService.getAllEmployees();
    }

    @GetMapping(value = "api/employee/{id}")
    public Employee getByID(@PathVariable String id){
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("api/employee")
    public Employee create(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }

    @PutMapping("api/employee")
    public Employee update(@RequestBody Employee employee){
        return employeeService.updateEmployee(employee);
    }

    @DeleteMapping("api/employee/{id}")
    public void delete(@PathVariable String id) {
        employeeService.deleteEmployee(id);
    }
}
