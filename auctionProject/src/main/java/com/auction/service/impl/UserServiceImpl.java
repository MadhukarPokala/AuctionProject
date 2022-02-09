package com.auction.service.impl;

import com.auction.DAO.UserDao;
import com.auction.service.UserService;
import com.auction.model.User;
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
