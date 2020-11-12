package com.training.ykb.rest;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class OrderInfo {

    @NotNull
    private String orderId;
    @Max(10_000)
    @Min(10)
    @NotNull
    private Long   amount;

    public String getOrderId() {
        return this.orderId;
    }

    public void setOrderId(final String orderIdParam) {
        this.orderId = orderIdParam;
    }

    public Long getAmount() {
        return this.amount;
    }

    public void setAmount(final Long amountParam) {
        this.amount = amountParam;
    }


}
