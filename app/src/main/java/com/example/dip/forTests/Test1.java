package com.example.dip.forTests;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.dip.R;

public class Test1 extends AppCompatActivity {

    private TextView questionTextView, about;
    private RadioGroup radioGroup;
    private RadioButton answer1, answer2, answer3, answer4;
    private Button nextButton;

    private int currentQuestion = 0;
    private int[] selectedAnswers = new int[44];
    private int totalScore = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_test1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        questionTextView = findViewById(R.id.questionTextView);
        radioGroup = findViewById(R.id.radioGroup);
        answer1 = findViewById(R.id.answer1);
        answer2 = findViewById(R.id.answer2);
        answer3 = findViewById(R.id.answer3);
        answer4 = findViewById(R.id.answer4);
        nextButton = findViewById(R.id.nextButton);
        about = findViewById(R.id.about);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveAnswer();
                nextQuestion();
            }
        });

        showQuestion();
    }

    private void showQuestion() {
        String[] questions = getResources().getStringArray(R.array.questions);
        String[] answers = getResources().getStringArray(R.array.answers);

        questionTextView.setText(questions[currentQuestion]);
        answer1.setText(answers[currentQuestion * 4]);
        answer2.setText(answers[currentQuestion * 4 + 1]);
        answer3.setText(answers[currentQuestion * 4 + 2]);
        answer4.setText(answers[currentQuestion * 4 + 3]);

        radioGroup.clearCheck();
    }

    private void saveAnswer() {
        int selectedAnswer = radioGroup.getCheckedRadioButtonId();
        selectedAnswers[currentQuestion] = selectedAnswer;
    }

    private void nextQuestion() {
        currentQuestion++;

        if (currentQuestion < 44) {
            showQuestion();
        } else {
            calculateScore();
            displayResult();
        }
    }

    private void calculateScore() {
        int[] answerIds = {R.id.answer1, R.id.answer2, R.id.answer3, R.id.answer4};
        int[] answerScores = {0, 1, 2, 3};
        for (int i = 0; i < selectedAnswers.length; i++) {
            int selectedAnswer = selectedAnswers[i];
            for (int j = 0; j < answerIds.length; j++) {
                if (selectedAnswer == answerIds[j]) {
                    totalScore += answerScores[j];
                    break;
                }
            }
        }
    }
    private void displayResult() {
        String result = "Ваш результат: " + totalScore;
        questionTextView.setText(result);
        nextButton.setVisibility(View.GONE);
        radioGroup.setVisibility(View.GONE);
        about.setVisibility(View.GONE);

        TextView about2 = findViewById(R.id.about2);
        about2.setVisibility(View.VISIBLE);
        about2.setText("1—9 — депрессия отсутствует либо незначительна \n\n10—24 — депрессия минимальна \n\n25—44 — легкая депрессия \n\n45—67 — умеренная депрессия \n\n68—87 — выраженная депрессия \n\n88 и более — глубокая депрессия");
    }
}