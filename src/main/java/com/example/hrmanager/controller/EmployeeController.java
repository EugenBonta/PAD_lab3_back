package com.example.hrmanager.controller;


import com.example.hrmanager.dto.CreateEmployeeDto;
import com.example.hrmanager.dto.GetEmployeeDto;
import com.example.hrmanager.model.Employee;
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
    public List<GetEmployeeDto> getAll() {
        System.out.println("endpoint api/employee/all");
        return employeeService.getEmployeesWithDepartments();
    }

    @GetMapping(value = "api/employee/{id}")
    public GetEmployeeDto getByID(@PathVariable Integer id){
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("api/employee")
    public Employee create(@RequestBody CreateEmployeeDto employee){
        return employeeService.addEmployee(employee);
    }

    @PutMapping("api/employee")
    public Employee update(@RequestBody Employee employee){
        return employeeService.updateEmployee(employee);
    }

    @DeleteMapping("api/employee/{id}")
    public boolean delete(@PathVariable Integer id) {
        employeeService.deleteEmployee(id);
        return true;
    }

    @GetMapping(value = "api/test")
    public String getTest(){
        return "Hallo World";
    }
}
