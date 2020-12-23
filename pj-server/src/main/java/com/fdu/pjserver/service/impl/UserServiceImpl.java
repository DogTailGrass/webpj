package com.fdu.pjserver.service.impl;

import com.fdu.pjserver.dao.User;
import com.fdu.pjserver.repository.UserDAO;
import com.fdu.pjserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    public User add(User user) {
        return userDAO.save(user);
    }

    public void delete(String userId) {

    }

    public User update(User user) {
        return userDAO.save(user);
    }

    public Optional<User> retrieve(String userId) {
        return userDAO.findById(userId);
//        return userDAO.findUserByUserId(userId);
    }
}
