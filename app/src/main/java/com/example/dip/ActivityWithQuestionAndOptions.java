package com.example.dip;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.utils.widget.ImageFilterView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.dip.Diary.Diary;
import com.example.dip.Diary.DiaryActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class ActivityWithQuestionAndOptions extends AppCompatActivity {

    private DatabaseReference databaseReference;
    private String currentDate;
    private List<String> selectedActivities = new ArrayList<>();
    private Map<String, ImageView> activityImageViews = new HashMap<>();
    public static String uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_with_question_and_options);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ImageButton saveButton = findViewById(R.id.next);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveActivities();
                openNextActivity();
            }
        });

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("Сегодняшние занятия");

        currentDate = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());


        ImageView familyImage = findViewById(R.id.family);
        familyImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleActivitySelection("Семья", familyImage);
            }
        });

        ImageView friendsImage = findViewById(R.id.friends);
        friendsImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleActivitySelection("Друзья", friendsImage);
            }
        });

        ImageView glassImage = findViewById(R.id.glass);
        glassImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleActivitySelection("Свидание", glassImage);
            }
        });

        ImageView sportImage = findViewById(R.id.sport);
        sportImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleActivitySelection("Спорт", sportImage);
            }
        });

        ImageView yogaImage = findViewById(R.id.yoga);
        yogaImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleActivitySelection("Йога", yogaImage);
            }
        });

        ImageView relaxImage = findViewById(R.id.relax);
        relaxImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleActivitySelection("Отдых", relaxImage);
            }
        });

        ImageView cinemaImage = findViewById(R.id.cinema);
        cinemaImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleActivitySelection("Кино", cinemaImage);
            }
        });

        ImageView gamesImage = findViewById(R.id.games);
        gamesImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleActivitySelection("Игры", gamesImage);
            }
        });

        ImageView booksImage = findViewById(R.id.books);
        booksImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleActivitySelection("Книги", booksImage);
            }
        });

        ImageView cleanImage = findViewById(R.id.clean);
        cleanImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleActivitySelection("Уборка", cleanImage);
            }
        });

        ImageView foodImage = findViewById(R.id.food);
        foodImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleActivitySelection("Кушать", foodImage);
            }
        });

        ImageView buyImage = findViewById(R.id.buy);
        buyImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleActivitySelection("Покупки", buyImage);
            }
        });
    }
    private void toggleActivitySelection(String activity, ImageView imageView) {
        if (selectedActivities.contains(activity)) {
            selectedActivities.remove(activity);
            imageView.setBackgroundColor(Color.TRANSPARENT); // Снятие выделения
        } else {
            selectedActivities.add(activity);
            imageView.setBackgroundColor(Color.parseColor("#9477BC")); // Выделение
        }
    }

    private void saveActivities() {
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if (currentUser != null) {
            uid = currentUser.getUid();
            DatabaseReference userActivitiesRef = databaseReference.child("users").child(uid).child("activities").child(currentDate);
            for (String activity : selectedActivities) {
                userActivitiesRef.child(activity).setValue(true);
            }
        }
    }
        private void openNextActivity() {
        Intent intent = new Intent(ActivityWithQuestionAndOptions.this, DiaryActivity.class);
        startActivity(intent);
    }
}