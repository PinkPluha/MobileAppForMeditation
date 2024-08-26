package com.example.dip.Diary;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.dip.R;

public class DiaryEntryActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary_entry);

        String title = getIntent().getStringExtra("title");
        String content = getIntent().getStringExtra("content");
        String date = getIntent().getStringExtra("date");

        TextView titleTextView = findViewById(R.id.titleTextView);
        TextView contentTextView = findViewById(R.id.contentTextView);
        TextView dateTextView = findViewById(R.id.dateTextView);

        titleTextView.setText(title);
        contentTextView.setText(content);
        dateTextView.setText(date);
    }
}