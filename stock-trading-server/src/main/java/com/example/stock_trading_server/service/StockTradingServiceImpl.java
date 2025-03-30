package com.example.stock_trading_server.service;

import org.springframework.grpc.server.service.GrpcService;

import com.example.grpc.StockRequest;
import com.example.grpc.StockResponse;
import com.example.grpc.StockTradingServiceGrpc;
import com.example.stock_trading_server.enity.Stock;
import com.example.stock_trading_server.repository.StockTradingRepository;

import io.grpc.stub.StreamObserver;

@GrpcService
public class StockTradingServiceImpl extends StockTradingServiceGrpc.StockTradingServiceImplBase{

    private final StockTradingRepository stockTradingRepository;

    StockTradingServiceImpl(StockTradingRepository stockTradingRepository){
        this.stockTradingRepository=stockTradingRepository;
    }

    @Override
    public void getStockPrice(StockRequest request, StreamObserver<StockResponse> responseObserver) {
        Stock stockEntity = stockTradingRepository.findByStockSymbol(request.getStockSymbol());

        StockResponse stockResponse = StockResponse.newBuilder().setStockSymbol(stockEntity.getStockSymbol())
        .setPrice(stockEntity.getPrice()).setTimstamp(stockEntity.getLastUpdated().toString()).build();

        responseObserver.onNext(stockResponse);
        responseObserver.onCompleted();
    }
    
}
