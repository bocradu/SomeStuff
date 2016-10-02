package org.example.ws.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema = "cumvreau", name = "games")
public class Game {

    @Id
    @SequenceGenerator(name = "SEQ_GEN", sequenceName = "cumvreau.games_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN")
    private Integer id;
    
   
    
    @ManyToOne(cascade = CascadeType.ALL)
   // @JsonIgnore
    private Score scorePlayerOne;
    
    @ManyToOne(cascade = CascadeType.ALL)
  //  @JsonIgnore
    private Score scorePlayerTwo;
    
    @ManyToOne(cascade = CascadeType.ALL)
  //  @JsonIgnore
    private Player playerOne;
    
    @ManyToOne(cascade = CascadeType.ALL)
  //  @JsonIgnore
    private Player playerTwo;

    public Player getPlayerOne() {
        return playerOne;
    }

    public void setPlayerOne(Player playerOne) {
        this.playerOne = playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }

    public void setPlayerTwo(Player playerTwo) {
        this.playerTwo = playerTwo;
    }

    public Score getScorePlayerOne() {
        return scorePlayerOne;
    }

    public void setScorePlayerOne(Score scorePlayerOne) {
        this.scorePlayerOne = scorePlayerOne;
    }

    public Score getScorePlayerTwo() {
        return scorePlayerTwo;
    }

    public void setScorePlayerTwo(Score scorePlayerTwo) {
        this.scorePlayerTwo = scorePlayerTwo;
    }
    private String game;

    public Game() {

    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

}
