package com.example.hrmanager.dao;

import com.example.hrmanager.model.Activity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ActivityDao extends MongoRepository<Activity, Integer> {
    List<Activity> findByEmployeeId(Integer employeeId);
    Optional<Activity> findTopByOrderByIdDesc();

}
