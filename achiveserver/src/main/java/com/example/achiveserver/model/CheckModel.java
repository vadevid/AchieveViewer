package com.example.achiveserver.model;

public class CheckModel {

    private Integer userId;
    private Integer achivId;

    public CheckModel(Integer userId, Integer achivId) {
        this.userId = userId;
        this.achivId = achivId;
    }

    public CheckModel() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAchivId() {
        return achivId;
    }

    public void setAchivId(Integer achivId) {
        this.achivId = achivId;
    }
}
