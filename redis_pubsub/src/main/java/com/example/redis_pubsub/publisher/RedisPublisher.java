package com.example.redis_pubsub.publisher;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.redis_pubsub.dto.Product;

@RestController
@RequestMapping("/api/v1/redis/")
public class RedisPublisher {

    private final ChannelTopic topic;
    private RedisTemplate template;

    RedisPublisher(ChannelTopic topic, RedisTemplate template) {
        this.topic = topic;
        this.template = template;
    }

    @PostMapping("publish")
    public String publishMessage(@RequestBody Product product) {
        template.convertAndSend(topic.getTopic(), product.toString());

        return "Event Published !";
    }
}
