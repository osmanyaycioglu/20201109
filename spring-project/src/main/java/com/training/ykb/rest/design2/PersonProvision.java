package com.training.ykb.rest.design2;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.ykb.db.Person;
import com.training.ykb.services.PersonService;

@RestController
@RequestMapping("/api/v1/person/provision")
@Validated
public class PersonProvision {

    @Autowired
    private PersonService ps;

    @PostMapping("/add")
    public String add(@Validated @RequestBody final Person person) {
        //        if ((person.getName() == null)
        //            && person.getName()
        //                     .isEmpty()) {
        //            throw new IllegalArgumentException();
        //        }
        return this.ps.add(person);
    }

    @GetMapping("/delete")
    public String deactivate(@RequestParam("personId") @NotNull final Long personId) {
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
