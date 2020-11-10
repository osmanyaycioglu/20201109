package com.training.ykb.rest;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.ykb.db.Person;

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
    public String greet(@PathVariable("abc") final String name,
                        @PathVariable("soy") final String surname) {
        return "Hello " + name + " " + surname;
    }

    @GetMapping("/greet2")
    public String greet2(@RequestParam("abc") final String name,
                         @RequestParam("soy") final String surname) {
        return "Hello 2 " + name + " " + surname;
    }

    @GetMapping("/greet3/{ad}")
    public String greet3(@PathVariable("ad") final String name,
                         @RequestParam("soy") final String surname) {
        return "Hello 3 " + name + " " + surname;
    }

    @GetMapping("/greet4")
    public String greet4(@RequestHeader("abc") final String name,
                         @RequestHeader("soy") final String surname) {
        return "Hello 4 " + name + " " + surname;
    }

    @PostMapping("/greet5")
    public String greet5(@RequestBody final Person person) {
        return "Hello 5 " + person.getName() + " " + person.getSurname() + " " + person.getAge();
    }

    @PostMapping(value = "/greet6",
                 consumes = {
                              MediaType.APPLICATION_JSON_VALUE,
                              MediaType.APPLICATION_XML_VALUE
                 },
                 produces = {
                              MediaType.APPLICATION_JSON_VALUE,
                              MediaType.APPLICATION_XML_VALUE
                 })
    public Person greet6(@RequestBody final Person person,
                         final HttpServletRequest hsr) {
        person.setName("ali");
        return person;
    }


}

