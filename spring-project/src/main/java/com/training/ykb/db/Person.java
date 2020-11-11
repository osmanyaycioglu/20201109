package com.training.ykb.db;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.training.ykb.validation.StartWith;

@Entity
@XmlRootElement
public class Person {

    @Id
    @GeneratedValue
    @JsonIgnore
    @XmlTransient
    private long    personId;
    //@Column(name = "isim")
    @NotEmpty
    @Size(max = 30, min = 2, message = "Isim 2 ila 30 arasında olmalı")
    private String  name;

    @StartWith("test")
    private String  surname;

    @Max(value = 120, message = "Yaş 120 den büyük olamaz")
    @Min(18)
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
