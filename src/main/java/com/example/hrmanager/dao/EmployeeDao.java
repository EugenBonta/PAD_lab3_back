package com.example.hrmanager.dao;

import com.example.hrmanager.classes.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDao extends MongoRepository<Employee, Integer> {

}
