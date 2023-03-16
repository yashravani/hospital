package com.example.careandcure.LoginAndRegister;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.careandcure.R;

public class HospitalRegister extends AppCompatActivity {

    AppCompatButton button;
    ImageView imageinfo;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_register);

//        button = findViewById(R.id.button);
//        button.setOnClickListener(v -> button.setBackgroundColor(Color.GREEN));
//
//        imageinfo = findViewById(R.id.imageinfo);
//        imageinfo.setOnClickListener(view -> {
//            AlertDialog.Builder builder = new AlertDialog.Builder(view.findViewById(R.id.imageinfo).getContext());
//            builder.setTitle("Add Image");
//            builder.setMessage("Doctor :- If you are a doctor then put your image here \nDegree :- Put a photo of the degree you have obtained here");
//            builder.setPositiveButton("Ok", (dialogInterface, i) -> {
//            });
//            builder.show();
//        });

    }
}