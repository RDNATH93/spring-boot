package com.example.validationmapper.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.validationmapper.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
