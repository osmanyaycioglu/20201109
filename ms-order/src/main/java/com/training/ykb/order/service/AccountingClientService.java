package com.training.ykb.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import com.training.ykb.order.accounting.client.IAccountingClient;
import com.training.ykb.order.accounting.client.MyRestException;
import com.training.ykb.order.rest.OrderInfo;

@Service
public class AccountingClientService {

    @Autowired
    private RestTemplate      rt;

    @Autowired
    private EurekaClient      ec;

    @Autowired
    private IAccountingClient ac;

    public String placeOrder(final OrderInfo oi) {
        String resultLoc = this.rt.postForObject("http://ACCOUNTING/payment/pay",
                                                 oi,
                                                 String.class);
        return resultLoc;
    }

    public String placeOrderFeign(final OrderInfo oi) throws MyRestException {
        return this.ac.pay(oi);
    }

    public String placeOrder2(final OrderInfo oi) {
        Application applicationLoc = this.ec.getApplication("ACCOUNTING");
        List<InstanceInfo> instancesLoc = applicationLoc.getInstances();
        for (InstanceInfo instanceInfoLoc : instancesLoc) {
            System.out.println(instanceInfoLoc);
        }
        InstanceInfo nextServerFromEurekaLoc = this.ec.getNextServerFromEureka("ACCOUNTING",
                                                                               false);
        RestTemplate restTemplateLoc = new RestTemplate();
        String resultLoc = restTemplateLoc.postForObject("http://"
                                                         + nextServerFromEurekaLoc.getIPAddr()
                                                         + ":"
                                                         + nextServerFromEurekaLoc.getPort()
                                                         + "/payment/pay",
                                                         oi,
                                                         String.class);
        return "OK";
    }

}
