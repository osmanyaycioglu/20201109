package com.training.ykb.order.listener;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MyRabbitListener {

    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "notif_response_q",
                                                            autoDelete = "false",
                                                            durable = "true"),
                                             exchange = @Exchange(name = "notif_response_exchange",
                                                                  durable = "true",
                                                                  type = ExchangeTypes.DIRECT),
                                             key = "order_notify_response"))
    public void handleEventXYZ(final String str) {
        System.out.println(str);
    }

}
