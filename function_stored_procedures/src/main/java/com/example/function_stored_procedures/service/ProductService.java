package com.example.function_stored_procedures.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.function_stored_procedures.entity.Product;
import com.example.function_stored_procedures.repository.ProductRepository;

@Service
public class ProductService {
    
    private final ProductRepository productRepository;

    ProductService(ProductRepository productRepository){
        this.productRepository=productRepository;
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product updateStockQuantity(int productId, int quantity) {
        productRepository.updateStockQuantity(productId, quantity);
        return productRepository.findById(productId).get();
    }

    public double getTotalPrice(int productId){
        return productRepository.getTotalPrice(productId);
    }
}
