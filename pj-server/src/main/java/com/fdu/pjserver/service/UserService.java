package com.fdu.pjserver.service;

import com.fdu.pjserver.dao.User;

public interface UserService {
    User addUser(User user);

    void delete(String userId);

    User update(User user);

    User retrieve(String userId);
}
