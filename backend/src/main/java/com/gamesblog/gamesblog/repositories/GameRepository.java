package com.gamesblog.gamesblog.repositories;

import com.gamesblog.gamesblog.models.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game,Long> {
}
