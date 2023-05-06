package com.example.achiveserver.model;

import lombok.Data;

public class UserModel {
    private Integer id;
    private String login;
    private String password;

    public UserModel(Integer id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public UserModel() {
    }

    public UserModel(Integer id) {
        this.id = id;
    }

    public UserModel(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
