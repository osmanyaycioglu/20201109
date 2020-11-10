package com.training.ykb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MyBean {

    @Autowired
    @Qualifier("qwerty")
    private IProcess process;


    public void execute() {
        System.out.println(this.process.execute());
    }

}
