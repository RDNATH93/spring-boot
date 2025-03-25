package com.example.elastic_demo.config;

import java.time.Duration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.micrometer.common.lang.Nullable;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.elastic.ElasticConfig;
import io.micrometer.elastic.ElasticMeterRegistry;

@Configuration
public class SpringElasticConfig {
  
    @Bean
    MeterRegistry elasticSearchConfig(){
        ElasticConfig elasticConfig = new ElasticConfig() {
            
            @Override
            @Nullable
            public String get(String k) {
                return null;
            }
            @Override
            public Duration connectTimeout() {
                return Duration.ofSeconds(60); // Ensure this matches your application.yml
            }
            @Override
            public Duration readTimeout() {
                return Duration.ofSeconds(60); // Ensure this matches your application.yml
            }
        };
        return ElasticMeterRegistry.builder(elasticConfig).build();
    }
    
}
