package org.example.ws.db.repository;

import org.example.ws.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GamesRepository extends JpaRepository<Game, Integer> {
}
