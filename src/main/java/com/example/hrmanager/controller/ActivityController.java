package com.example.hrmanager.controller;

import com.example.hrmanager.model.Activity;
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

    @GetMapping("api/activity/{id}")
    public List<Activity> getActivityByEmployeeID(@PathVariable String id) {
        return activityService.getActivitiesByEmployeeId(id);
    }

    @PostMapping("api/activity")
    public Activity addActivityToEmployee(@RequestBody Activity activity) {
        return activityService.addActivityToEmployee(activity);
    }
}
