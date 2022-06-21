package com.tsi.omar.butt.program;

import javax.persistence.*;

@Entity
@Table(name="actor")
public class Actor {

    //Attributes
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int actorId;
    String firstName;
    String lastName;

    //Constructors
    public Actor(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public Actor(){}

    //Methods
    public int getActorId() {
        return actorId;
    }
    public void setActorId(int actorId) {
        this.actorId = actorId;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
