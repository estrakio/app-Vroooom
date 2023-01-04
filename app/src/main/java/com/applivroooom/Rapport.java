package com.applivroooom;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.applivroooom.data.DataVoiture;
import com.applivroooom.data.Dossier;
import com.applivroooom.data.Expertise;
import com.applivroooom.outils.AccesHTTP;
import com.applivroooom.outils.AsyncResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Rapport extends AppCompatActivity implements AsyncResponse {
    private static final String DOSSIERADR = "http://192.168.1.6/appMobile/createDossier.php";

    private Button btn_ajout;
    private Button btn_envoyer;
    private LinearLayout lyt_expertise;

    private Dossier dossier;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rapport);

        init();
        ecouteEnvoie();
        ecouteCreateExpertise();
    }

    private void init() {
        btn_ajout = findViewById(R.id.btn_ajout);
        btn_envoyer = findViewById(R.id.btn_envoyer);
        lyt_expertise = findViewById(R.id.lyt_scroll);

        dossier = Dossier.getInstance();
        get_dossier();

        if (dossier != null) {
            affiche_les_expertise((ArrayList<Expertise>) dossier.getList_expertise());
        }
    }

    private void affiche_les_expertise(ArrayList<Expertise> ls) {
        for (Expertise expertise: ls) {

            TextView nom_piece = new TextView(this);
            nom_piece.setText(expertise.getPiece().toString());
            nom_piece.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));

            lyt_expertise.addView(nom_piece);

            TextView description = new TextView(this);
            description.setText(expertise.getDescription().toString());
            description.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));

            lyt_expertise.addView(description);
        }
    }

    private void ecouteCreateExpertise() {
        btn_ajout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//                Toast.makeText(Rapport.this, "exp", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), New_expertise.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void ecouteEnvoie() {
        btn_envoyer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (dossier != null) {
                    envoieDossier(dossier);
                }
            }
        });
    }

    private void envoieDossier(Dossier dossier) {
//        Log.d("request", "requestLogin: "+ donnee.get(0) + donnee.get(1));

        AccesHTTP accesDonnees = new AccesHTTP();
        accesDonnees.delegate = this;

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        try {
            String dossierJson = ow.writeValueAsString(dossier);

            Log.d("doss", "envoieDossier: " + dossierJson);
            Log.d("doss", "envoieDossier: "+ DataVoiture.getInstance(null).getPlaque_d_immatriculation().toString());

            accesDonnees.addParams("dossier", dossierJson);
            accesDonnees.addParams("plaque", DataVoiture.getInstance(null).getPlaque_d_immatriculation().toString());

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        accesDonnees.execute(DOSSIERADR);
    }

    private void get_dossier() {
//        Log.d("request", "requestLogin: "+ donnee.get(0) + donnee.get(1));

        AccesHTTP accesDonnees = new AccesHTTP();
        accesDonnees.delegate = this;

        accesDonnees.addParams("plaque", DataVoiture.getInstance(null).getPlaque_d_immatriculation().toString());

        accesDonnees.execute(DOSSIERADR);
    }

    @Override
    public void processFinish(String output) {
        Log.d("serveurDossier", "processFinish: "+ output);

        try {
            JSONObject reponse = new JSONObject(output);

            if (reponse.getString("state").equals("get dossier")) {
                Log.d("dossier", "dossier sent successfuly");

                dossier = Dossier.new_dossier(output);

                Log.d("dossiersuccess", "dossier: " + output);

//            } else if (reponse.getString("state").equals("pas de dossier")) {

            }
        } catch (JSONException e) {
            e.printStackTrace();
            Log.d("erreur", "erreurJSON: " +e);
        }


    }
}
