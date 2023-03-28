package com.example.careandcure.otp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.careandcure.LoginAndRegister.PatientLogin;
import com.example.careandcure.PatientLoginHome;
import com.example.careandcure.R;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class PatientOtp extends AppCompatActivity {
    ImageView arrowback;
    AppCompatButton verifybutton;
    EditText otpbox, otpbox1, otpbox2, otpbox3, otpbox4, otpbox5;
    String getotpbackend;
    TextView resendotp, resendotp1;
    private CountDownTimer countDownTimer;
    private TextView tvTimer;


    @SuppressLint({"MissingInflatedId", "LocalSuppress"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patient_login_otp);

        tvTimer = findViewById(R.id.tv_timer);
        countDownTimer = new CountDownTimer(60000, 1000) {
            @SuppressLint("SetTextI18n")
            public void onTick(long millisUntilFinished) {
                int secondsRemaining = (int) (millisUntilFinished / 1000);
                if (secondsRemaining > 10) {
                    tvTimer.setTextColor(Color.BLACK);
                } else {
                    tvTimer.setTextColor(Color.RED);
                }
                tvTimer.setText("Time remaining: " + secondsRemaining);
                resendotp.setVisibility(View.INVISIBLE);
                resendotp1.setVisibility(View.INVISIBLE);
            }

            public void onFinish() {
                tvTimer.setVisibility(View.INVISIBLE);
                resendotp.setVisibility(View.VISIBLE);
                resendotp1.setVisibility(View.VISIBLE);
            }
        }.start();

        TextView textView = findViewById(R.id.textmobilepatient);
        textView.setText(String.format("+91-%s", getIntent().getStringExtra("textphonepatient")));

        arrowback = findViewById(R.id.arrowback);
        arrowback.setOnClickListener(view -> {
            Intent intent = new Intent(PatientOtp.this, PatientLogin.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
            finish();
        });

        otpbox = findViewById(R.id.otpbox);
        otpbox1 = findViewById(R.id.otpbox1);
        otpbox2 = findViewById(R.id.otpbox2);
        otpbox3 = findViewById(R.id.otpbox3);
        otpbox4 = findViewById(R.id.otpbox4);
        otpbox5 = findViewById(R.id.otpbox5);

        final ProgressBar progressBar = findViewById(R.id.progress);
        
        verifybutton = findViewById(R.id.verifybutton);
        verifybutton.setOnClickListener(view -> {
            if (!otpbox.getText().toString().trim().isEmpty() && !otpbox1.getText().toString().trim().isEmpty()
                    && !otpbox2.getText().toString().trim().isEmpty() && !otpbox3.getText().toString().trim().isEmpty()
                    && !otpbox4.getText().toString().trim().isEmpty() && !otpbox5.getText().toString().trim().isEmpty()) {

                String entercodeotp = otpbox.getText().toString() +
                        otpbox1.getText().toString() +
                        otpbox2.getText().toString() +
                        otpbox3.getText().toString() +
                        otpbox4.getText().toString() +
                        otpbox5.getText().toString();

                if (getotpbackend != null) {
                    progressBar.setVisibility(View.VISIBLE);
                    verifybutton.setVisibility(View.INVISIBLE);

                    PhoneAuthCredential phoneAuthCredential = PhoneAuthProvider.getCredential(
                            getotpbackend, entercodeotp
                    );
                    FirebaseAuth.getInstance().signInWithCredential(phoneAuthCredential)
                            .addOnCompleteListener(task -> {
                                progressBar.setVisibility(View.GONE);
                                verifybutton.setVisibility(View.VISIBLE);

                                if (task.isSuccessful()) {
                                    Toast.makeText(PatientOtp.this, "OTP Verify", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(PatientOtp.this, PatientLoginHome.class);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                                    startActivity(intent);
                                } else {
                                    Toast.makeText(PatientOtp.this, "Enter Valid OTP", Toast.LENGTH_SHORT).show();
                                }
                            });
                }
            } else {
                Toast.makeText(this, "Please Enter OTP", Toast.LENGTH_SHORT).show();
            }
        });

        numberotpmove();

        resendotp = findViewById(R.id.resendotp);
        resendotp1 = findViewById(R.id.resendotp1);

        resendotp1.setOnClickListener(view -> PhoneAuthProvider.getInstance().verifyPhoneNumber(
                "+91" + getIntent().getStringExtra("textphonepatient"),
                60,
                TimeUnit.SECONDS,
                PatientOtp.this,
                new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                    @Override
                    public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {

                    }

                    @Override
                    public void onVerificationFailed(@NonNull FirebaseException e) {
                        Toast.makeText(PatientOtp.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCodeSent(@NonNull String newbackendotp, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                        super.onCodeSent(newbackendotp, forceResendingToken);
                        getotpbackend = newbackendotp;
                        Toast.makeText(PatientOtp.this, "OTP send Successfully", Toast.LENGTH_SHORT).show();
                    }
                }
        ));

        resendotp.setOnClickListener(view -> PhoneAuthProvider.getInstance().verifyPhoneNumber(
                "+91" + getIntent().getStringExtra("textphonepatient"),
                60,
                TimeUnit.SECONDS,
                PatientOtp.this,
                new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                    @Override
                    public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {

                    }

                    @Override
                    public void onVerificationFailed(@NonNull FirebaseException e) {
                        Toast.makeText(PatientOtp.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCodeSent(@NonNull String newbackendotp, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                        super.onCodeSent(newbackendotp, forceResendingToken);
                        getotpbackend = newbackendotp;
                        Toast.makeText(PatientOtp.this, "OTP send Successfully", Toast.LENGTH_SHORT).show();
                    }
                }
        ));

        getotpbackend = getIntent().getStringExtra("backendotp");

    }

    private void numberotpmove() {
        otpbox.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!charSequence.toString().trim().isEmpty()) {
                    otpbox1.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        otpbox1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!charSequence.toString().trim().isEmpty()) {
                    otpbox2.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        otpbox2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!charSequence.toString().trim().isEmpty()) {
                    otpbox3.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        otpbox3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!charSequence.toString().trim().isEmpty()) {
                    otpbox4.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        otpbox4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!charSequence.toString().trim().isEmpty()) {
                    otpbox5.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }

}