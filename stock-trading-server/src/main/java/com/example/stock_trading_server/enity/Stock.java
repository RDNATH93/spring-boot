package com.example.stock_trading_server.enity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "stock_symbol",unique = true,nullable=false)
    private String stockSymbol;

    private double price;

    @Column(name="last_updated")
    private LocalDateTime lastUpdated;


}
