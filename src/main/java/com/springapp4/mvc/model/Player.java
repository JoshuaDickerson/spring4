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
@Table(appliesTo = "player")
public class Player extends Person {
    private Long playerId;
    private int jersey;
    private Date lastLogin;

    public Player(String firstName, String lastName, int jersey){
        super(firstName, lastName);
    }

    public Player() {
    }

    @Column(name = "id")
    @GeneratedValue
    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long id) {
        this.playerId = id;
    }

    public int getJersey() {
        return jersey;
    }

    public void setJersey(int jersey) {
        this.jersey = jersey;
    }

    public void setFirstName(String fn){
        super.setFirstName(fn);
    }

    @Override
    public String getLastName() {
        return super.getLastName();
    }

    @Override
    public void setLastName(String lastName) {
        super.setLastName(lastName);
    }
}
