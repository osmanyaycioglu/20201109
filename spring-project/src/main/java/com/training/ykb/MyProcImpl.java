package com.training.ykb;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("xyz")
public class MyProcImpl implements IProcess {

    @Override
    public String execute() {
        return "executed";
    }

}
