package com.example.redisdemo.repository;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.example.redisdemo.entity.Product;

@Repository
public class ProductDAO {

    Logger LOGGER = LoggerFactory.getLogger(ProductDAO.class);

    private static final String HASH_KEY = "Product";

    private final RedisTemplate<String, Product> template;

    ProductDAO(@Qualifier("prime") RedisTemplate<String, Product> template) {
        this.template = template;
    }

    public Product save(Product product) {
        LOGGER.debug("save product in db");
        template.opsForHash().put(HASH_KEY, product.getId(), product);
        return product;
    }

    public List<Product> findAll() {
        LOGGER.debug("get all products from db");

        return template.opsForHash().values(HASH_KEY)
                .stream()
                .map(entity -> (Product) entity)
                .collect(Collectors.toList());

    }

    public Product findProductById(int id) {
        LOGGER.debug("get product by id");
        var product= (Product) template.opsForHash().get(HASH_KEY, id);
        System.out.println(product);
        return product;
    }

    public Product updateProduct(int id, Product product) {
        LOGGER.debug("update product in db");
        template.opsForHash().put(HASH_KEY, id, product);
        return product;
    }

    public long deleteProductById(int id) {
        LOGGER.debug("delete product in db");
        return template.opsForHash().delete(HASH_KEY, id);
    }
}
