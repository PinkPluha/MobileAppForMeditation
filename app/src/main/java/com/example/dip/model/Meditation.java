package com.example.dip.model;

public class Meditation {
    int id;
    String img, title, about, color;

    public Meditation(int id, String img, String title, String about, String color) {
        this.id = id;
        this.img = img;
        this.title = title;
        this.about = about;
        this.color = color;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
