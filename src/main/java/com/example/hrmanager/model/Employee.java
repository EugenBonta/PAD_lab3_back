package com.example.hrmanager.model;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@Document(collection = "Employees")
public class Employee {

    @Id
    private Integer id;
    private String firstName;
    private String lastName;
    private String employmentDate;
    private Integer departmentId;
    private Integer salary;

    public Employee() {}

    public Employee(Integer  id, String firstName, String lastName,
                    String employmentDate, Integer departmentId, Integer salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.employmentDate = employmentDate;
        this.departmentId = departmentId;
        this.salary = salary;
    }

    public Integer getDepartmentId(){
        return departmentId;
    }
}
