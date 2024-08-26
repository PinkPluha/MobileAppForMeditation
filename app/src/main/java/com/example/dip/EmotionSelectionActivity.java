package com.example.dip;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class EmotionSelectionActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;
    private ImageView selectedMoodImageView;
    private ImageButton saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emotion_selection);

        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReferenceFromUrl("https://pink-cloud-cd144-default-rtdb.firebaseio.com/");

        ImageView superHappyImage = findViewById(R.id.superHappyImage);
        ImageView happyImage = findViewById(R.id.happyImage);
        ImageView normalImage = findViewById(R.id.normalImage);
        ImageView sadImage = findViewById(R.id.sadImage);
        ImageView superSadImage = findViewById(R.id.superSadImage);

        TextView currentDateTextView = findViewById(R.id.currentDateTextView);
        currentDateTextView.setText(getCurrentDate());

        superHappyImage.setOnClickListener(v -> selectMood(superHappyImage, "Отлично"));
        happyImage.setOnClickListener(v -> selectMood(happyImage, "Хорошо"));
        normalImage.setOnClickListener(v -> selectMood(normalImage, "Нормально"));
        sadImage.setOnClickListener(v -> selectMood(sadImage, "Плохо"));
        superSadImage.setOnClickListener(v -> selectMood(superSadImage, "Ужасно"));

        saveButton = findViewById(R.id.next);
        saveButton.setOnClickListener(v -> {
            saveMood();
            navigateToNextActivity();
        });
    }


    private void selectMood(ImageView imageView, String mood) {
        clearSelectedMood();
        selectedMoodImageView = imageView;
        selectedMoodImageView.setSelected(true);
        selectedMoodImageView.setBackgroundColor(Color.parseColor("#9477BC"));
    }

    private String getCurrentDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
        return dateFormat.format(new Date());
    }

    private void clearSelectedMood() {
        if (selectedMoodImageView != null) {
            selectedMoodImageView.setSelected(false);
            selectedMoodImageView.setBackgroundColor(Color.TRANSPARENT);
        }
    }

    private void saveMood() {
        if (selectedMoodImageView != null) {
            String mood = getMoodFromSelectedImageView(selectedMoodImageView);
            if (mood != null) {
                saveSelectedMoodToFirebase(mood);
            }
        }
    }

    private String getMoodFromSelectedImageView(ImageView imageView) {
        if (imageView == findViewById(R.id.superHappyImage)) {
            return "superHappy";
        } else if (imageView == findViewById(R.id.happyImage)) {
            return "happy";
        } else if (imageView == findViewById(R.id.normalImage)) {
            return "normal";
        } else if (imageView == findViewById(R.id.sadImage)) {
            return "sad";
        } else if (imageView == findViewById(R.id.superSadImage)) {
            return "superSad";
        }
        return null;
    }

    private void saveSelectedMoodToFirebase(String mood) {
        FirebaseUser user = mAuth.getCurrentUser();
        if (user != null) {
            DatabaseReference moodRef = mDatabase.child("Настроения").child(user.getUid());
            moodRef.setValue(mood)
                    .addOnSuccessListener(aVoid -> {
                        Toast.makeText(EmotionSelectionActivity.this, "Настроение сохранено", Toast.LENGTH_SHORT).show();
                    })
                    .addOnFailureListener(e -> {
                        Toast.makeText(EmotionSelectionActivity.this, "Ошибка при сохранении настроения", Toast.LENGTH_SHORT).show();
                    });
        }
    }

    private void navigateToNextActivity() {
        Intent intent = new Intent(EmotionSelectionActivity.this, ActivityWithQuestionAndOptions.class);
        startActivity(intent);
    }
}

