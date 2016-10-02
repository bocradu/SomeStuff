package org.example.ws.web.api;

import java.util.List;
import javax.xml.ws.http.HTTPException;

import org.example.ws.db.repository.GamesRepository;
import org.example.ws.db.repository.PlayersRepository;
import org.example.ws.db.repository.ScoresRepository;
import org.example.ws.model.Game;
import org.example.ws.model.Player;
import org.example.ws.model.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GamesController {

    @Autowired
    private GamesRepository dbProxy;

    @Autowired
    private ScoresRepository scoreDbProxy;
    
    @Autowired
    private PlayersRepository playerDbProxy;
    
    @RequestMapping(value = "/games", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Game> getGames() {

        List<Game> games = dbProxy.findAll();
        if (games == null) {
            throw new HTTPException(500);
        }
        return games;
    }

    @RequestMapping(value = "/games", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Game createGame(@RequestBody Game game) {
        Player p1 = playerDbProxy.saveAndFlush(game.getPlayerOne());
        Player p2 = playerDbProxy.saveAndFlush(game.getPlayerTwo());
        Score scoreP1 = scoreDbProxy.saveAndFlush(game.getScorePlayerOne());
        Score scoreP2 = scoreDbProxy.saveAndFlush(game.getScorePlayerTwo());
        game = dbProxy.saveAndFlush(game);
        return game;
    }
}
