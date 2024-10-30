package com.example.hrmanager.dao;

import com.example.hrmanager.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeDao extends MongoRepository<Employee, Integer> {
    Optional<Employee> findTopByOrderByIdDesc();
}
