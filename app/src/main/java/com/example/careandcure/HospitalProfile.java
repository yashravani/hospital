package com.example.careandcure;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class HospitalProfile extends AppCompatActivity {

    ImageView arrowback;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hospital_profile);

        arrowback = findViewById(R.id.arrowback);
        arrowback.setOnClickListener(view -> {
            Intent intent1 = new Intent(HospitalProfile.this, HospitalHome.class);
            intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent1);
            finish();
        });


    }
}