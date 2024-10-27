package com.example.hrmanager.controller;

import com.example.hrmanager.classes.Activity;
import com.example.hrmanager.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    public ActivityController (ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping("getActivityByEmployeeID/{id}")
    public List<Activity> getActivityByEmployeeID(@PathVariable String id) {
        return activityService.getActivitiesByEmployeeId(id);
    }

    @PostMapping("addActivityToEmployee/{id}")
    public Activity addActivityToEmployee(@PathVariable String id, @RequestBody Activity activity) {
        return activityService.addActivityToEmployee(id, activity);
    }
}
