package com.example.hrmanager.dto;

import com.example.hrmanager.model.Department;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetEmployeeDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private String employmentDate;
    private Integer salary;
    private Department department;


    public GetEmployeeDto() {}

    public GetEmployeeDto(Integer id, String firstName, String lastName,
                          String employmentDate, Integer salary,
                          Department department) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.employmentDate = employmentDate;
        this.salary = salary;
        this.department = department;
    }

}
