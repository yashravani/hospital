package com.example.careandcure;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DoctorHome extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    FrameLayout frameLayout;


    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_home);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        frameLayout = findViewById(R.id.frameLayout);

        //noinspection deprecation
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.patient:
                    loadFrag(new FragmentDoctorPatient(), false);
                    break;
                case R.id.profile:
                    loadFrag(new FragmentDoctorProfile(), false);
                    break;
                default:
                    break;
            }

            return true;
        });
        bottomNavigationView.setSelectedItemId(R.id.home);
    }

    public void loadFrag(Fragment fragment, boolean flag) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if (flag) {
            ft.add(R.id.frameLayout, fragment);
        } else {
            ft.replace(R.id.frameLayout, fragment);
        }
        ft.commit();
    }
}

