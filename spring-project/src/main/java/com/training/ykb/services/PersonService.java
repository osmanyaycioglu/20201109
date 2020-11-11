package com.training.ykb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.ykb.db.IPersonDAO;
import com.training.ykb.db.Person;

@Service
public class PersonService {

    @Autowired
    private IPersonDAO pd;

    public String add(final Person person) {
        this.pd.save(person);
        return "OK";
    }

}
