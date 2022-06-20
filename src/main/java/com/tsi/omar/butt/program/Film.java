package com.tsi.omar.butt.program;

import org.springframework.data.annotation.Id;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="film")
public class Film {

    //Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int film_id;
    private String title;
    private String description;
    private Date release_year;
    private String language_id;
    private int length;
    private String rating;

    //Constructors
    public Film(String title, String description, Date release_year, String language_id, int length, String rating) {
        this.title = title;
        this.description = description;
        this.release_year = release_year;
        this.language_id = language_id;
        this.length = length;
        this.rating = rating;
    }
    public Film(){}

    //Methods
    public int getFilm_id() {
        return film_id;
    }
    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Date getRelease_year() {
        return release_year;
    }
    public void setRelease_year(Date release_year) {
        this.release_year = release_year;
    }
    public String getLanguage_id() {
        return language_id;
    }
    public void setLanguage_id(String language_id) {
        this.language_id = language_id;
    }
    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }
    public String getRating() {
        return rating;
    }
    public void setRating(String rating) {
        this.rating = rating;
    }

}
