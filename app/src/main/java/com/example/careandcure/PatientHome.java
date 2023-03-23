package com.example.careandcure;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.FrameLayout;


import com.google.android.material.bottomnavigation.BottomNavigationView;

public class PatientHome extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    FrameLayout frameLayout;

    @SuppressLint({"MissingInflatedId", "NonConstantResourceId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patient_login_home);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        frameLayout = findViewById(R.id.frameLayout);

        //noinspection deprecation
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.home:
                    loadFrag(new FragPatientHome(), false);
                    break;
                case R.id.payment:
                    loadFrag(new FragPatientPayment(), false);
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