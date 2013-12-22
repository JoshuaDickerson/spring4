package com.springapp4.mvc;

import org.hibernate.annotations.Entity;
import org.hibernate.annotations.Table;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * Created by josh on 12/22/13.
 */
@Entity
@Table(appliesTo = "team")
public class Team implements Serializable {
    private Long id;
    private String name;
    private Set<Player> players;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }
}
