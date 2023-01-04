package com.applivroooom;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.applivroooom.data.Dossier;
import com.applivroooom.data.Expertise;

public class New_expertise extends AppCompatActivity {

    private EditText txt_piece;
    private EditText txt_description;
    private Button btn_photo;
    private Button btn_valider;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_expertise);

        init();
        ecouteEnvoie();
        ecoutePhoto();
    }

    private void init() {
        btn_photo = findViewById(R.id.btn_photo);
        btn_valider = findViewById(R.id.btn_valider);
        txt_piece = findViewById(R.id.edtxt_piece);
        txt_description = findViewById(R.id.edtxt_description);
    }

    private void ecoutePhoto() {
        btn_photo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Toast.makeText(New_expertise.this, "photo", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void ecouteEnvoie() {
        btn_valider.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

//                Toast.makeText(New_expertise.this, "Envoie", Toast.LENGTH_SHORT).show();

                Dossier dossier = Dossier.new_dossier();
                Expertise expertise = Expertise.new_expertise();


                expertise.setPiece(txt_piece.getText().toString());
                Log.d("expertise", "onClick: "+ expertise.getPiece().toString());
                expertise.setDescription(txt_description.getText().toString());
                Log.d("expertise", "onClick: "+ expertise.getDescription().toString());
                expertise.setLienphoto(btn_photo.getText().toString());

                dossier.add_expertise(expertise);

                Log.d("dossier", "onClick: "+ dossier.getList_expertise().get(0).getPiece().toString());

                Intent intent = new Intent(getApplicationContext(), Rapport.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
