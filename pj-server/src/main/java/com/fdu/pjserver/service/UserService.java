package com.fdu.pjserver.service;

import com.fdu.pjserver.dao.User;

import java.util.Optional;

public interface UserService {
    User add(User user);

    void delete(String userId);

    User update(User user);

    Optional<User> retrieve(String userId);
}
