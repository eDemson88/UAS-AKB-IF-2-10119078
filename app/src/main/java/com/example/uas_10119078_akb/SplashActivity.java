package com.example.uas_10119078_akb;
//NIM : 10119078
//Nama : Adam Firdaus Darmawan
//Kelas : IF-2
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.uas_10119078_akb.ui.viewpager.ViewPagerActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getSupportActionBar().hide();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), ViewPagerActivity.class));
                finish();
            }
        }, 2000l);
    }
}