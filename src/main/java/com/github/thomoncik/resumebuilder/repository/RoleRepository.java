package com.github.thomoncik.resumebuilder.repository;

import com.github.thomoncik.resumebuilder.model.Role;

import java.util.Set;

public interface RoleRepository {
    Set<Role> findAll();
}
