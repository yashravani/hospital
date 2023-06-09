package com.example.careandcure.LoginAndRegister;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.careandcure.HospitalHome;
import com.example.careandcure.Login;
import com.example.careandcure.R;

public class HospitalLogin extends AppCompatActivity {

    TextView textregister,textregister1;
    ImageView arrowback;
    AppCompatButton loginbutton;

    @SuppressLint({"ResourceAsColor", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hospital_login);

        textregister = findViewById(R.id.textregister);
        textregister1 = findViewById(R.id.textregister1);
        loginbutton = findViewById(R.id.loginbutton);
        arrowback = findViewById(R.id.arrowback);

        arrowback.setOnClickListener(view -> {
            Intent intent = new Intent(HospitalLogin.this, Login.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
        });

        loginbutton.setOnClickListener(view -> {
            Intent intent = new Intent(HospitalLogin.this, HospitalHome.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
        });

        textregister.setOnClickListener(view -> {
            Intent intent = new Intent(HospitalLogin.this, HospitalRegister.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
        });

        textregister1.setOnClickListener(view -> {
            Intent intent = new Intent(HospitalLogin.this, HospitalRegister.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
        });


    }
}