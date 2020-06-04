package com.github.thomoncik.resumebuilder.service;

import com.github.thomoncik.resumebuilder.model.User;

public interface UserService {
    User findByUsername(String username);

    User save(User userForm);
}

