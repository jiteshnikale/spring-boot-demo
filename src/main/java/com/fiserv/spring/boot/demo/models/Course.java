package com.fiserv.spring.boot.demo.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity //(name="Course")
public class Course {
    @Id
    private long id;

    //@Column(name="name")
    private String name;

    //@Column(name="author")
    private String author;

    public Course(long id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }

    public Course() {
    }
}
