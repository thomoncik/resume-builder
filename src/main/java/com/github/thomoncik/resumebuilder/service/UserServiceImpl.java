package com.github.thomoncik.resumebuilder.service;

import com.github.thomoncik.resumebuilder.model.Role;
import com.github.thomoncik.resumebuilder.model.User;
import com.github.thomoncik.resumebuilder.repository.RoleRepository;
import com.github.thomoncik.resumebuilder.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User save(User user) {
        var toSave = new User(
                UUID.randomUUID(),
                user.getUsername(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                bCryptPasswordEncoder.encode(user.getPassword()),
                roleRepository.findAll().stream().map(Role::id).collect(Collectors.toSet())
        );
        return userRepository.save(toSave);
    }
}
