package com.example.careandcure;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.careandcure.Adapter.MpagerAdapter;

import java.util.Timer;
import java.util.TimerTask;

public class Splash1 extends AppCompatActivity {

    AppCompatButton btnRegister;
    TextView logintext, logintext1;
    private ViewPager mPager;
    private final int[] layouts = {R.layout.first_slide, R.layout.second_slide, R.layout.third_slide, R.layout.fourth_slide};
    private LinearLayout Dots_Layout;
    private int current_position = 0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash1);

//        logintext = findViewById(R.id.logintext);
//        logintext1 = findViewById(R.id.logintext1);
        btnRegister = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(view -> {
            Intent intent = new Intent(Splash1.this, PatientAndHospital.class);
            startActivity(intent);
        });

//        logintext.setOnClickListener(view -> {
//            Intent intent = new Intent(Splash1.this, LoginActivity.class);
//            startActivity(intent);
//        });

//        logintext1.setOnClickListener(view -> {
//            Intent intent = new Intent(Splash1.this, LoginActivity.class);
//            startActivity(intent);
//        });
//        if (Build.VERSION.SDK_INT>=19){
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//        }else {
//            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//        }

        mPager = (ViewPager) findViewById(R.id.viewPager);
        MpagerAdapter mpagerAdapter = new MpagerAdapter(layouts, this);
        mPager.setAdapter(mpagerAdapter);

        Dots_Layout = (LinearLayout) findViewById(R.id.dotsLayout);
        createDots(0);

        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                createDots(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        createSlideShow();

    }

    private void createDots(int current_position) {
        if (Dots_Layout != null) {
            Dots_Layout.removeAllViews();
            ImageView[] dots = new ImageView[layouts.length];

            for (int i = 0; i < layouts.length; i++) {
                dots[i] = new ImageView(this);
                if (i == current_position) {
                    dots[i].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.active_dots));
                } else {
                    dots[i].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.default_dots));
                }

                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
                params.setMargins(4, 0, 4, 0);

                Dots_Layout.addView(dots[i], params);

            }
        }
    }

    private void createSlideShow() {

        final Handler handler = new Handler();
        final Runnable runnable = () -> {
            if (current_position == layouts.length)
                current_position = 0;
            mPager.setCurrentItem(current_position++, true);
        };

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                handler.post(runnable);

            }
        }, 250, 4000);

    }

}