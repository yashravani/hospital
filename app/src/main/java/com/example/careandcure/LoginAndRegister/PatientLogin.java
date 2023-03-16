package com.example.careandcure.LoginAndRegister;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.careandcure.PatientHospitalDoctor;
import com.example.careandcure.R;
import com.example.careandcure.otp.PatientOtp;

public class PatientLogin extends AppCompatActivity {

    ImageView arrowback;
    AppCompatButton loginbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_login);

        arrowback = findViewById(R.id.arrowback);
        loginbutton = findViewById(R.id.loginbutton);
        loginbutton.setOnClickListener(view -> {
            Intent intent = new Intent(PatientLogin.this, PatientOtp.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
        });

        arrowback.setOnClickListener(view -> {
            Intent intent = new Intent(PatientLogin.this, PatientHospitalDoctor.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
        });

    }
}