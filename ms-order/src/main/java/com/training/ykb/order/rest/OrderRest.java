package com.training.ykb.order.rest;

import java.security.SecureRandom;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.ykb.order.accounting.client.MyRestException;
import com.training.ykb.order.service.AccountingClientService;

@RestController
@RequestMapping("/order")
public class OrderRest {

    @Autowired
    private AccountingClientService acs;

    @Autowired
    private RabbitTemplate          rt;

    @PostMapping("/place")
    public String place(@RequestBody final OrderInfo oi) {
        return this.acs.placeOrder(oi);

    }

    @PostMapping("/placef")
    public String placef(@RequestBody final OrderInfo oi) throws MyRestException {
        return this.acs.placeOrderFeign(oi);
    }

    @GetMapping("/testr")
    public String testRabbit() {
        SecureRandom randomLoc = new SecureRandom();
        OrderNotify orderNotifyLoc = new OrderNotify();
        orderNotifyLoc.setNumber("543" + randomLoc.nextInt());
        orderNotifyLoc.setText("Random : " + randomLoc.nextLong());
        this.rt.convertAndSend("notif_exchange",
                               "order_notify",
                               orderNotifyLoc);
        return "OK";
    }

}
