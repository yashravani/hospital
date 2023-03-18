package com.example.careandcure.LoginAndRegister;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.careandcure.PatientHospitalDoctor;
import com.example.careandcure.R;
import com.example.careandcure.otp.PatientOtp;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class PatientLogin extends AppCompatActivity {

    ImageView arrowback;
    AppCompatButton loginbutton;

    TextInputEditText textphonepatient;


    @SuppressLint({"MissingInflatedId", "LocalSuppress"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_login);

        TextInputLayout phoneInputLayout = findViewById(R.id.textinputpatient);
        phoneInputLayout.setPrefixText("+91 ");

        textphonepatient = findViewById(R.id.textphonepatient);

        arrowback = findViewById(R.id.arrowback);
        loginbutton = findViewById(R.id.loginbutton);

        loginbutton.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(),PatientOtp.class);
            intent.putExtra("textphonepatient", Objects.requireNonNull(textphonepatient.getText()).toString());
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