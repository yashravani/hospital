package com.example.careandcure;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Spinner;

public class PatientRegister extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_register);

        Spinner genderSpinner = findViewById(R.id.gender_spinner);
        String selectedGender = genderSpinner.getSelectedItem().toString();

    }
}