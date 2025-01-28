package com.example.function_stored_procedures.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.function_stored_procedures.entity.Product;
import com.example.function_stored_procedures.service.ProductService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @PutMapping("/update/productId/{productId}/quantity/{quantity}")
    public ResponseEntity<Product> updateStockQuantity(@PathVariable int productId, @PathVariable int quantity) {
       return  ResponseEntity.ok(productService.updateStockQuantity(productId,quantity));
    }

}
