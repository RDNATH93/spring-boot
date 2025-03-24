package com.example.grpc_demo.model;

import java.time.Instant;
import java.util.List;
import java.util.Map;

public class Employee {
    private long id;
    private String name;
    private double salary;
    private List<Department> departments;
    private Map<String,String>address;
    private boolean isActive;
    private byte[] profilePicture;
    private Instant joinDate;

    //getter setter
}
