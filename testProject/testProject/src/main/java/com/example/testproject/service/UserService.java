package com.example.testproject.service;

import com.example.testproject.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    String createUser(User user);
}
