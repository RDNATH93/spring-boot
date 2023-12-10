package com.example.redisdemo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.redisdemo.entity.Product;
import com.example.redisdemo.service.ProductService;

@RestController
@RequestMapping("/api/v1/products/")
public class ProductController {

    private final ProductService service;

    ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("all")
    public ResponseEntity<List<Product>> getAllProducts() {
        var products = service.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("find/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") int id) {
        var product = service.getProductById(id);
        return ResponseEntity.ok(product);
    }

    @PostMapping("add")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        var savedProduct = service.saveProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") int id, @RequestBody Product product) {
        var updatedProduct = service.updateProduct(product.getId(), product);
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable("id") int id) {
        var removedId = service.deleteProductById(id);
        return ResponseEntity.ok("Deleted Product with id " + removedId);
    }
}
