package com.github.thomoncik.resumebuilder.model;

import java.util.Set;
import java.util.UUID;

public class Role {
    private final UUID id;
    private final String name;
    private final Set<User> users;

    public Role(UUID id, String name, Set<User> users) {
        this.id = id;
        this.name = name;
        this.users = users;
    }

    public UUID id() {
        return id;
    }

    public String name() {
        return name;
    }

    public Set<User> users() {
        return users;
    }
}
