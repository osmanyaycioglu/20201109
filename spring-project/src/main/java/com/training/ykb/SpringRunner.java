package com.training.ykb;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

public class SpringRunner {

    public static void main(final String[] args) {
        ConfigurableApplicationContext runLoc = SpringApplication.run(SpringProjectApplication.class,
                                                                      args);
        SpringProjectApplication beanLoc = runLoc.getBean(SpringProjectApplication.class);
        beanLoc.test();
    }

}
