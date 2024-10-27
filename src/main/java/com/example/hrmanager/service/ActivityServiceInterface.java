package com.example.hrmanager.service;

import com.example.hrmanager.classes.Activity;

import java.util.List;

public interface ActivityServiceInterface {
    List<Activity> getActivitiesByEmployeeId(String employeeId);
    Activity addActivityToEmployee(String employeeId, Activity activity);

}
