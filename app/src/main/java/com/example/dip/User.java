package com.example.dip;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class User {
    private String uid;
    private String phoneNumber;
    private String email;
    private String password;
    private String name;
    private int emotionLevel;
    private Map<String, Integer> emotionHistory;

    public User() {
        // Пустой конструктор
    }

    public User(String uid, String phoneNumber, String email, String password, String name) {
        this.uid = uid;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEmotionLevel() {
        return emotionLevel;
    }

    public void setEmotionLevel(int emotionLevel) {
        this.emotionLevel = emotionLevel;
    }

    public Map<String, Integer> getEmotionHistory() {
        return emotionHistory;
    }

    public void setEmotionHistory(Map<String, Integer> emotionHistory) {
        this.emotionHistory = emotionHistory;
    }


}

