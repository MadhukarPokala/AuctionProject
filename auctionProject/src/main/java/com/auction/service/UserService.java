package com.auction.service;

import com.auction.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    String createUser(User user);
}
