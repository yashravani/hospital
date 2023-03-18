package com.example.careandcure.otp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.careandcure.HospitalHome;
import com.example.careandcure.LoginAndRegister.HospitalLogin;
import com.example.careandcure.R;

public class HospitalOtp extends AppCompatActivity {

    ImageView arrowback;
    AppCompatButton verifybutton;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_otp);

        arrowback = findViewById(R.id.arrowback);
        arrowback.setOnClickListener(view -> {
            Intent intent = new Intent(HospitalOtp.this, HospitalLogin.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
            finish();
        });

        verifybutton = findViewById(R.id.verifybutton);
        verifybutton.setOnClickListener(view -> {
            Intent intent = new Intent(HospitalOtp.this, HospitalHome.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
        });

    }
}