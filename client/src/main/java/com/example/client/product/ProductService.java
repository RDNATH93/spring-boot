package com.example.client.product;

import java.util.List;

import org.springframework.graphql.client.HttpSyncGraphQlClient;
import org.springframework.stereotype.Service;

import jakarta.annotation.Nonnull;

@Service
class ProductService {

    private final HttpSyncGraphQlClient productGraphQLClient;

    ProductService(HttpSyncGraphQlClient productGraphQLClient) {
        this.productGraphQLClient = productGraphQLClient;
    }

    List<Product> getAllProducts() {
        String document = """
                    {
                        getAllProducts {
                            id
                            name
                            category
                        }
                    }
                """;

        return productGraphQLClient.document(document)
        .retrieveSync("getAllProducts").toEntityList(Product.class);
    }

    List<Product> getProductsByCategory(@Nonnull String category) {
                String document = """
                    {
                        getProductsByCategory(category: "%s") {
                            id
                            name
                            price
                        }
                    }
                """.formatted(category);

        return productGraphQLClient.document(document)
        .retrieveSync("getProductsByCategory").toEntityList(Product.class);
    }
}
