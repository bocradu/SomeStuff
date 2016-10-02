package org.example.ws.web.api;

import java.util.List;
import org.example.ws.db.repository.PlayersRepository;
import org.example.ws.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayersController {
	
	@Autowired
	private PlayersRepository dbProxy;
	
		@RequestMapping(value = "/players", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<Player>> getPlayers() {
			
			List<Player> players = dbProxy.findAll();
			if(players == null){
				return new ResponseEntity<List<Player>>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<List<Player>>(players, HttpStatus.OK); 
		}

		@RequestMapping(value = "/players", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Player> createGame(@RequestBody Player player){
			Player savedPlayer = dbProxy.saveAndFlush(player);
			return new ResponseEntity<Player>(savedPlayer, HttpStatus.CREATED);
		}

}
