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

    @GetMapping("getAll")
    public List<Employee> getAll() {
        return employeeService.getAllEmployees();
    }

    @GetMapping(value = "getByID/{id}")
    public Employee getByID(@PathVariable String id){
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("create")
    public Employee create(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }

    @PatchMapping("update/{id}")
    public Employee update(@PathVariable String id, @RequestBody Employee employee){
        return employeeService.updateEmployee(id, employee);
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable String id) {
        employeeService.deleteEmployee(id);
    }
}
