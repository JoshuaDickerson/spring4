
package com.springapp4.mvc.model;

import org.hibernate.annotations.Entity;
import org.hibernate.annotations.Table;

import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(appliesTo = "person")
public class Person implements Serializable{
    private Long id;
    private String firstName;
    private String lastName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}