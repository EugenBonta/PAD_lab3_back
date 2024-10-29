package com.example.hrmanager.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "Activities")

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
