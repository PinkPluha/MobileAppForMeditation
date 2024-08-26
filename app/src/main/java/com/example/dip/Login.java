package com.example.dip;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {

    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://pink-cloud-cd144-default-rtdb.firebaseio.com/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        final EditText login_phone = findViewById(R.id.login_phone);
        final EditText login_password = findViewById(R.id.login_password);
        final Button login_btn = findViewById(R.id.login_btn);
        final TextView go_to_register = findViewById(R.id.go_to_register);

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String phoneText = login_phone.getText().toString();
                final String passwordText = login_password.getText().toString();

                if (phoneText.isEmpty() || passwordText.isEmpty()) {
                    Toast.makeText(Login.this, "Пожалуйста введите ваш номер телефона", Toast.LENGTH_SHORT).show();
                } else {

                    databaseReference.child("Пользователи").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(snapshot.hasChild(phoneText)){
                                String getPassword = snapshot.child(phoneText).child("Пароль").getValue(String.class);
                                if(getPassword.equals(passwordText)){
                                    Toast.makeText(Login.this, "Вы успешно зашли в систему", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(Login.this, MainActivity.class));
                                    finish();
                                }
                                else{
                                    Toast.makeText(Login.this, "Неверный пароль", Toast.LENGTH_SHORT).show();
                                }
                            }
                            else{
                                Toast.makeText(Login.this, "Неверный номер телефона", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            // Обработка ошибки
                        }
                    });
                }
            }
        });

        go_to_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, Register.class));
            }
        });
    }
}