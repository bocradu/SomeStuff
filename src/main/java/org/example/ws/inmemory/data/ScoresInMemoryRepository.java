package org.example.ws.inmemory.data;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.example.ws.db.helper.ScoresDBProxy;
import org.example.ws.model.Score;

public class ScoresInMemoryRepository implements ScoresDBProxy {
	
	private static BigInteger nextId;
	private static Map<BigInteger, Score> scoreMap;
		
	public Score get(BigInteger id){
			return scoreMap.get(id);
		}
		public Score save(Score score){//stores greeting objects into the map
			if(scoreMap == null){
				scoreMap = new HashMap<BigInteger, Score>();
				nextId = BigInteger.ONE;
			}
			//If Update
			if(score.getId() != null){
				Score oldScore = scoreMap.get(score.getId());
				if(oldScore == null){
					return null;
				}
				scoreMap.remove(score.getId());
				scoreMap.put(BigInteger.valueOf(score.getId()), score);
				return score;
			}
			//If Create
			score.setId(nextId.intValue());
			nextId = nextId.add(BigInteger.ONE);
			scoreMap.put(BigInteger.valueOf(score.getId()), score);
			return score;
		}
		
		public void delete(BigInteger id){
			scoreMap.remove(id);
		}
		
		static{
			ScoresInMemoryRepository tmp = new ScoresInMemoryRepository();
			Score s1 = new Score();
			s1.setScore(1);
			tmp.save(s1);
		
			Score s2 = new Score();
			s2.setScore(2);
			tmp.save(s2);
			
			Score s3 = new Score();
			s3.setScore(3);
			tmp.save(s3);
		}

		@Override
		public List<Score> get() {
			// TODO Auto-generated method stub
			return null;
		}
}
