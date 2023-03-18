package com.example.careandcure.otp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.careandcure.DoctorHome;
import com.example.careandcure.LoginAndRegister.DoctorLogin;
import com.example.careandcure.R;

public class DoctorOtp extends AppCompatActivity {

    ImageView arrowback;
    AppCompatButton verifybutton;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_otp);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        TextView textView = findViewById(R.id.textmobiledoctor);
        textView.setText(String.format("+91-%s",getIntent().getStringExtra("textphonedoctor")));


        arrowback = findViewById(R.id.arrowback);
        arrowback.setOnClickListener(view -> {
            Intent intent = new Intent(DoctorOtp.this, DoctorLogin.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
            finish();
        });

        verifybutton = findViewById(R.id.verifybutton);
        verifybutton.setOnClickListener(view -> {
            Intent intent = new Intent(DoctorOtp.this, DoctorHome.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
        });

    }
}