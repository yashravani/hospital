package com.example.careandcure.LoginAndRegister;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.careandcure.DoctorLoginHome;
import com.example.careandcure.Login;
import com.example.careandcure.PatientLoginHome;
import com.example.careandcure.R;
import com.example.careandcure.otp.DoctorOtp;
import com.example.careandcure.otp.PatientOtp;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class DoctorLogin extends AppCompatActivity {

    ImageView arrowback;
    AppCompatButton loginbutton;
    TextInputEditText textphonedoctor;


    @SuppressLint({"MissingInflatedId", "CutPasteId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doctor_login);

        arrowback = findViewById(R.id.arrowback);
        loginbutton = findViewById(R.id.loginbutton);
        textphonedoctor = findViewById(R.id.textphonedoctor);
        final ProgressBar progressBar = findViewById(R.id.progress);

        TextInputLayout phoneInputLayout = findViewById(R.id.textinputdoctor);
        phoneInputLayout.setPrefixText("+91 ");

        loginbutton.setOnClickListener(view -> {
            if (!Objects.requireNonNull(textphonedoctor.getText()).toString().trim().isEmpty()) {
                if ((textphonedoctor.getText().toString().trim()).length() == 10) {

                    progressBar.setVisibility(View.VISIBLE);
                    loginbutton.setVisibility(View.INVISIBLE);

                    PhoneAuthProvider.getInstance().verifyPhoneNumber(
                            "+91" + textphonedoctor.getText().toString(),
                            60,
                            TimeUnit.SECONDS,
                            DoctorLogin.this,
                            new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                                @Override
                                public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                                    progressBar.setVisibility(View.GONE);
                                    loginbutton.setVisibility(View.VISIBLE);
                                }

                                @Override
                                public void onVerificationFailed(@NonNull FirebaseException e) {
                                    progressBar.setVisibility(View.GONE);
                                    loginbutton.setVisibility(View.VISIBLE);
                                    Toast.makeText(DoctorLogin.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                }

                                @Override
                                public void onCodeSent(@NonNull String backendotp, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                                    super.onCodeSent(backendotp, forceResendingToken);
                                    progressBar.setVisibility(View.GONE);
                                    loginbutton.setVisibility(View.VISIBLE);
                                    Intent intent = new Intent(getApplicationContext(), DoctorOtp.class);
                                    intent.putExtra("textphonedoctor", Objects.requireNonNull(textphonedoctor.getText()).toString());
                                    intent.putExtra("backendotp", backendotp);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                                    startActivity(intent);
                                }
                            }
                    );
                } else {
                    Toast.makeText(DoctorLogin.this, "Enter Proper Number", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(DoctorLogin.this, "Enter Mobile Number", Toast.LENGTH_SHORT).show();
            }
        });

        arrowback.setOnClickListener(view -> {
            Intent intent = new Intent(DoctorLogin.this, Login.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
        });

    }
}