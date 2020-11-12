package com.training.ykb.order.accounting.client;


public class MyRestException extends Exception {

    private static final long serialVersionUID = 631006388980906577L;

    private ErrorObject       errorObject;

    public MyRestException(final ErrorObject eoParam) {
        super();
        this.errorObject = eoParam;
    }


    public MyRestException() {
    }


    public ErrorObject getErrorObject() {
        return this.errorObject;
    }


    public void setErrorObject(final ErrorObject errorObjectParam) {
        this.errorObject = errorObjectParam;
    }

}
