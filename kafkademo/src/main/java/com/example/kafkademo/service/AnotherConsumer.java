package com.example.kafkademo.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

//@Service
public class AnotherConsumer {
    //@KafkaListener(topics = "codedecode_topic", groupId = "codedecode_group",concurrency = "2")
    public void listenTopic(String receivedMsg) {
        System.out.println("Received Message code decode unit: " + receivedMsg);
    }
}
