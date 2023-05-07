package com.example.achiveserver.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "achiv", schema = "achiv")
public class Achiv {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "class", length = 100)
    private String classField;

    @Column(name = "description", nullable = false, length = 200)
    private String description;

    public Achiv(Integer id, String name, String classField, String description) {
        this.id = id;
        this.name = name;
        this.classField = classField;
        this.description = description;
    }

    public Achiv() {
    }

    public Achiv(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassField() {
        return classField;
    }

    public void setClassField(String classField) {
        this.classField = classField;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}