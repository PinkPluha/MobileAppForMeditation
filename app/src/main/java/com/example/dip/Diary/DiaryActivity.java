package com.example.dip.Diary;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.dip.MainActivity;
import com.example.dip.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class DiaryActivity extends AppCompatActivity {

    private EditText titleEditText;
    private EditText contentEditText;
    private Button saveButton;
    private Button backButton;
    private ListView diaryListView;
    private List<DiaryEntry> diaryEntries;
    private DiaryEntryAdapter diaryEntryAdapter;
    private int sequenceNumber = 1;

    private Button editButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);

        titleEditText = findViewById(R.id.titleEditText);
        contentEditText = findViewById(R.id.contentEditText);
        saveButton = findViewById(R.id.saveButton);
        backButton = findViewById(R.id.backButton);
        diaryListView = findViewById(R.id.diaryListView);

        diaryEntries = new ArrayList<>();
        diaryEntryAdapter = new DiaryEntryAdapter(this, diaryEntries);
        diaryListView.setAdapter(diaryEntryAdapter);

        diaryListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DiaryEntry selectedEntry = diaryEntries.get(position);
                Intent intent = new Intent(DiaryActivity.this, DiaryEntryActivity.class);
                intent.putExtra("title", selectedEntry.getTitle());
                intent.putExtra("content", selectedEntry.getContent());
                intent.putExtra("date", selectedEntry.getDate());
                startActivity(intent);
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = titleEditText.getText().toString();
                String content = contentEditText.getText().toString();
                String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());

                DiaryEntry newEntry = new DiaryEntry(title, content, date, sequenceNumber);
                diaryEntries.add(newEntry);
                diaryEntryAdapter.notifyDataSetChanged();
                sequenceNumber++;
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DiaryActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        editButton = findViewById(R.id.editButton);
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedPosition = diaryListView.getCheckedItemPosition();
                if (selectedPosition != ListView.INVALID_POSITION) {
                    DiaryEntry selectedEntry = diaryEntries.get(selectedPosition);
                    titleEditText.setText(selectedEntry.getTitle());
                    contentEditText.setText(selectedEntry.getContent());
                    saveButton.setVisibility(View.GONE);
                    editButton.setVisibility(View.GONE);
                    titleEditText.requestFocus();
                }
            }
        });
    }
}
