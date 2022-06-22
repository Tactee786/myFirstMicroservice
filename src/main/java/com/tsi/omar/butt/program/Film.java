package com.tsi.omar.butt.program;

//import org.springframework.data.annotation.Id;
import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="film")
public class Film {

    //Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int filmId;
    String title;
    String description;
    Date releaseYear;
    String languageId;
    int length;
    String rating;


    //Mapping the many-to-many relationship between Film and Category into Film.
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name = "film_category",
            joinColumns = {
                    @JoinColumn(name ="filmId", referencedColumnName = "filmId", nullable = false, updatable = false)
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "categoryId", referencedColumnName = "categoryId", nullable = false, updatable = false)
            })
    private Set<Category> category = new HashSet<>();



    //Constructors
    public Film(String title, String description, Date releaseYear, String languageId, int length, String rating) {
        this.title = title;
        this.description = description;
        this.releaseYear = releaseYear;
        this.languageId = languageId;
        this.length = length;
        this.rating = rating;
    }
    public Film(){}

    //Methods
    public int getFilmId() {
        return filmId;
    }
    public void setFilmId(int filmId) {
        this.filmId = filmId;
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
    public Date getReleaseYear() {
        return releaseYear;
    }
    public void setReleaseYear(Date releaseYear) {
        this.releaseYear = releaseYear;
    }
    public String getLanguageId() {
        return languageId;
    }
    public void setLanguageId(String languageId) {
        this.languageId = languageId;
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
    public Set<Category> getCategory() {
        return category;
    }

    public void setCategory(Set<Category> category) {
        this.category = category;
    }
}
