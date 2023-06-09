package com.example.careandcure.LoginAndRegister;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.careandcure.R;
import com.example.careandcure.otp.HospitalOtp;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class HospitalRegister extends AppCompatActivity {

    AppCompatButton registration;
    ImageView imageinfo, arrowback;
    TextInputEditText MobileNo;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hospital_register);

        MobileNo = findViewById(R.id.Mobile_No);

        registration = findViewById(R.id.registration);
        registration.setOnClickListener(v -> registration.setBackgroundColor(Color.GREEN));

        registration.setOnClickListener(view -> {
            registration.setBackgroundColor(Color.GREEN);
            Intent intent = new Intent(HospitalRegister.this, HospitalOtp.class);
            intent.putExtra("MobileNo", Objects.requireNonNull(MobileNo.getText()).toString());
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
        });

        arrowback = findViewById(R.id.arrowback);
        arrowback.setOnClickListener(view -> {
            Intent intent = new Intent(HospitalRegister.this, HospitalLogin.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
            finish();
        });


        TextInputLayout phoneInputLayout = findViewById(R.id.input_text);
        phoneInputLayout.setPrefixText("+91 ");

        imageinfo = findViewById(R.id.imageinfo);
        imageinfo.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(view.findViewById(R.id.imageinfo).getContext());
            builder.setTitle("Add Image");
            builder.setMessage("Hospital :- Add your hospital image \nCertificate :- Add your hospital certificate image for security purpose");
            builder.setPositiveButton("Ok", (dialogInterface, i) -> {
            });
            builder.show();
        });

    }
}