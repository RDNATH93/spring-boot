package com.example.validationmapper.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.validationmapper.dto.EmployeeDTO;
import com.example.validationmapper.service.EmployeeServiceImpl;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    private final EmployeeServiceImpl employeeServiceImpl;

    EmployeeController(EmployeeServiceImpl employeeServiceImpl) {
        this.employeeServiceImpl = employeeServiceImpl;
    }

    @PostMapping("/add")
    public ResponseEntity<EmployeeDTO> addEmployee(@RequestBody EmployeeDTO employee) {
        EmployeeDTO empDTO=employeeServiceImpl.saveEmployee(employee);
        return new ResponseEntity<EmployeeDTO>(empDTO, HttpStatus.CREATED);
    }
}
