package com.training.ykb;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/first")
public class FirstRest {

    @GetMapping
    public String hello() {
        return "Hello world";
    }

}
