package com.example.test;

import android.content.Intent;
import android.os.Bundle;

import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

public class Splashactivity extends AppCompatActivity {
    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Thread td =new Thread(){
            public void run(){
                try {
                 sleep(5000);
                }catch (Exception e){
                 e.printStackTrace();
                }
                finally {
                    Intent i =new Intent(Splashactivity.this,MainActivity.class);
                    startActivity(i);
                    finish(); }
            }
        };td.start();
    }
}
