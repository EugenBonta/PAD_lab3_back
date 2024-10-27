package com.example.hrmanager.classes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Activity {
    private String id;
    private String employee;
    private String entry;
    private String exit;

    public Activity() {}

    public Activity(String id, String employee, String entry, String exit) {
        this.id = id;
        this.employee = employee;
        this.entry = entry;
        this.exit = exit;
    }

}
