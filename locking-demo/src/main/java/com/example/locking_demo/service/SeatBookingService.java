package com.example.locking_demo.service;

import org.springframework.stereotype.Service;

import com.example.locking_demo.repository.SeatRepository;

@Service
public class SeatBookingService {
    
    private final SeatRepository seatRepository;

    SeatBookingService(SeatRepository seatRepository){
        this.seatRepository=seatRepository;
    }
}
