package com.github.thomoncik.resumebuilder.repository;

import com.github.thomoncik.resumebuilder.model.Role;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public class JooqRoleRepository implements RoleRepository {
    @Override
    public Set<Role> findAll() {
        return Set.of();
    }
}
