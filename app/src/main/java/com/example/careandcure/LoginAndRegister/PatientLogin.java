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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.careandcure.Login;
import com.example.careandcure.PatientLoginHome;
import com.example.careandcure.R;
import com.example.careandcure.otp.PatientOtp;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class PatientLogin extends AppCompatActivity {
    ImageView arrowback;
    AppCompatButton loginbutton;
    TextInputEditText textphonepatient;

    @SuppressLint({"MissingInflatedId", "LocalSuppress"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patient_login);

        TextInputLayout phoneInputLayout = findViewById(R.id.textinputpatient);
        phoneInputLayout.setPrefixText("+91 ");

        textphonepatient = findViewById(R.id.textphonepatient);
        arrowback = findViewById(R.id.arrowback);
        loginbutton = findViewById(R.id.loginbutton);
        final ProgressBar progressBar = findViewById(R.id.progress);

        loginbutton.setOnClickListener(view -> {
            if (!Objects.requireNonNull(textphonepatient.getText()).toString().trim().isEmpty()) {
                if ((textphonepatient.getText().toString().trim()).length() == 10) {
                    progressBar.setVisibility(View.VISIBLE);
                    PhoneAuthProvider.getInstance().verifyPhoneNumber(
                            "+91" + textphonepatient.getText().toString(),
                            60,
                            TimeUnit.SECONDS,
                            PatientLogin.this,
                            new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                                @Override
                                public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                                    progressBar.setVisibility(View.GONE);
                                }

                                @Override
                                public void onVerificationFailed(@NonNull FirebaseException e) {
                                    progressBar.setVisibility(View.GONE);
                                    Toast.makeText(PatientLogin.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                }

                                @Override
                                public void onCodeSent(@NonNull String backendotp, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                                    super.onCodeSent(backendotp, forceResendingToken);
                                    progressBar.setVisibility(View.GONE);
                                    loginbutton.setVisibility(View.VISIBLE);
                                    Intent intent = new Intent(getApplicationContext(), PatientOtp.class);
                                    intent.putExtra("textphonepatient", Objects.requireNonNull(textphonepatient.getText()).toString());
                                    intent.putExtra("backendotp", backendotp);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                                    startActivity(intent);
                                }
                            }
                    );
                } else {
                    Toast.makeText(PatientLogin.this, "Enter Proper Number", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(PatientLogin.this, "Enter Mobile Number", Toast.LENGTH_SHORT).show();
            }
        });

        arrowback.setOnClickListener(view -> {
            Intent intent = new Intent(PatientLogin.this, Login.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
        });
    }
}