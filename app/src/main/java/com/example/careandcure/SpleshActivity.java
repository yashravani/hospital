package com.example.careandcure;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SpleshActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splesh);

        new Handler().postDelayed(() -> {
            startActivity(new Intent(SpleshActivity.this, Splash1.class));
            finish();
//        }, 5094);
        }, 125);
    }
}
