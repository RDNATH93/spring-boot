package com.example.kafkademo.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {
    
    private final KafkaTemplate<String,String> kafkaTemplate;

    Producer(KafkaTemplate<String,String> kafkaTemplate){
        this.kafkaTemplate=kafkaTemplate;
    }

    public void sendMesgToTopic(String message){
        kafkaTemplate.send("codedecode_topic",message);
    }
}
