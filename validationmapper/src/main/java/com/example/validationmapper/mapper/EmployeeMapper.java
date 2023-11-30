package com.example.validationmapper.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.validationmapper.dto.EmployeeDTO;
import com.example.validationmapper.entity.Employee;

@Mapper
public interface EmployeeMapper {
    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "creationDate", ignore = true)
    Employee mapEmployeeFromDtoToEnity(EmployeeDTO employeeDTO);

    EmployeeDTO mapEmployeeFromEnityToDto(Employee employee);

}
