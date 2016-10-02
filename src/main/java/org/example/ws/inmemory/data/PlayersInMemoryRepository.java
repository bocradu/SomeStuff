package org.example.ws.inmemory.data;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.example.ws.db.helper.PlayersDBProxy;
import org.example.ws.model.Player;

public class PlayersInMemoryRepository implements PlayersDBProxy{
	
	private static BigInteger nextId;
	private static Map<BigInteger, Player> gameMap;
		
	public Player get(BigInteger id){
			return gameMap.get(id);
		}
		public Player save(Player player){//stores greeting objects into the map
			if(gameMap == null){
				gameMap = new HashMap<BigInteger, Player>();
				nextId = BigInteger.ONE;
			}
			//If Update
			if(player.getId() != null){
				Player oldGame = gameMap.get(player.getId());
				if(oldGame == null){
					return null;
				}
				gameMap.remove(player.getId());
				gameMap.put(BigInteger.valueOf(player.getId()),player);
				return player;
			}
			//If Create
			player.setId(nextId.intValue() );
			nextId = nextId.add(BigInteger.ONE);
			gameMap.put(BigInteger.valueOf(player.getId()), player);
			return player;
		}
		
		public void delete(BigInteger id){
			gameMap.remove(id);
		}
		
		static{
			PlayersInMemoryRepository tmp = new PlayersInMemoryRepository();
			Player p1 = new Player();
			p1.setNickname("player1");
			tmp.save(p1);
		
			Player p2 = new Player();
			p2.setNickname("player2");
			tmp.save(p2);
			
			Player p3 = new Player();
			p3.setNickname("player3");
			tmp.save(p3);
		}
		@Override
		public List<Player> get() {
			// TODO Auto-generated method stub
			return null;
		}

}
