package com.example.hrmanager.classes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee {
    private Integer id;
    private String firstName;
    private String lastName;
    private String employmentDate;
    private Integer departmentId;
    private Integer salary;

    public Employee() {}

    public Employee(Integer id, String firstName, String lastName,
                    String employmentDate, Integer departmentId, Integer salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.employmentDate = employmentDate;
        this.departmentId = departmentId;
        this.salary = salary;
    }

}
