package com.example.careandcure;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class HospitalRegister extends AppCompatActivity {

    AppCompatButton update;
    ImageView imageinfo;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_register);

        update = findViewById(R.id.update);
        update.setOnClickListener(v -> update.setBackgroundColor(Color.GREEN));

        imageinfo = findViewById(R.id.imageinfo);
        imageinfo.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(view.findViewById(R.id.imageinfo).getContext());
            builder.setTitle("Add Image");
            builder.setMessage("Doctor :- If you are a doctor then put your image here \nDegree :- Put a photo of the degree you have obtained here");
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            });
        builder.show();
        });




    }
}