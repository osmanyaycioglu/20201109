package com.training.ykb.rest.design2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.ykb.db.Person;

@RestController
@RequestMapping("/api/v2/person/provision")
public class PersonProvisionV2 {

    @PostMapping("/add")
    public String add(@RequestBody final Person person) {
        return "OK";
    }

    @GetMapping("/delete")
    public String deactivate(@RequestParam("personId") final long personId) {
        return "OK";
    }

    @PostMapping("/update")
    public String update(@RequestBody final Person person) {
        return "OK";
    }

    @GetMapping("/find")
    public Person find(@RequestParam("personId") final long personId) {
        return null;
    }

    @GetMapping("/findAll")
    public Person findAll(@RequestParam("name") final String name) {
        return null;
    }

    @GetMapping("/xyz")
    public Person xyz(@RequestParam("name") final String name) {
        return null;
    }

}
