package com.example.hrmanager.classes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Department {
    private Integer id;
    private String name;

    public Department() {}

    public Department(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

}
