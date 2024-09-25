package org.example.projecteop.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Set;

@Configuration
public class SimpleCacheManager {


    @Bean
    public CacheManager getCacheManager() {
        ConcurrentMapCacheManager cacheManager = new ConcurrentMapCacheManager();
        cacheManager.setCacheNames(Set.of("users", "books"));
        return cacheManager;
    }

    @Scheduled(fixedRate = 4000)
    @CacheEvict(value = "users",allEntries = true)
    public void deleteAll(){
        System.out.println("deleteAll");
    }
}
