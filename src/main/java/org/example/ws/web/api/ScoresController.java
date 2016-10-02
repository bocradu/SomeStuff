package org.example.ws.web.api;

import java.util.List;

import org.example.ws.db.repository.ScoresRepository;
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
public class ScoresController {
	
	@Autowired
	private ScoresRepository dbProxy;
		@RequestMapping(value ="/scores", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<Score>> getScores(){
			
			List<Score> scores= dbProxy.findAll();
			if(scores == null){
				return new ResponseEntity<List<Score>>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<List<Score>>(scores, HttpStatus.OK); 
		}
		@RequestMapping(value = "/scores", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Score> createScore(@RequestBody Score score){
			Score savedScore = dbProxy.saveAndFlush(score);
			return new ResponseEntity<Score>(savedScore, HttpStatus.CREATED);
		}

}
