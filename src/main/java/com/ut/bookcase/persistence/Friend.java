package com.ut.bookcase.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = Friend.ALL_FRIENDS, query = "SELECT f FROM Friend f")
public class Friend {

    public static final String ALL_FRIENDS = "Friend.findAll";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    private Friend() {
    }

    public Friend(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
