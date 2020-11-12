package com.training.ykb.order.accounting.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.training.ykb.order.rest.OrderInfo;

@FeignClient("ACCOUNTING")
@RequestMapping("/payment")
public interface IAccountingClient {

    @PostMapping("/pay")
    public String pay(@RequestBody final OrderInfo oi) throws MyRestException;

}
