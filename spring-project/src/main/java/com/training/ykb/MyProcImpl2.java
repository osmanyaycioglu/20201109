package com.training.ykb;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("abc")
public class MyProcImpl2 implements IProcess {

    @Override
    public String execute() {
        return "executed 2";
    }

}
