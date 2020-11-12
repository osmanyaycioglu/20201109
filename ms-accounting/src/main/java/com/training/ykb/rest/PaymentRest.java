package com.training.ykb.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentRest {

    @Value("${server.port}")
    private int port;

    @PostMapping("/pay")
    public String pay(@Validated @RequestBody final OrderInfo oi) {
        return "OK-" + this.port;
    }

}
