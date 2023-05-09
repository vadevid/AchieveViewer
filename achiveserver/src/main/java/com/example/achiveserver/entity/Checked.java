package com.example.achiveserver.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "checked", schema = "achiv")
public class Checked {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "achiv_id", nullable = false)
    private Achiv achiv;

    public Checked(Integer id, User user, Achiv achiv) {
        this.id = id;
        this.user = user;
        this.achiv = achiv;
    }

    public Checked(User user, Achiv achiv) {
        this.user = user;
        this.achiv = achiv;
    }

    public Checked() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Achiv getAchiv() {
        return achiv;
    }

    public void setAchiv(Achiv achiv) {
        this.achiv = achiv;
    }
}