package com.example.kafkademo.service;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaUtils;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    @KafkaListener(topics = "codedecode_topic", groupId = "codedecode_group", concurrency = "3")
    public void listenToTopic(String receivedMsg, KafkaConsumer<?, ?> con) {
        System.out.println(con.groupMetadata().groupInstanceId());
        System.out.println(con.groupMetadata().memberId());
        System.out.println(con.metrics().entrySet());
        System.out.println(con.listTopics());
        System.out
                .println("Received Message on " + KafkaUtils.getConsumerGroupId() + ": " + receivedMsg);
    }

}
