package com.example.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.client.HttpSyncGraphQlClient;
import org.springframework.web.client.RestClient;

@Configuration
public class ClientConfig {

    @Bean
    HttpSyncGraphQlClient  productGraphQLClient(RestClient.Builder builder){
        RestClient restClient = builder.baseUrl("http://localhost:9191/graphql").build();
        return HttpSyncGraphQlClient.create(restClient);
    }
    
}
