package com.tsi.omar.butt.program;

import org.springframework.data.annotation.Id;
import javax.persistence.*;

@Entity
@Table(name = "film_actor")
public class FilmActor {

    //Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int actor_id;
    private int film_id;
    //Constructors
    public FilmActor(int actor_id, int film_id){
        this.actor_id = actor_id;
        this.film_id = film_id;
    }
    public FilmActor(){}

    //Methods
    public int getActor_id() {
        return actor_id;
    }
    public void setActor_id(int actor_id) {
        this.actor_id = actor_id;
    }
    public int getFilm_id() {
        return film_id;
    }
    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }
}
