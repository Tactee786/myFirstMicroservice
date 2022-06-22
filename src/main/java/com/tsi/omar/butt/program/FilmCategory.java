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
    private Integer filmId;
    private Integer categoryId;

    //Constructors
    public FilmCategory(Integer filmId, Integer categoryId){
        this.filmId = filmId;
        this.categoryId = categoryId;
    }
    public FilmCategory(){}

    //Methods
    public Integer getFilmId() {
        return filmId;
    }
    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }
    public Integer getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
}
