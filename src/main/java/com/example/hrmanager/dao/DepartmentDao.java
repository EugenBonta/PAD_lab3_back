package com.example.hrmanager.dao;

import com.example.hrmanager.model.Department;
import com.example.hrmanager.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentDao extends MongoRepository<Department, Integer> {

}
