package com.example.dip.Diary;

import java.io.Serializable;

public class DiaryEntry implements Serializable {
    private String title;
    private String content;
    private String date;
    private int sequenceNumber;

    public DiaryEntry() {
        // Конструктор по умолчанию для сериализации
    }

    public DiaryEntry(String title, String content, String date, int sequenceNumber) {
        this.title = title;
        this.content = content;
        this.date = date;
        this.sequenceNumber = sequenceNumber;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getDate() {
        return date;
    }

    public int getSequenceNumber() {
        return sequenceNumber;
    }
}
