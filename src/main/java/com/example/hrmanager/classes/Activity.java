package com.example.hrmanager.classes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Activity {
    private Integer id;
    private Integer employeeId;
    private String entry;
    private String exit;

    public Activity() {}

    public Activity(Integer id, Integer employeeId, String entry, String exit) {
        this.id = id;
        this.employeeId = employeeId;
        this.entry = entry;
        this.exit = exit;
    }

}
