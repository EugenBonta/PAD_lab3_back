package com.example.hrmanager.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateEmployeeDto {
    private String firstName;
    private String lastName;
    private String employmentDate;
    private Integer salary;
    private Integer departmentId;


    public CreateEmployeeDto(String firstName, String lastName,
                             String employmentDate, Integer salary,
                             Integer departmentId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.employmentDate = employmentDate;
        this.salary = salary;
        this.departmentId = departmentId;
    }

}
