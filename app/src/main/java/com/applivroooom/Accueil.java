package com.applivroooom;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.applivroooom.data.DataExpert;
import com.applivroooom.outils.AccesHTTP;
import com.applivroooom.outils.AsyncResponse;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Accueil extends AppCompatActivity implements AsyncResponse {
    private static final String PLAQUEADDR = "http://192.168.1.6/appMobile/dataVehicule.php";


    private DataExpert dataExpert;
    private TextView textAcceuil;
    private EditText immatriculation;
    private Button btnImmatriculation;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accueil);

        init();
        ecoutePlaque();
        Log.d("dataexpert", "onCreate: "+ dataExpert.getPrenom()+dataExpert.getNom());
    }

    private void init() {
        dataExpert = DataExpert.getInstance(null);

        textAcceuil = findViewById(R.id.message_accueil);
        immatriculation = findViewById(R.id.immatriculation);
        btnImmatriculation = findViewById(R.id.btn_immatriculation);

        textAcceuil.setText("Bonjour Monsieur "+dataExpert.getNom()+" "+dataExpert.getPrenom());
    }

    private void ecoutePlaque() {
        btnImmatriculation.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String plaque = immatriculation.toString();

                //JSONArray json_array = new JSONArray(list);
                Log.d("plaque", "onClick: "+ plaque);

                requestVehicule(plaque);

            }
        });
    }

    private void requestVehicule(String donnee) {
        Log.d("plaquerequest", "requestLogin: "+ donnee);

        AccesHTTP accesDonnees = new AccesHTTP();
        accesDonnees.delegate = this;

        accesDonnees.addParams("plaque", donnee);

        accesDonnees.execute(PLAQUEADDR);
    }

    @Override
    public void processFinish(String output) {
        Log.d("serveurplaque", "processFinish: "+ output);

        try {
            JSONObject reponse = new JSONObject(output);

            if (!reponse.getString("dataVehicule").equals("False")) {
                Log.d("plaque", "login successful");

                //DataExpert dataExpert = DataExpert.getInstance(output);

                Log.d("plaque success", "nom Expert: " + dataExpert.getNom());
                Log.d("plaque success", "prenom Expert: " + dataExpert.getPrenom());

                //Intent intent = new Intent(getApplicationContext(), Accueil.class);
                //startActivity(intent);
                finish();
            } else {
                Toast.makeText(this, "Mot de passe ou indentifiant incorect", Toast.LENGTH_SHORT).show();
            }
        } catch (JSONException e) {
            e.printStackTrace();
            Log.d("erreur", "erreurJSON: " +e);
        }


    }
}
