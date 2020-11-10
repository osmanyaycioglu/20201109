package com.training.ykb.db;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonDAO extends CrudRepository<Person, Long> {

    List<Person> findByName(String name);

    List<Person> findByNameAndSurnameOrderByName(String name,
                                                 String surname);


    @Query("select p from Person p where p.name=:isim")
    List<Person> araName(@Param("isim") String name);

    @Query(value = "select * from person p where p.name=:isim", nativeQuery = true)
    List<Person> araName2(@Param("isim") String name);


}
