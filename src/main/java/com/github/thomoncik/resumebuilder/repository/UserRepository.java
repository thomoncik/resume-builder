package com.github.thomoncik.resumebuilder.repository;

import com.github.thomoncik.resumebuilder.model.User;

public interface UserRepository {
    User getUserByEmail(String email);
}
