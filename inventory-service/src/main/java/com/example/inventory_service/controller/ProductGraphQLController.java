package com.example.inventory_service.controller;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.example.inventory_service.entity.Product;
import com.example.inventory_service.service.ProductService;

@Controller
public class ProductGraphQLController {
    
    private final ProductService productService;

    ProductGraphQLController(ProductService productService){
        this.productService=productService;
    }

    @QueryMapping
    List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
    
    @QueryMapping
    List<Product> getProductsByCategory(@Argument String category) {
        return productService.getProductsByCategory(category);
    }

    @MutationMapping
    Product updateStock(@Argument int id,@Argument int qty){
        return productService.updateStock(id, qty);
    }

    @MutationMapping
    Product receiveNewShipment(@Argument int id,@Argument int stock){
        return productService.receiveNewShipment(id, stock);
    }
}
