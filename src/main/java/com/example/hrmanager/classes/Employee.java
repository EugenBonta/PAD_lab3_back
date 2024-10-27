package com.example.hrmanager.classes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee {
    private String id;
    private String firstName;
    private String lastName;
    private String employmentDate;
    private String department;
    private Integer salary;

    public Employee() {}

    public Employee(String id, String firstName, String lastName,
                    String employmentDate, String department, Integer salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.employmentDate = employmentDate;
        this.department = department;
        this.salary = salary;
    }

}
