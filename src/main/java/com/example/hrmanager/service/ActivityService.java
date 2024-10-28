package com.example.hrmanager.service;

import com.example.hrmanager.classes.Activity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService implements ActivityServiceInterface {

    @Override
    public List<Activity> getActivitiesByEmployeeId(String employeeId) {
        return null;
    }

    @Override
    public Activity addActivityToEmployee(Activity activity) {
        return null;
    }
}
