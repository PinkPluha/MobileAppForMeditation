package com.example.dip;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dip.adapter.BestMeditationAdapter;
import com.example.dip.adapter.CategoryAdapter;
import com.example.dip.model.CategoryTopMeditation;
import com.example.dip.model.Category;
import com.example.dip.model.Meditation;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    RecyclerView categoryRecycler;
    RecyclerView bestMeditationRecycler;
    CategoryAdapter categoryAdapter;
    BestMeditationAdapter bestMeditationAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

            final ImageView diary = findViewById(R.id.deary);
            diary.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(MainActivity.this, EmotionSelectionActivity.class));
                }
            });


        final ImageView stress = findViewById(R.id.stress);
        stress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, FirstPage.class));
            }
        });


        final ImageView test = findViewById(R.id.test);
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Tests.class));
            }
        });

        final ImageView help = findViewById(R.id.help);
                help.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(MainActivity.this, Articles.class));
                    }
                });

        /*final TextView chat = findViewById(R.id.chat);
        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Chat.class));
            }
        });*/


        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category(1, "Практики"));
        categoryList.add(new Category(2, "Тесты"));
        categoryList.add(new Category(3, "Статьи"));
        categoryList.add(new Category(4, "Советы"));
        categoryList.add(new Category(5, "Шкалы"));

        setCategoryRecycler(categoryList);


        List<CategoryTopMeditation> bestMeditationList = new ArrayList<>();
        bestMeditationList.add(new CategoryTopMeditation(1, "soul", "Сканирование тела", "15-20", "Медитация", "#FF9276BA"));
        bestMeditationList.add(new CategoryTopMeditation(2, "kandinsky_download_1715028462177", "Звуки светлячков", "10", "Аудио медитации", "#FF9276BA"));
        bestMeditationList.add(new CategoryTopMeditation(3, "ega", "Йога для начинающих", "40", "Йога", "#FF9276BA"));
        bestMeditationList.add(new CategoryTopMeditation(4, "kandinsky_download_1715030088952", "Позитивные фразы", "5", "Аффирмации", "#FF9276BA"));

        setBestMeditationRecycler(bestMeditationList);


    }

    private void setMeditationRecycler(List<Meditation> meditationList) {

    }

    private void setCategoryRecycler(List<Category> categoryList) {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        categoryRecycler = findViewById(R.id.categoryRecycler);
        categoryRecycler.setLayoutManager(layoutManager);

        categoryAdapter = new CategoryAdapter(this, categoryList);
        categoryRecycler.setAdapter(categoryAdapter);

    }

    private void setBestMeditationRecycler(List<CategoryTopMeditation> bestMeditationList) {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        bestMeditationRecycler = findViewById(R.id.BestMeditationRecycler);
        bestMeditationRecycler.setLayoutManager(layoutManager);

        bestMeditationAdapter = new BestMeditationAdapter(this, bestMeditationList);
        bestMeditationRecycler.setAdapter(bestMeditationAdapter);
    }

}