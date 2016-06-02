package com.theironyard.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Assignment {

    @Id
    @GeneratedValue
    int id;

    String name;

    String description;

    boolean required;

    public Assignment(){}

    public Assignment(String name, String description, boolean required) {
        this.name = name;
        this.description = description;
        this.required = required;
    }
}
