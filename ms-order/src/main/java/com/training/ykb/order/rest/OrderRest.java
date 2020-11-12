package com.training.ykb.order.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.ykb.order.service.AccountingClientService;

@RestController
@RequestMapping("/order")
public class OrderRest {

    @Autowired
    private AccountingClientService acs;

    @PostMapping("/place")
    public String place(final OrderInfo oi) {
        return this.acs.placeOrder(oi);

    }

}
