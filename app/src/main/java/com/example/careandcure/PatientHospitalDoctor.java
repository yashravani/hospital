package com.example.careandcure;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class PatientHospitalDoctor extends AppCompatActivity {

    ImageView messege,arrowback;
    BottomSheetDialog dialog;
    TextView patient,hospital;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_hospital_doctor_login);

        messege = findViewById(R.id.messege);
        arrowback = findViewById(R.id.arrowback);
        patient = findViewById(R.id.patient);
        hospital = findViewById(R.id.hospital);

        patient.setOnClickListener(view -> {
            Intent intent = new Intent(PatientHospitalDoctor.this,PatientRegister.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
        });

        hospital.setOnClickListener(view -> {
            Intent intent = new Intent(PatientHospitalDoctor.this,HospitalRegister.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
        });

        dialog = new BottomSheetDialog(this);
        createDialog();
        messege.setOnClickListener(view -> dialog.show());
        dialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);

        arrowback.setOnClickListener(view -> {
            Intent intent = new Intent(PatientHospitalDoctor.this,Splash1.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);

        });

    }

    private void createDialog() {

        @SuppressLint("InflateParams") View view = getLayoutInflater().inflate(R.layout.bottom_dialog, null, false);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageView arrowback = view.findViewById(R.id.arrowback);

        arrowback.setOnClickListener(view1 -> dialog.dismiss());
        dialog.setContentView(view);


    }
}