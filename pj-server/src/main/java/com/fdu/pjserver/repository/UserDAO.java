package com.fdu.pjserver.repository;

import com.fdu.pjserver.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface UserDAO extends JpaRepository<User, String>, JpaSpecificationExecutor<User> {
    @Query(value = "from User where user_id=?1")
    public User findUserByUserId(String userId);
}
