package com.training.ykb.db;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@XmlRootElement
public class Person {

    @Id
    @GeneratedValue
    @JsonIgnore
    @XmlTransient
    private long    personId;
    //@Column(name = "isim")
    private String  name;
    private String  surname;
    private Integer age;

    public String getName() {
        return this.name;
    }

    public void setName(final String nameParam) {
        this.name = nameParam;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(final String surnameParam) {
        this.surname = surnameParam;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(final Integer ageParam) {
        this.age = ageParam;
    }

    public long getPersonId() {
        return this.personId;
    }

    public void setPersonId(final long personIdParam) {
        this.personId = personIdParam;
    }


}
