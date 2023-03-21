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

    AppCompatButton button;
    ImageView imageinfo;
    TextInputEditText MobileNo;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_register);

        MobileNo = findViewById(R.id.MobileNo);

        button = findViewById(R.id.button);
        button.setOnClickListener(v -> button.setBackgroundColor(Color.GREEN));

        button.setOnClickListener(view -> {
            button.setBackgroundColor(Color.GREEN);
            Intent intent = new Intent(HospitalRegister.this, HospitalOtp.class);
            intent.putExtra("MobileNo", Objects.requireNonNull(MobileNo.getText()).toString());
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
        });


        TextInputLayout phoneInputLayout = findViewById(R.id.inputtext);
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