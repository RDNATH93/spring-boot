package com.example.redis_pubsub.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable {

    private int id;
    private String name;
    private int quantity;
    private long price;
}
