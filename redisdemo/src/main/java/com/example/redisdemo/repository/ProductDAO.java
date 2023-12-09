package com.example.redisdemo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.example.redisdemo.entity.Product;

@Repository
public class ProductDAO {

    private static final Object HASH_KEY = "Product";

    private final RedisTemplate template;

    ProductDAO(@Qualifier("prime") RedisTemplate template) {
        this.template = template;
    }

    public Product save(Product product) {
        template.opsForHash().put(HASH_KEY, Integer.toString(product.getId()), product);
        return product;
    }

    public List<Product> findAll() {
        return template.opsForHash().values(HASH_KEY);

    }

    public Product findProductById(int id) {
        return (Product) template.opsForHash().get(HASH_KEY, Integer.toString(id));
    }

    public Product updateProduct(Product product) {
        template.opsForHash().put(HASH_KEY, Integer.toString(product.getId()), product);
        return product;
    }

    public long deleteProductById(int id) {
        return template.opsForHash().delete(HASH_KEY, Integer.toString(id));
    }
}
