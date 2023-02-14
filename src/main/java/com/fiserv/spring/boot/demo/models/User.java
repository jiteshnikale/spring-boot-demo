package com.fiserv.spring.boot.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity(name = "User_Details")
public class User {

    protected User() { }
    public User(long id, String name, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }
    @Id
    @GeneratedValue
    private long id;

    @Size(min = 2, message = "Name should have at least 2 characters")
    @Column(name="name")
    private String name;

    @Past(message = "Birth Date should be in the past")
    @Column(name="BIRTH_DATE")
    private LocalDate birthDate;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Post> posts;
}
