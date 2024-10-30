package com.example.hrmanager.service;

import com.example.hrmanager.dao.ActivityDao;
import com.example.hrmanager.model.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService implements ActivityServiceInterface {

    @Autowired
    private ActivityDao activityDao;

    @Override
    public List<Activity> getActivitiesByEmployeeId(String employeeId) {
        // Convert employeeId to Integer
        Integer empId = Integer.valueOf(employeeId);
        return activityDao.findByEmployeeId(empId);
    }

    @Override
    public Activity addActivityToEmployee(Activity activity) {
        // Save the activity and return it
        return activityDao.save(activity);
    }
}
