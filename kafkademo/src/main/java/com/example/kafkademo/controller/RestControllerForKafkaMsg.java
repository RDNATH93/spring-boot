package com.example.kafkademo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.kafkademo.service.Producer;

/**
 * RestControllerForKafkaMsg
 */
@RestController
@RequestMapping("/rest/api")
public class RestControllerForKafkaMsg {

    private final Producer producer;

    RestControllerForKafkaMsg(Producer producer) {
        this.producer = producer;
    }

    /**
     * producer will produce the message on topic
     * received from this endpoint
     * 
     * @param message
     */
    @GetMapping("/producerMsg")
    public void getMessageFromClient(@RequestParam(name = "message") String message) {
        producer.sendMesgToTopic(message);
    }

}