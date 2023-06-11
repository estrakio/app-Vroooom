package com.applivroooom;

import android.content.Intent;
import android.os.Bundle;

import com.applivroooom.R.layout.*;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Handler;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Surcharger la classe onCreate
        super.onCreate(savedInstanceState);
        // Changer la page affiché
        setContentView(R.layout.splash_screen);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), Login.class);

                startActivity(intent);
                //setContentView(R.layout.login);
                finish();
            }
        };
        new Handler().postDelayed(runnable,3000);
    }


}