package com.example.testproject.service.impl;

import com.example.testproject.DAO.UserDao;
import com.example.testproject.model.User;
import com.example.testproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public String createUser(User user) {
        userDao.save(user);
        return "success";
    }
    
}
