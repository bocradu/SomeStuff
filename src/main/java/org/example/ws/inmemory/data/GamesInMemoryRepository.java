package org.example.ws.inmemory.data;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.example.ws.db.helper.GamesDBProxy;
import org.example.ws.model.Game;

public class GamesInMemoryRepository implements GamesDBProxy {
	private static BigInteger nextId;
	private static Map<BigInteger, Game> gameMap;

	public Game get(BigInteger id) {
		return gameMap.get(id);
	}

	public Game save(Game game) {// stores greeting objects into the map
		if (gameMap == null) {
			gameMap = new HashMap<BigInteger, Game>();
			nextId = BigInteger.ONE;
		}
		// If Update
		if (game.getId() != null) {
			Game oldGame = gameMap.get(game.getId());
			if (oldGame == null) {
				return null;
			}
			gameMap.remove(game.getId());
			gameMap.put(BigInteger.valueOf(game.getId()), game);
			return game;
		}
		// If Create
		game.setId(nextId.intValue());
		nextId = nextId.add(BigInteger.ONE);
		gameMap.put(BigInteger.valueOf(game.getId()), game);
		return game;
	}

	public void delete(BigInteger id) {
		gameMap.remove(id);
	}

	static {
		GamesInMemoryRepository tmp = new GamesInMemoryRepository();
		Game g1 = new Game();
		g1.setGame("Mortal Kombat");
		tmp.save(g1);

		Game g2 = new Game();
		g2.setGame("FIFA");
		tmp.save(g2);

		Game g3 = new Game();
		g3.setGame("Halo");
		tmp.save(g3);
	}

	@Override
	public List<Game> get() {
		// TODO Auto-generated method stub
		return null;
	}

}
