package com.example.news;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.Objects;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Objects.requireNonNull(getSupportActionBar()).hide();

       Thread  thread=new Thread(){
            public void run(){
                try {
                    sleep(3000);
                    finish();
                }
                catch (Exception e){
                    // mother of each exceptions
                    e.printStackTrace();
                }
                finally {
                    Intent intent=new Intent(SplashActivity.this,Dashboard.class);
                    startActivity(intent);
                }
            }
        };thread.start();
    }
}