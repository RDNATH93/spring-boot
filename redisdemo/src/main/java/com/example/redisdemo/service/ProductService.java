package com.example.redisdemo.service;

import java.util.List;

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

    public List<Product> getAllProducts() {
        return productDAO.findAll();
    }

    public Product getProductById(int id) {
        return productDAO.findProductById(id);
    }

    public long  deleteProductById(int id){
         return productDAO.deleteProductById(id);
    }

    public Product updateProduct(Product product) {
        return productDAO.updateProduct(product);
    }
}
