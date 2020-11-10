package com.training.ykb.rest.design1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person/search")
public class PersonSearch {

    @GetMapping("/name")
    public String searchByName(@RequestParam("name") final String name) {
        return "OK";
    }

    @GetMapping("/surname")
    public String searchBySurname(@RequestParam("surname") final String surname) {
        return "OK";
    }

}
