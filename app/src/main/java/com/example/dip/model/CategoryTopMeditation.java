package com.example.dip.model;

public class CategoryTopMeditation {
    private int id;
    private String img, Name, Time, Category, Color;

    public CategoryTopMeditation(int id, String img, String Name, String Time, String Category, String Color) {
        this.Color = Color;
        this.id = id;
        this.img = img;
        this.Name = Name;
        this.Time = Time;
        this.Category = Category;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }
    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getTime() {
        return Time;
    }
    public void setTime(String time) {
        Time = time;
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

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

}
