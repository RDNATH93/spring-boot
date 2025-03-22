package com.example.stripe_integration.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins("https://literate-space-capybara-xxvjxxwvx64f9qw6.github.dev:8080") // Adjust for your frontend URL
                .allowedMethods("POST");
    }
}
