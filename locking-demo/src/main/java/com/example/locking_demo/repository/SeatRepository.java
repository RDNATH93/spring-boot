package com.example.locking_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.locking_demo.entity.Seat;

public interface SeatRepository extends JpaRepository<Seat,Integer> {
    
}
