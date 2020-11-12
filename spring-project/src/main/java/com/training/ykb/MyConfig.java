package com.training.ykb;

import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

import a.b.c.OtherConfig;

@Configuration
@Import(OtherConfig.class)
@EnableAsync
public class MyConfig {


    @Value("${my.impl.process.type}")
    private int type;


    @Async
    public Future<String> asyncMethod() {
        return null;
    }

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
