package org.example.ws.web.api;

import org.example.ws.db.repository.ScoresRepository;
import org.example.ws.model.Score;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScoreController {
	
	private ScoresRepository dbProxy;
	
	@RequestMapping(value = "/scores/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Score> getScores(@PathVariable("id") Integer id) {

		Score score = dbProxy.getOne(id);
		if (score == null) {
			return new ResponseEntity<Score>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Score>(score, HttpStatus.OK);
	}
	@RequestMapping(value = "/scores/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Score> updateScore(@RequestBody Score score){
		
		Score updateScore = dbProxy.saveAndFlush(score);
		if(updateScore == null){
			return new ResponseEntity<Score>(
				HttpStatus.INTERNAL_SERVER_ERROR);
			}
			return new ResponseEntity<Score>(updateScore, HttpStatus.OK);
		}
	
	@RequestMapping(value = "/scores/{id}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Score> deleteScore(
		@PathVariable("id") Integer id, @RequestBody Score score){
			
			dbProxy.delete(id);
			return new ResponseEntity<Score>(HttpStatus.NO_CONTENT);
					
		}
}