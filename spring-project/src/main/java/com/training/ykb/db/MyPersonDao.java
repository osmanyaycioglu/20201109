package com.training.ykb.db;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class MyPersonDao {

    @PersistenceUnit
    private EntityManagerFactory emf;

    //    @Autowired
    //    private UserTransaction      ut;


    @Transactional
    public void personWrite(final Person per) {
        EntityManager em = this.emf.createEntityManager();
        em.joinTransaction();
        em.persist(per);
        em.close();
    }

}
