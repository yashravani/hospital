package com.example.careandcure.LoginAndRegister;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.careandcure.PatientHospitalDoctor;
import com.example.careandcure.R;
import com.example.careandcure.otp.DoctorOtp;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class DoctorLogin extends AppCompatActivity {

    ImageView arrowback;
    AppCompatButton loginbutton;
    TextInputEditText textphonedoctor;


    @SuppressLint({"MissingInflatedId", "CutPasteId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doctor_login);

        arrowback = findViewById(R.id.arrowback);
        loginbutton = findViewById(R.id.loginbutton);

        textphonedoctor = findViewById(R.id.textphonedoctor);
        TextInputLayout phoneInputLayout = findViewById(R.id.textinputdoctor);
        phoneInputLayout.setPrefixText("+91 ");
        loginbutton.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), DoctorOtp.class);
            intent.putExtra("textphonedoctor", Objects.requireNonNull(textphonedoctor.getText()).toString());
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
        });

        arrowback.setOnClickListener(view -> {
            Intent intent = new Intent(DoctorLogin.this, PatientHospitalDoctor.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
        });

    }
}