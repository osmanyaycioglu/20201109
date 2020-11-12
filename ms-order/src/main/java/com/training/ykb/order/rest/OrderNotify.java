package com.training.ykb.order.rest;


public class OrderNotify {

    private String number;
    private String text;

    public String getNumber() {
        return this.number;
    }

    public void setNumber(final String numberParam) {
        this.number = numberParam;
    }

    public String getText() {
        return this.text;
    }

    public void setText(final String textParam) {
        this.text = textParam;
    }

    @Override
    public String toString() {
        return "OrderNotify [number=" + this.number + ", text=" + this.text + "]";
    }


}
