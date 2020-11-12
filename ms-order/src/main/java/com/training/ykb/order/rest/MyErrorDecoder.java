package com.training.ykb.order.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.training.ykb.order.accounting.client.ErrorObject;
import com.training.ykb.order.accounting.client.MyRestException;

import feign.Response;
import feign.Response.Body;
import feign.codec.ErrorDecoder;

public class MyErrorDecoder implements ErrorDecoder {

    @Override
    public MyRestException decode(final String methodKeyParam,
                                  final Response responseParam) {
        try {
            if (responseParam.status() != 404) {
                Body bodyLoc = responseParam.body();
                ObjectMapper mapperLoc = new ObjectMapper();
                ErrorObject errorLoc = mapperLoc.readValue(bodyLoc.asInputStream(),
                                                           ErrorObject.class);
                MyRestException myRestExceptionLoc = new MyRestException(errorLoc);
                return myRestExceptionLoc;
            } else {
                MyRestException myRestExceptionLoc = new MyRestException();
                return myRestExceptionLoc;
            }
        } catch (Exception eLoc) {
            eLoc.printStackTrace();
            MyRestException myRestExceptionLoc = new MyRestException();
            return myRestExceptionLoc;
        }
    }

}
