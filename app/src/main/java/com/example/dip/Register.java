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

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://pink-cloud-cd144-default-rtdb.firebaseio.com/");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        String uid = currentUser != null ? currentUser.getUid() : null;

        final EditText register_phone = findViewById(R.id.register_phone);
        final EditText register_email = findViewById(R.id.register_email);
        final EditText register_password = findViewById(R.id.register_password);
        final EditText register_name = findViewById(R.id.register_name);
        final EditText con_password = findViewById(R.id.con_password);
        final Button register_btn = findViewById(R.id.register_btn);
        final TextView go_to_login = findViewById(R.id.go_to_login);

        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String register_phoneTxt = register_phone.getText().toString();
                final String register_emailTxt = register_email.getText().toString();
                final String register_passwordTxt = register_password.getText().toString();
                final String register_nameTxt = register_name.getText().toString();
                final String con_passwordTxt = con_password.getText().toString();

                if(register_emailTxt.isEmpty() || register_passwordTxt.isEmpty() || register_nameTxt.isEmpty() || register_phoneTxt.isEmpty()){
                    Toast.makeText(Register.this, "Пожалуйста, заполните все поля", Toast.LENGTH_SHORT).show();
                }

                else if(!register_passwordTxt.equals(con_passwordTxt)){
                    Toast.makeText(Register.this, "Пароли не совпадают", Toast.LENGTH_SHORT).show();
                }
                else {

                    databaseReference.child("Пользователи").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(snapshot.hasChild(register_phoneTxt)){
                                Toast.makeText(Register.this, "Номер телефона уже зарегистрирован", Toast.LENGTH_SHORT).show();
                            }
                            else {

                                Map<String, Object> user = new HashMap<>();
                                user.put("Имя пользователя", register_nameTxt);
                                user.put("Пароль", register_passwordTxt);
                                user.put("Электронная почта", register_emailTxt);

                                databaseReference.child("Пользователи").child(register_phoneTxt).setValue(user);
                                Toast.makeText(Register.this, "Регистрация прошла успешно!", Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            Toast.makeText(Register.this, "Ошибка регистрации", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });

        go_to_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}