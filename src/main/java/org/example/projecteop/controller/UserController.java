package org.example.projecteop.controller;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final CacheManager cacheManager;
    private final Cache cache;

    public UserController(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
        this.cache = cacheManager.getCache("users");
    }

    @GetMapping("/users/{user-id}")
    @Cacheable(value = "users", key = "#id")
    public String get(@PathVariable("user-id") String id) throws InterruptedException {
        // db call
        Thread.sleep(3000);

        String resp = "hello " + id;

        return resp;
    }

    @PutMapping("/edit")
    @CachePut(value = "users",key = "#key")
    public String put(@RequestParam("key") String key,
                      @RequestParam("value") String value) throws InterruptedException {
        Thread.sleep(1000);
        return "hello " + value;
    }

    @DeleteMapping("/users/{key}")
    @CacheEvict(value = "users", key = "#key")
    public void del(@PathVariable("key") String key){
        System.out.println("del " + key);
    }
}
