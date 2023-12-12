package com.example.ehcachedemo.config;

import javax.cache.Caching;
import javax.cache.spi.CachingProvider;

import java.time.Duration;

import javax.cache.CacheManager;

import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheEventListenerConfigurationBuilder;
import org.ehcache.config.builders.ExpiryPolicyBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.config.units.MemoryUnit;
import org.ehcache.event.EventType;
import org.ehcache.jsr107.Eh107Configuration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.ehcachedemo.entity.Movie;

@Configuration
@EnableCaching
public class CacheConfig {

    @Bean
    public CacheManager ehCacheManager() {
        CachingProvider provider = Caching.getCachingProvider();
        CacheManager cacheManager = provider.getCacheManager();

        // Cache configuration
        CacheConfigurationBuilder<String, Movie> configurationBuilder = CacheConfigurationBuilder
                .newCacheConfigurationBuilder(String.class, Movie.class,
                        ResourcePoolsBuilder.heap(1000).offheap(25, MemoryUnit.MB))
                .withExpiry(ExpiryPolicyBuilder.timeToLiveExpiration(Duration.ofMinutes(5)));

        // Cache event listener configuration
        CacheEventListenerConfigurationBuilder cacheEventListener = CacheEventListenerConfigurationBuilder
                .newEventListenerConfiguration(new CacheEventLogger(), EventType.CREATED,
                        EventType.EXPIRED,
                        EventType.UPDATED,
                        EventType.EVICTED,
                        EventType.REMOVED)
                .unordered()
                .asynchronous();

        cacheManager.createCache("movies",
                Eh107Configuration.fromEhcacheCacheConfiguration(
                        configurationBuilder.withService(cacheEventListener)));
        return cacheManager;
    }
}
