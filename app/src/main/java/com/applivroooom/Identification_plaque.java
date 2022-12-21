package com.applivroooom;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.applivroooom.data.DataVoiture;
import com.applivroooom.outils.AsyncResponse;

public class Identification_plaque extends AppCompatActivity {

    private DataVoiture dataVoiture;

    private EditText txtClientNom;
    private EditText txtClientPrenom;
    private EditText txt_datedebutlocation;
    private EditText txt_dureelocation;
    private EditText txt_datefinlocation;

    private EditText txt_plaque_d_immatriculation;
    private EditText txt_couleur;
    private EditText txt_idmarque;
    private EditText txt_nommodele;

    private RadioButton rdbtnconfirm;
    private Button btn_confirmer;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.identification_plaque);

        init();
        ecouteConfiramtion();
    }

    private void init() {
        dataVoiture = DataVoiture.getInstance(null);

        txtClientNom = findViewById(R.id.txt_client_nom);
        txtClientPrenom = findViewById(R.id.txt_client_prenom);
        txt_datedebutlocation = findViewById(R.id.txt_datedebutlocation);
        txt_dureelocation = findViewById(R.id.txt_dureelocation);
        txt_datefinlocation = findViewById(R.id.txt_datefinlocation);

        txt_plaque_d_immatriculation = findViewById(R.id.txt_plaque_d_immatriculation);
        txt_couleur = findViewById(R.id.txt_couleur);
        txt_idmarque = findViewById(R.id.txt_idmarque);
        txt_nommodele = findViewById(R.id.txt_nommodele);

        rdbtnconfirm = findViewById(R.id.rdbtnconfirm);
        btn_confirmer = findViewById(R.id.btn_confirmer);

        txtClientNom.setText(dataVoiture.getNom());
        txtClientPrenom.setText(dataVoiture.getPrenom());
        txt_datedebutlocation.setText(dataVoiture.getDatedebutlocation());
        txt_dureelocation.setText(dataVoiture.getDureelocation());
        txt_datefinlocation.setText(dataVoiture.getDatefinlocation());
        txtClientNom.setEnabled(false);
        txtClientPrenom.setEnabled(false);
        txt_datedebutlocation.setEnabled(false);
        txt_dureelocation.setEnabled(false);
        txt_datefinlocation.setEnabled(false);


        txt_plaque_d_immatriculation.setText(dataVoiture.getPlaque_d_immatriculation());
        txt_couleur.setText(dataVoiture.getCouleur());
        txt_idmarque.setText(dataVoiture.getIdmarque());
        txt_nommodele.setText(dataVoiture.getNommodele());
        txt_plaque_d_immatriculation.setEnabled(false);
        txt_couleur.setEnabled(false);
        txt_idmarque.setEnabled(false);
        txt_nommodele.setEnabled(false);

    }

    private void ecouteConfiramtion() {
        btn_confirmer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                
                if (rdbtnconfirm.isChecked()) {
                    Intent intent = new Intent(getApplicationContext(), Rapport.class);
                    startActivity(intent);
                    finish();   
                } else {
                    Toast.makeText(Identification_plaque.this, "Veuillez confirmer", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
