package com.tsi.omar.butt.program;

import org.springframework.data.annotation.Id;
import javax.persistence.*;

@Entity
@Table(name="category")
public class Category {

    //Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int category_id;
    private String name;

    //Constructors
    public Category(int category_id, String name){
        this.category_id = category_id;
        this.name = name;
    }
    public Category(){}

    //Methods
    public int getCategory_id() {
        return category_id;
    }
    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
