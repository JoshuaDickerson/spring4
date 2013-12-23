package com.springapp4.mvc.model;

import com.springapp4.mvc.model.Person;
import org.hibernate.annotations.Entity;
import org.hibernate.annotations.Table;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by josh on 12/21/13.
 */
@Entity
@Table(appliesTo = "user")
public class User {
    private Long id;

    private Person person;
    private String password;
    private String username;
    private Date lastLogin;


    @OneToOne(fetch = FetchType.EAGER, cascade = {javax.persistence.CascadeType.PERSIST})
    @JoinColumn (name = "id")
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }
}
