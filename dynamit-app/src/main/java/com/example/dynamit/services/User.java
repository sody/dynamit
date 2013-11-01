package com.example.dynamit.services;

/**
 * @author Ivan Khalopik
 */
public class User {
    private Integer id;
    private String name;

    public User() {
    }

    public User(final String name) {
        this.name = name;
    }

    public User(final User user) {
        this.id = user.id;
        this.name = user.name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }
}
