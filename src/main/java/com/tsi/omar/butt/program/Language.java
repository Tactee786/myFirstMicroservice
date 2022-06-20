package com.tsi.omar.butt.program;

import org.springframework.data.annotation.Id;
import javax.persistence.*;

@Entity
@Table(name = "language")
public class Language {

    //Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int language_id;
    private String name;

    //Constructors
    public Language(String name){
        this.language_id = language_id;
    }
    public Language(){}

    //Methods
    public int getLanguage_id() {
        return language_id;
    }
    public void setLanguage_id(int language_id) {
        this.language_id = language_id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
