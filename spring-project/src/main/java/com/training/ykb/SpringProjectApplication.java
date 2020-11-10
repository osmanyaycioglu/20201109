package com.training.ykb;

import java.security.SecureRandom;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.training.ykb.db.IPersonDAO;
import com.training.ykb.db.Person;

@SpringBootApplication
@EnableScheduling
//@SpringBootApplication(scanBasePackages = {"com.training.ykb","a.b.c"})
//@Component
//
//@Controller
//@Repository
//@Service
//@Configuration
public class SpringProjectApplication {

    @Autowired
    private MyBean         myBean;
    private final MyBean   myBeanCons;
    private MyBean         myBeanMethod;
    private final IProcess process;

    @Autowired
    private IPersonDAO     pDao;


    @Autowired
    public SpringProjectApplication(final MyBean myBeanCons,
                                    @Qualifier("qwerty") final IProcess processParam) {
        this.myBeanCons = myBeanCons;
        this.process = processParam;
    }

    @PostConstruct
    public void initXYZ() {
        this.myBean.execute();
    }

    @PreDestroy
    public void destroy() {

    }

    @Autowired
    public void methodWiring(final MyBean myBeanMethod) {
        this.myBeanMethod = myBeanMethod;
    }

    public void test() {
        this.myBean.execute();
    }

    @Scheduled(fixedDelay = 1_000, initialDelay = 100)
    public void abc() {
        System.out.println("abc run");
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public void writePerson() {
        SecureRandom randomLoc = new SecureRandom();
        Person personLoc = new Person();
        personLoc.setName("name" + randomLoc.nextInt());
        personLoc.setSurname("surname" + randomLoc.nextInt());
        personLoc.setAge(randomLoc.nextInt(100));
        this.pDao.save(personLoc);
        Person personLoc2 = new Person();
        personLoc2.setName("name" + randomLoc.nextInt());
        personLoc2.setSurname("surname" + randomLoc.nextInt());
        personLoc2.setAge(randomLoc.nextInt(100));
        this.pDao.save(personLoc2);
    }

}

