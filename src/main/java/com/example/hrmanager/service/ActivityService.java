package com.example.hrmanager.service;

import com.example.hrmanager.dao.ActivityDao;
import com.example.hrmanager.model.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RedisHash
public class ActivityService implements ActivityServiceInterface {

    @Autowired
    private ActivityDao activityDao;

    @Override
    @Cacheable(value = "activities", key = "#employeeId")
    public List<Activity> getActivitiesByEmployeeId(String employeeId) {
        Integer empId = Integer.valueOf(employeeId);
        return activityDao.findByEmployeeId(empId);
    }

    @Override
    @CachePut(value = "activities", key = "#activity.employeeId")
    public Activity addActivityToEmployee(Activity activity) {
        Integer maxId = activityDao.findTopByOrderByIdDesc()
                .map(Activity::getId)
                .orElse(0);
        activity.setId(maxId + 1);

        return activityDao.save(activity);
    }
}
