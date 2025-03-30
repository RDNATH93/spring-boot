package com.example.stock_trading_server.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.stock_trading_server.enity.Stock;

public interface StockTradingRepository extends JpaRepository<Stock,Long> {
   Stock findByStockSymbol(String symbol);
}
