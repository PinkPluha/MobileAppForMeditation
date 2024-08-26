package com.example.dip.best_meditation;

public class Category {
    private int Id;
    private String Value;

    public Category() {

    }
    @Override
    public String toString() {
        return Value;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }
}
