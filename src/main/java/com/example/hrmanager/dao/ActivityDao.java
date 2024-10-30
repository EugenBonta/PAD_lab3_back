package com.example.hrmanager.dao;

import com.example.hrmanager.model.Activity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityDao extends MongoRepository<Activity, Integer> {

}
