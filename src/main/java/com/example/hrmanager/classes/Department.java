package com.example.hrmanager.classes;

import lombok.Getter;
import lombok.Setter;

import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@Document(collection = "Departments")

public class Department {
    private Integer id;
    private String name;

    public Department() {}

    public Department(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

}
