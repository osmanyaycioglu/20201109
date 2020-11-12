package com.training.ykb.order.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.training.ykb.order.accounting.client.ErrorObject;
import com.training.ykb.order.accounting.client.MyRestException;

@RestControllerAdvice
public class OrderRestAdvice {

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObject handleIllegalArgumentException(final IllegalArgumentException exp) {
        ErrorObject eo = new ErrorObject().setDomain("IT")
                                          .setSubDomain("CRM")
                                          .setBoundedContext("Order")
                                          .setMessage(exp.getMessage())
                                          .setErrorCause(1003);
        return eo;
    }

    @ExceptionHandler(MyRestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObject handleIllegalArgumentException(final MyRestException exp) {
        ErrorObject eo = new ErrorObject().setDomain("IT")
                                          .setSubDomain("CRM")
                                          .setBoundedContext("Order")
                                          .setMessage("Error while calling another MS")
                                          .setErrorCause(1003);
        eo.addSubError(exp.getErrorObject());
        return eo;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObject handleIllegalArgumentException(final MethodArgumentNotValidException exp) {
        ErrorObject root = new ErrorObject().setDomain("IT")
                                            .setSubDomain("CRM")
                                            .setBoundedContext("Order")
                                            .setMessage("Validasyon problemi oluştu")
                                            .setErrorCause(1003);
        List<ObjectError> allErrorsLoc = exp.getBindingResult()
                                            .getAllErrors();
        for (ObjectError objectErrorLoc : allErrorsLoc) {
            root.addSubError(new ErrorObject().setDomain("IT")
                                              .setSubDomain("CRM")
                                              .setBoundedContext("Order")
                                              .setMessage(objectErrorLoc.toString())
                                              .setErrorCause(1003));
        }
        return root;
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorObject> handleException(final Exception exp) {
        ErrorObject eo = new ErrorObject().setDomain("IT")
                                          .setSubDomain("CRM")
                                          .setBoundedContext("Order")
                                          .setMessage(exp.getMessage())
                                          .setErrorCause(1003);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                             .body(eo);

    }

}
