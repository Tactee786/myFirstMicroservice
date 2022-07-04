package com.tsi.omar.butt.program;

import javax.persistence.*;

@Entity
@Table(name = "film_actor")
public class FilmActor {

    //Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int actorId;
    private int filmId;
    //Constructors
    public FilmActor(int actorId, int filmId){
        this.actorId = actorId;
        this.filmId = filmId;
    }
    public FilmActor(){}

    //Methods
    public int getActorId() {
        return actorId;
    }
    public void setActorId(int actorId) {
        this.actorId = actorId;
    }
    public int getFilmId() {
        return filmId;
    }
    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }
}
