package com.example.hrmanager.service;

import com.example.hrmanager.model.Activity;

import java.util.List;

public interface ActivityServiceInterface {

    List<Activity> getActivitiesByEmployeeId(String employeeId);
    Activity addActivityToEmployee(Activity activity);

}
