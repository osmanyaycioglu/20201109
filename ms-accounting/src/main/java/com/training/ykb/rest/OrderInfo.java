package com.training.ykb.rest;


public class OrderInfo {

    private String orderId;
    private long   amount;

    public String getOrderId() {
        return this.orderId;
    }

    public void setOrderId(final String orderIdParam) {
        this.orderId = orderIdParam;
    }

    public long getAmount() {
        return this.amount;
    }

    public void setAmount(final long amountParam) {
        this.amount = amountParam;
    }

}
