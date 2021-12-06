package com.gamesblog.gamesblog.repositories;

import com.gamesblog.gamesblog.models.Mural;
import com.gamesblog.gamesblog.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MuralRepository extends JpaRepository<Mural,Long> {

    @Query("SELECT obj FROM Mural obj WHERE " +
            "obj.user = :user")
    Mural find(Optional<User> user);
}
