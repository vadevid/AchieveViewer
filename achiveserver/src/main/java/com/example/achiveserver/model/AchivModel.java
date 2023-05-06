package com.example.achiveserver.model;

public class AchivModel {
    private Integer id;
    private String name;
    private String classField;
    private String description;
    private boolean checked;

    public AchivModel(Integer id, String name, String classField, String description, boolean checked) {
        this.id = id;
        this.name = name;
        this.classField = classField;
        this.description = description;
        this.checked = checked;
    }

    public AchivModel() {
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

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
