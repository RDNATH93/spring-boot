package com.example.locking_demo.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.locking_demo.service.SeatBookingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/book-seat")
public class SeatBookingController {
 
    private final SeatBookingService seatBookingService;

    SeatBookingController(SeatBookingService seatBookingService){
        this.seatBookingService=seatBookingService;
    }


    @GetMapping("/optimistic/{seatId}")    
    public String optimisticSeatBook(@PathVariable int seatId){
            return "Optimistic locking started! Check logs for results.";
    }

    @GetMapping("/pessimistic/{seatId}")    
    public String pessimisticSeatBook(@PathVariable int seatId){
            return "Pessimistic locking started! Check logs for results.";
    }
}
