package com.gamesblog.gamesblog.repositories;

import com.gamesblog.gamesblog.models.Coment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComentsRepository extends JpaRepository<Coment,Long> {
}
