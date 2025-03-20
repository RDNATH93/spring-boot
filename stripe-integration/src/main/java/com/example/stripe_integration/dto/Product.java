package com.example.stripe_integration.dto;

public record Product(
   String productName,
   double amount,
   long quantity,
   String currency
) {}
