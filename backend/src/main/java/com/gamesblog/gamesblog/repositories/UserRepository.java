package com.gamesblog.gamesblog.repositories;

import com.gamesblog.gamesblog.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String username);
}
