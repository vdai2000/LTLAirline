package com.example.bookingfilght.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.bookingfilght.R;

public class AnimationSearchFlightActivity extends AppCompatActivity {

    TextView txtBooking;
    LottieAnimationView lottie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_search_flight);

        txtBooking = findViewById(R.id.txtBooking);
        lottie = findViewById(R.id.lottie);

        Intent intent = getIntent();
        String ngay_di = intent.getStringExtra("ngay_di");
        String noi_di = intent.getStringExtra("noi_di");
        String noi_den = intent.getStringExtra("noi_den");
        String loai_ve = intent.getStringExtra("loaive");

        txtBooking.animate().translationY(-1400).setDuration(2700).setStartDelay(0);
        lottie.animate().translationX(2000).setDuration(2000).setStartDelay(2900);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent1 = new Intent(AnimationSearchFlightActivity.this, ResultSearchActivity.class);
                intent1.putExtra("ngay_di", ngay_di);
                intent1.putExtra("noi_di", noi_di);
                intent1.putExtra("noi_den", noi_den);
                intent1.putExtra("loaive", loai_ve);

                startActivity(intent1);
            }
        }, 5000);

    }
}