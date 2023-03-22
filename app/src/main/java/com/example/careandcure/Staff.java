package com.example.careandcure;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class Staff extends AppCompatActivity {

    ImageView arrowback;
    RelativeLayout nurse, wardboy, reception, cleaning, medical, lab, rmo, otstaff;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff);

        arrowback = findViewById(R.id.arrowback);
        arrowback.setOnClickListener(view -> {
            Intent intent1 = new Intent(Staff.this, HospitalHome.class);
            intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent1);
            finish();
        });

        nurse = findViewById(R.id.nurse);
        nurse.setOnClickListener(view -> {
            Intent intent1 = new Intent(Staff.this, NurseHome.class);
            intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent1);
        });

        wardboy = findViewById(R.id.wardboy);
        wardboy.setOnClickListener(view -> {
            Intent intent1 = new Intent(Staff.this, WardboyHome.class);
            intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent1);
        });

        reception = findViewById(R.id.reception);
        reception.setOnClickListener(view -> {
            Intent intent1 = new Intent(Staff.this, ReceptionHome.class);
            intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent1);
        });

        cleaning = findViewById(R.id.cleaning);
        cleaning.setOnClickListener(view -> {
            Intent intent1 = new Intent(Staff.this, CleaningHome.class);
            intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent1);
        });

        medical = findViewById(R.id.medical);
        medical.setOnClickListener(view -> {
            Intent intent1 = new Intent(Staff.this, MedicalHome.class);
            intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent1);
        });

        lab = findViewById(R.id.lab);
        lab.setOnClickListener(view -> {
            Intent intent1 = new Intent(Staff.this, LabHome.class);
            intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent1);
        });

        rmo = findViewById(R.id.rmo);
        rmo.setOnClickListener(view -> {
            Intent intent1 = new Intent(Staff.this, RmoHome.class);
            intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent1);
        });

        otstaff = findViewById(R.id.otstaff);
        otstaff.setOnClickListener(view -> {
            Intent intent1 = new Intent(Staff.this, OTstaffHome.class);
            intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent1);
        });

    }
}