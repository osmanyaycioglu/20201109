package com.training.ykb.rest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonRest {

    @GetMapping("/test")
    public String testGet() {
        return "Test GET";
    }

    @PostMapping("/test")
    public String testPost() {
        return "Test POST";
    }

    @PutMapping("/test")
    public String testPut() {
        return "Test PUT";
    }

    @PatchMapping("/test")
    public String testPatch() {
        return "Test PATCH";
    }

    @DeleteMapping("/test")
    public String testDelete() {
        return "Test DELETE";
    }

    @GetMapping("/greet/{abc}/sur/{soy}")
    public String name(@PathVariable("abc") final String name,
                       @PathVariable("soy") final String surname) {
        return "Hello " + name + " " + surname;
    }

}
