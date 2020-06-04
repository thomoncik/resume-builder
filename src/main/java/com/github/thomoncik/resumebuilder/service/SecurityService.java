package com.github.thomoncik.resumebuilder.service;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
