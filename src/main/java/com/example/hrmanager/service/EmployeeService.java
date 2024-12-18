package com.example.hrmanager.service;

import com.example.hrmanager.dao.DepartmentDao;
import com.example.hrmanager.dto.CreateEmployeeDto;
import com.example.hrmanager.dto.GetEmployeeDto;
import com.example.hrmanager.exceptions.NotFoundException;
import com.example.hrmanager.model.Department;
import com.example.hrmanager.model.Employee;
import com.example.hrmanager.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService implements EmployeeServiceInterface {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;

    @Override
    @Cacheable(value = "employees")
    public List<Employee> getAllEmployees() {
        return employeeDao.findAll();
    }

    @Override
    @Cacheable(value = "employee", key = "#id")
    public GetEmployeeDto getEmployeeById(Integer id) {
        Employee employee = employeeDao.findById(id).orElseThrow(() -> new NotFoundException("Employee with id " + id + " not found"));

        Department department = departmentDao.findById(employee.getDepartmentId()).orElse(null);
        return new GetEmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmploymentDate(),
                employee.getSalary(),
                department
        );
    }

    @Override
    @Caching(evict = {
            @CacheEvict(value = "employeesWithDepartments", allEntries = true),
            @CacheEvict(value = "employees", allEntries = true),
    })
    public Employee addEmployee(CreateEmployeeDto employee) {
        Integer maxId = employeeDao.findTopByOrderByIdDesc()
                .map(Employee::getId)
                .orElse(0);
        Employee emp = new Employee(
                maxId + 1,
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmploymentDate(),
                employee.getDepartmentId(),
                employee.getSalary()
        );
        return employeeDao.save(emp);
    }

    @Override
    @Caching(evict = {
        @CacheEvict(value = "employeesWithDepartments", allEntries = true),
        @CacheEvict(value = "employees", allEntries = true),
        @CacheEvict(value = "employee", key = "#employee.id")
    })
    public Employee updateEmployee(Employee employee) {
        Optional<Employee> existingEmployee = employeeDao.findById(employee.getId());

        if (existingEmployee.isPresent()) {
            Employee emp = existingEmployee.get();
            emp.setFirstName(employee.getFirstName());
            emp.setLastName(employee.getLastName());
            emp.setEmploymentDate(employee.getEmploymentDate());
            emp.setDepartmentId(employee.getDepartmentId());
            emp.setSalary(employee.getSalary());
            return employeeDao.save(emp); // Cache will store updated employee here
        } else {
            return null;
        }
    }

    @Override
    @Caching(evict = {
            @CacheEvict(value = "employeesWithDepartments", allEntries = true), // Clears cached list of employees with departments
            @CacheEvict(value = "employees", allEntries = true), // Clears cached list of all employees
            @CacheEvict(value = "employee", key = "#id") // Removes individual employee cache
    })
    public boolean deleteEmployee(Integer id) {
        if (employeeDao.existsById(id)) {
            employeeDao.deleteById(id);
            return true;
        }
        return false;
    }

    @Cacheable(value = "employeesWithDepartments")
    public List<GetEmployeeDto> getEmployeesWithDepartments() {
        List<Employee> employees = employeeDao.findAll();
        return employees.stream()
                .map(employee -> {
                    Department department = departmentDao.findById(employee.getDepartmentId()).orElse(null);
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
