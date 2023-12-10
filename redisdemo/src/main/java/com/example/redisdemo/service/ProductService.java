package com.example.redisdemo.service;

import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.redisdemo.entity.Product;
import com.example.redisdemo.repository.ProductDAO;

@Service
public class ProductService {

    private final ProductDAO productDAO;

    ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public Product saveProduct(Product product) {
        return productDAO.save(product);
    }

    @Cacheable(value = "Product")
    public List<Product> getAllProducts() {
        return productDAO.findAll();
    }

    @Cacheable(value = "Product")
    public Product getProductById(int id) {
        return productDAO.findProductById(id);
    }

    @CacheEvict(value = "Product")
    public long deleteProductById(int id) {
        return productDAO.deleteProductById(id);
    }

    @CachePut(value = "Product")
    public Product updateProduct(int id, Product product) {
        return productDAO.updateProduct(id, product);
    }
}
