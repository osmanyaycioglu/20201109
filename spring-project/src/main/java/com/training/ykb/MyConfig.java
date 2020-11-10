package com.training.ykb;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;

import a.b.c.OtherConfig;

@Configuration
@Import(OtherConfig.class)
public class MyConfig {


    @Value("${my.impl.process.type}")
    private int type;

    @Bean
    @Qualifier("qwerty")
    // @Scope("prototype")
    @Lazy
    public IProcess createProcess() {
        switch (this.type) {
            case 1:
                return new MyProcImpl();
            case 2:
                return new MyProcImpl2();

            default:
                return new MyProcImpl();
        }
    }
}
