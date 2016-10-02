package org.example.ws.db.repository;

import org.example.ws.model.Score;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoresRepository extends JpaRepository<Score, Integer>{

}
