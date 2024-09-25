package org.example.projecteop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @GetMapping("/books/{book-id}")
    public String get(@PathVariable("book-id") Integer id) {
        return "book " + id;
    }
}
