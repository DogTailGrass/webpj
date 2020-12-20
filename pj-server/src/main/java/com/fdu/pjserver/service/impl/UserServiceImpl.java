package com.fdu.pjserver.service.impl;

import com.fdu.pjserver.dao.User;
import com.fdu.pjserver.repository.UserRepository;
import com.fdu.pjserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    public User addUser(User user) {
        return userRepository.save(user);
    }
}
