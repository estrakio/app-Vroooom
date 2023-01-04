package com.applivroooom;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.applivroooom.data.Dossier;
import com.applivroooom.data.Expertise;

import java.util.ArrayList;

public class Rapport extends AppCompatActivity {

    private Button btn_ajout;
    private Button btn_envoyer;
    private LinearLayout lyt_expertise;

    private Dossier dossier;


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

        dossier = Dossier.getInstance();

        if (dossier != null) {
            affiche_les_expertise((ArrayList<Expertise>) dossier.getList_expertise());
        }
    }

    private void affiche_les_expertise(ArrayList<Expertise> ls) {
        for (Expertise expertise: ls) {

            TextView nom_piece = new TextView(this);
            nom_piece.setText(expertise.getNom_piece().toString());
            nom_piece.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));

            lyt_expertise.addView(nom_piece);

            TextView description = new TextView(this);
            description.setText(expertise.getDescription().toString());
            description.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));

            lyt_expertise.addView(description);
        }
    }

    private void ecouteEnvoie() {

    }

    private void ecouteCreateExpertise() {
        btn_ajout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Toast.makeText(Rapport.this, "exp", Toast.LENGTH_SHORT).show();

//                Expertise expertise = Expertise.getInstance();

                Intent intent = new Intent(getApplicationContext(), New_expertise.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
