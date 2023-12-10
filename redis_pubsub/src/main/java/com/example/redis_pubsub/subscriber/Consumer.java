package com.example.redis_pubsub.subscriber;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.lang.Nullable;

public class Consumer implements MessageListener {

    Logger LOGGER = LoggerFactory.getLogger(Consumer.class);

    @Override
    public void onMessage(Message message, @Nullable byte[] pattern) {
        LOGGER.info("Consumed event {}",message);
    }

}
