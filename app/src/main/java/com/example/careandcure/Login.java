package com.example.careandcure;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.careandcure.LoginAndRegister.DoctorLogin;
import com.example.careandcure.LoginAndRegister.HospitalLogin;
import com.example.careandcure.LoginAndRegister.PatientLogin;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class Login extends AppCompatActivity {

    ImageView messege, arrowback;
    BottomSheetDialog bottomSheetDialog;
    TextView patient, doctor, hospital;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        messege = findViewById(R.id.messege);
        messege.setOnClickListener(view -> {
            bottomSheetDialog = new BottomSheetDialog(Login.this, R.style.BottomSheetTheme);
            @SuppressLint("InflateParams") View sheetview = LayoutInflater.from(getApplicationContext()).inflate(R.layout.bottom_dialog, null);
            sheetview.findViewById(R.id.arrowback).setOnClickListener(view12 -> bottomSheetDialog.dismiss());
            bottomSheetDialog.setContentView(sheetview);
            bottomSheetDialog.show();
        });

        arrowback = findViewById(R.id.arrowback);
        arrowback.setOnClickListener(view -> {
            Intent intent = new Intent(Login.this, Splash1.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
        });

        patient = findViewById(R.id.patient);
        patient.setOnClickListener(view -> {
            Intent intent = new Intent(Login.this, PatientLogin.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
        });

        hospital = findViewById(R.id.hospital);
        hospital.setOnClickListener(view -> {
            Intent intent = new Intent(Login.this, HospitalLogin.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
        });

        doctor = findViewById(R.id.doctor);
        doctor.setOnClickListener(view -> {
            Intent intent = new Intent(Login.this, DoctorLogin.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
        });


    }
}