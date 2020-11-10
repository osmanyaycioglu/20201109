package com.training.ykb.rest.design1;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.ykb.db.Person;

@RestController
@RequestMapping("/person/provision")
public class PersonProvision {

    @PutMapping
    public String add(@RequestBody final Person person) {
        return "OK";
    }

    @DeleteMapping
    public String deactivate(@RequestParam("personId") final long personId) {
        return "OK";
    }

    @PatchMapping
    public String update(@RequestBody final Person person) {
        return "OK";
    }

    @GetMapping
    public Person find(@RequestParam("personId") final long personId) {
        return null;
    }
}
