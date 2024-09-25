package org.example.projecteop.controller;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final CacheManager cacheManager;
    private final Cache cache;

    public UserController(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
        this.cache = cacheManager.getCache("users");
    }

    @GetMapping("/users/{user-id}")
    public String get(@PathVariable("user-id") Integer id) throws InterruptedException {
        String resp = cache.get(id, String.class);

        if (resp == null) {
            // db call
            Thread.sleep(3000);

            resp = "hello " + id;
            cache.put(id, resp);
        }

        return resp;
    }
}
