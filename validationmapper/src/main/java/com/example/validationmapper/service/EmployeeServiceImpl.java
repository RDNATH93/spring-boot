package com.example.validationmapper.service;

import java.util.Date;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.validationmapper.dto.EmployeeDTO;
import com.example.validationmapper.entity.Employee;
import com.example.validationmapper.mapper.EmployeeMapper;
import com.example.validationmapper.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl {

    private final EmployeeRepository employeeRepository;
    
    EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository=employeeRepository;
    }

    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO){
        Employee employee= EmployeeMapper.INSTANCE.mapEmployeeFromDtoToEnity(employeeDTO);
        employee.setCreationDate(new Date());
        Employee savedEmployee= employeeRepository.save(employee);
        
        return EmployeeMapper.INSTANCE.mapEmployeeFromEnityToDto(savedEmployee);
    }
}
