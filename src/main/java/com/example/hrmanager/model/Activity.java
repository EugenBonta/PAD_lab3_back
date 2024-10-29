package com.example.hrmanager.model;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class Activity {
    @Id
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
