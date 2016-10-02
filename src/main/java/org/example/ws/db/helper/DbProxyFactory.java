package org.example.ws.db.helper;

import org.example.ws.inmemory.data.GamesInMemoryRepository;
import org.example.ws.inmemory.data.PlayersInMemoryRepository;
import org.example.ws.inmemory.data.ScoresInMemoryRepository;

public class DbProxyFactory {

	private final static PlayersDBProxy PLAYER_DB_PROXY = new PlayersInMemoryRepository();
	private final static GamesDBProxy GAME_DB_PROXY = new GamesInMemoryRepository();
	private final static ScoresDBProxy SCORE_DB_PROXY = new ScoresInMemoryRepository();

	public static PlayersDBProxy playerDbProxy() {
		return PLAYER_DB_PROXY;
	}

	public static GamesDBProxy gamesDBProxy() {
		return GAME_DB_PROXY;
	}

	public static ScoresDBProxy scoresDBProxy() {
		return SCORE_DB_PROXY;
	}
}