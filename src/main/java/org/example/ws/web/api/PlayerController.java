package org.example.ws.web.api;

import org.example.ws.db.repository.PlayersRepository;
import org.example.ws.model.Player;
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
	public class PlayerController {
		
		@Autowired
		private PlayersRepository dbProxy;
		
		@RequestMapping(value = "/players/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Player> getPlayers(@PathVariable("id") Integer id) {

			Player player = dbProxy.findOne(id);
			if (player == null) {
				return new ResponseEntity<Player>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<Player>(player, HttpStatus.OK);
		}
		
		@RequestMapping(value = "/players/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Player> updatePlayer(@RequestBody Player player){
			
			Player updatePlayer = dbProxy.saveAndFlush(player);
			if(updatePlayer == null){
				return new ResponseEntity<Player>(
					HttpStatus.INTERNAL_SERVER_ERROR);
				}
				return new ResponseEntity<Player>(updatePlayer, HttpStatus.OK);
			}
		
		@RequestMapping(value = "/player/{id}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Player> deletePlayer(
			@PathVariable("id") Integer id, @RequestBody Player player){
				
				dbProxy.delete(id);
				return new ResponseEntity<Player>(HttpStatus.NO_CONTENT);
		}
}
