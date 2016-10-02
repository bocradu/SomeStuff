package org.example.ws.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema = "cumvreau", name = "scores")
public class Score {

    

    @Id
    @SequenceGenerator(name = "SEQ_GEN", sequenceName = "cumvreau.scores_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN")
    private Integer id;

    private int score;
    private String game;
    
    /*@OneToMany(mappedBy = "scorePlayerOne")
    private List<Game> games;

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }*/

    public Score() {

    }

    public Integer getId() { //only to get not to set
        return id;
    }

  
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
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

}
