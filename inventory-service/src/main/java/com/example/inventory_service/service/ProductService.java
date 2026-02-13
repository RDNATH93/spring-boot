package com.example.inventory_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.inventory_service.entity.Product;
import com.example.inventory_service.repository.ProductRepository;

@Service
public class ProductService {
    
    private final ProductRepository productRepository;

    ProductService(ProductRepository productRepository){
        this.productRepository=productRepository;
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public List<Product> getProductsByCategory(String category){
        return productRepository.findByCategory(category);
       
    }
}
