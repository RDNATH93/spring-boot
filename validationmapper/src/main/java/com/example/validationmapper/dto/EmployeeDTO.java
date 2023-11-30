package com.example.validationmapper.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {

    private long id;
    private String name;
    private int age;
    private String email;
    private int projectId;
    private Date creationDate;
}
