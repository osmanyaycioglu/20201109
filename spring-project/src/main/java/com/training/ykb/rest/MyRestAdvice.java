package com.training.ykb.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.training.ykb.error.ErrorObject;

@RestControllerAdvice
public class MyRestAdvice {

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObject handleIllegalArgumentException(final IllegalArgumentException exp) {
        ErrorObject eo = new ErrorObject().setDomain("IT")
                                          .setSubDomain("CRM")
                                          .setBoundedContext("Paket")
                                          .setMessage(exp.getMessage())
                                          .setErrorCause(1003);
        return eo;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObject handleIllegalArgumentException(final MethodArgumentNotValidException exp) {
        ErrorObject root = new ErrorObject().setDomain("IT")
                                            .setSubDomain("CRM")
                                            .setBoundedContext("Paket")
                                            .setMessage("Validasyon problemi oluştu")
                                            .setErrorCause(1003);
        List<ObjectError> allErrorsLoc = exp.getBindingResult()
                                            .getAllErrors();
        for (ObjectError objectErrorLoc : allErrorsLoc) {
            root.addSubError(new ErrorObject().setDomain("IT")
                                              .setSubDomain("CRM")
                                              .setBoundedContext("Paket")
                                              .setMessage(objectErrorLoc.toString())
                                              .setErrorCause(1003));
        }
        return root;
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorObject> handleException(final Exception exp) {
        ErrorObject eo = new ErrorObject().setDomain("IT")
                                          .setSubDomain("CRM")
                                          .setBoundedContext("Paket")
                                          .setMessage(exp.getMessage())
                                          .setErrorCause(1003);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                             .body(eo);

    }

}
