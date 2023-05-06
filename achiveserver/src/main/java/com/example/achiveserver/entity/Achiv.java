package com.example.achiveserver.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
}