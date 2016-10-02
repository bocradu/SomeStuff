package org.example.ws.web.api;

import org.example.ws.db.repository.GamesRepository;
import org.example.ws.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {
	
	@Autowired
	private GamesRepository dbProxy;
	
	@RequestMapping(value = "/games/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Game> getGames(@PathVariable("id") Integer id) {

		Game game = dbProxy.findOne(id);
		if (game == null) {
			return new ResponseEntity<Game>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Game>(game, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/games/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Game> updateGame(@RequestBody Game game){
		
		Game updateGame = dbProxy.saveAndFlush(game);
		if(updateGame == null){
			return new ResponseEntity<Game>(
				HttpStatus.INTERNAL_SERVER_ERROR);
			}
			return new ResponseEntity<Game>(updateGame, HttpStatus.OK);
		}
	
	@RequestMapping(
			value = "/games/{id}",
			method = RequestMethod.DELETE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Game> deleteGame(
		@PathVariable("id") Integer id, @RequestBody Game game){
			
			dbProxy.delete(id);
			return new ResponseEntity<Game>(HttpStatus.NO_CONTENT);
					
		}
}
