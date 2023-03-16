package com.example.careandcure.LoginAndRegister;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.careandcure.HomeActivity;
import com.example.careandcure.PatientHospitalDoctor;
import com.example.careandcure.R;
import com.example.careandcure.Splash1;
import com.example.careandcure.otp.HospitalOtp;

public class HospitalLogin extends AppCompatActivity {

    TextView textregister,textregister1;
    ImageView arrowback;
    AppCompatButton loginbutton;

    @SuppressLint({"ResourceAsColor", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_login);

        textregister = findViewById(R.id.textregister);
        textregister1 = findViewById(R.id.textregister1);
        loginbutton = findViewById(R.id.loginbutton);
        arrowback = findViewById(R.id.arrowback);

        arrowback.setOnClickListener(view -> {
            Intent intent = new Intent(HospitalLogin.this, PatientHospitalDoctor.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
        });

        loginbutton.setOnClickListener(view -> {
            Intent intent = new Intent(HospitalLogin.this, HospitalOtp.class);
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