package com.example.inventory_service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.inventory_service.entity.Product;
import com.example.inventory_service.service.ProductService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/v1/products")
class ProductController {

    private final ProductService productService;

    ProductController(ProductService productService){
        this.productService=productService;
    }

    @GetMapping()
    List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
    
    @GetMapping("/{category}")
    List<Product> getProductsByCategory(@PathVariable String category) {
        return productService.getProductsByCategory(category);
    }
    
}
