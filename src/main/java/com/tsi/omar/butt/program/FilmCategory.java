package com.tsi.omar.butt.program;

import com.fasterxml.jackson.annotation.JsonIgnore;
//import org.springframework.data.annotation.Id;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "film_category")
public class FilmCategory {

    //Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int filmId;
    private int categoryId;

    //Constructors
    public FilmCategory(int filmId, int categoryId){
        this.filmId = filmId;
        this.categoryId = categoryId;
    }
    public FilmCategory(){}

    //Methods
    public int getFilmId() {
        return filmId;
    }
    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }
    public int getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
