package com.example.careandcure.otp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.careandcure.LoginAndRegister.PatientLogin;
import com.example.careandcure.PatientHome;
import com.example.careandcure.R;

public class PatientOtp extends AppCompatActivity {

    ImageView arrowback;
    AppCompatButton verifybutton;
    @SuppressLint({"MissingInflatedId", "LocalSuppress"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_otp);

        TextView textView = findViewById(R.id.textmobilepatient);
        textView.setText(String.format("+91-%s",getIntent().getStringExtra("textphonepatient")));
        arrowback = findViewById(R.id.arrowback);
        arrowback.setOnClickListener(view -> {
            Intent intent = new Intent(PatientOtp.this, PatientLogin.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
            finish();
        });

        verifybutton = findViewById(R.id.verifybutton);
        verifybutton.setOnClickListener(view -> {
            Intent intent = new Intent(PatientOtp.this, PatientHome.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
        });



    }
}