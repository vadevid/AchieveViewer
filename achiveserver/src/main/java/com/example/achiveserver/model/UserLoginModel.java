package com.example.achiveserver.model;

public class UserLoginModel {
    private String login;
    private String password;

    public UserLoginModel(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public UserLoginModel() {
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
