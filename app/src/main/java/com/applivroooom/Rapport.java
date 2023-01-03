package com.applivroooom;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Rapport extends AppCompatActivity {

    private Button btn_ajout;
    private Button btn_envoyer;
    private LinearLayout lyt_expertise;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rapport);

        init();
        //ecouteConfiramtion();
    }

    private void init() {
        btn_ajout = findViewById(R.id.btn_ajout);
        btn_envoyer = findViewById(R.id.btn_envoyer);
        lyt_expertise = findViewById(R.id.lyt_scroll);

    }

}
