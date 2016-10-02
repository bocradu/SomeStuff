package org.example.ws.db.repository;

import org.example.ws.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayersRepository extends JpaRepository<Player, Integer>{

}
