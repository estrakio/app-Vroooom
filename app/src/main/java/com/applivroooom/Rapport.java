package com.applivroooom;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

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
//        ecouteEnvoie();
        ecouteCreateExpertise();
    }

    private void init() {
        btn_ajout = findViewById(R.id.btn_ajout);
        btn_envoyer = findViewById(R.id.btn_envoyer);
        lyt_expertise = findViewById(R.id.lyt_scroll);

    }

    private void ecouteEnvoie() {

    }

    private void ecouteCreateExpertise() {
        btn_ajout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Toast.makeText(Rapport.this, "exp", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), New_expertise.class);
                startActivity(intent);
//                finish();
            }
        });
    }
}
