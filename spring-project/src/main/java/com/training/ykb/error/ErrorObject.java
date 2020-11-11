package com.training.ykb.error;

import java.util.ArrayList;
import java.util.List;

public class ErrorObject {

    private List<ErrorObject> subErrorList;

    private String            domain;
    private String            subDomain;
    private String            boundedContext;
    private String            microService;
    private String            message;
    private int               errorCause;


    public ErrorObject() {
    }

    public static void main(final String[] args) {
        ErrorObject eo = new ErrorObject().setDomain("IT")
                                          .setSubDomain("CRM")
                                          .setBoundedContext("Paket")
                                          .setMessage("Error oluştu")
                                          .setErrorCause(1003);
    }

    public List<ErrorObject> getSubErrorList() {
        return this.subErrorList;
    }

    public ErrorObject addSubError(final ErrorObject eo) {
        if (this.subErrorList == null) {
            this.subErrorList = new ArrayList<>();
        }
        this.subErrorList.add(eo);
        return this;
    }

    public String getDomain() {
        return this.domain;
    }

    public ErrorObject setDomain(final String domainParam) {
        this.domain = domainParam;
        return this;
    }

    public String getSubDomain() {
        return this.subDomain;
    }

    public ErrorObject setSubDomain(final String subDomainParam) {
        this.subDomain = subDomainParam;
        return this;
    }

    public String getBoundedContext() {
        return this.boundedContext;
    }

    public ErrorObject setBoundedContext(final String boundedContextParam) {
        this.boundedContext = boundedContextParam;
        return this;
    }

    public String getMicroService() {
        return this.microService;
    }

    public ErrorObject setMicroService(final String microServiceParam) {
        this.microService = microServiceParam;
        return this;
    }

    public String getMessage() {
        return this.message;
    }

    public ErrorObject setMessage(final String messageParam) {
        this.message = messageParam;
        return this;
    }

    public int getErrorCause() {
        return this.errorCause;
    }

    public ErrorObject setErrorCause(final int errorCauseParam) {
        this.errorCause = errorCauseParam;
        return this;
    }

}
