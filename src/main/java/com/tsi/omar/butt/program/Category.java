package com.tsi.omar.butt.program;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="category")
public class Category {

    //Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;
    String name;

    @ManyToMany (mappedBy = "category", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Film> films = new HashSet<>();

    //Constructors
    public Category(int categoryId, String name){
        this.categoryId = categoryId;
        this.name = name;
    }
    public Category(){}

    //Methods
    public int getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Set<Film> getFilms() {
        return films;
    }
    public void setFilms(Set<Film> films) {
        this.films = films;
    }
}
