package com.example.ehcachedemo.config;

import org.ehcache.event.CacheEvent;
import org.ehcache.event.CacheEventListener;

import com.example.ehcachedemo.entity.Movie;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CacheEventLogger implements CacheEventListener<String,Movie> {

    @Override
    public void onEvent(CacheEvent<? extends String, ? extends Movie> cacheEvent) {
        log.info("Key: {}, EventType: {}, Old value: {}, New value: {}",
                cacheEvent.getKey(),
                cacheEvent.getType(),
                cacheEvent.getOldValue(),
                cacheEvent.getNewValue());
    }

}
