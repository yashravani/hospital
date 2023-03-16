package com.example.careandcure;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    TextView textregister,textregister1;
    ImageView arrowback;
    AppCompatButton loginbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textregister = findViewById(R.id.textregister);
        textregister1 = findViewById(R.id.textregister1);
        loginbutton = findViewById(R.id.loginbutton);
        arrowback = findViewById(R.id.arrowback);

        arrowback.setOnClickListener(view -> {
            Intent intent = new Intent(LoginActivity.this,Splash1.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
        });

        loginbutton.setOnClickListener(view -> {
            Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
            startActivity(intent);
        });

        textregister.setOnClickListener(view -> {
            Intent intent = new Intent(LoginActivity.this, PatientHospitalDoctor.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
        });

        textregister1.setOnClickListener(view -> {
            Intent intent = new Intent(LoginActivity.this, PatientHospitalDoctor.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
        });

    }
}