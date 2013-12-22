package com.springapp4.mvc;

import org.hibernate.annotations.Entity;
import org.hibernate.annotations.Table;


import javax.persistence.*;
import java.sql.Date;

/**
 * Created by josh on 12/21/13.
 */
@Entity
@Table(appliesTo = "player")
public class Player {


    private Long id;



    private Person person;
    private int jersey;
    private Date lastLogin;

    @OneToOne(fetch = FetchType.EAGER, cascade = {javax.persistence.CascadeType.PERSIST})
    @JoinColumn (name = "id")
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getJersey() {
        return jersey;
    }

    public void setJersey(int jersey) {
        this.jersey = jersey;
    }

    public String getFirstName(){
        return person.getFirstName();
    }

    public void setFirstName(String fn){
        this.person.setFirstName(fn);
    }
}
