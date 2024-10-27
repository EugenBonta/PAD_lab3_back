package com.example.hrmanager.classes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Department {
    private String id;
    private String name;

    public Department() {}

    public Department(String id, String name) {
        this.id = id;
        this.name = name;
    }

}
