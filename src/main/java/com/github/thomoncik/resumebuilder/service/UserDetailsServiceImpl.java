package com.github.thomoncik.resumebuilder.service;

import com.github.thomoncik.resumebuilder.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        var user = userRepository.getUserByUsername(username);
        List<? extends GrantedAuthority> grantedAuthorities = List.of();
        return new org.springframework.security.core.userdetails.User(username,
                "password", grantedAuthorities);
    }
}
