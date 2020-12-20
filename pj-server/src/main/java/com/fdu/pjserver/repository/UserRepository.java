package com.fdu.pjserver.repository;

import com.fdu.pjserver.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
